package com.jackyshen.id;

import java.util.concurrent.atomic.AtomicLong;

import lombok.extern.slf4j.Slf4j;

/**
 * 1bit          + 41bit                    + 5bit         + 5bit          + 12bit
 * |                |                         |               |                |
 * |                |                         |               |                |
 * sign bit   timestamp (in milliseconds)   data center    machine code    sequence
 * The first is sign bit. 0 is positive number.
 * 2-42 bit is use timestamp(current time - initial time), The 41-bit timestamp can be used for 69 years.  
 * 43-47 bit is use data center and 48-52 is use machine code. 
 * 53-64 bit is use self-increasing sequence number, support for the same node in the same millisecond can generate 4096 ids.     
 * 
 * @author Jackyshen
 *
 */
@Slf4j
public class SnowflakeIdWorker {

  /**
   * The initial timestamp(2018-01-01).
   */
  private final static long START_STAMP = 1514736000000L;

  /**
   * The number of bits per part.
   */
  private final static long SEQUENCE_BIT = 12; // The number of digits in the sequence.
  private final static long MACHINE_BIT = 5; // The number of digits the machine identifies
  private final static long DATACENTER_BIT = 5;// The number of digits occupied by the data center.

  /**
   * The maximum of each part.
   */
  private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
  private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
  private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

  /**
   * The left displacement of each part.
   */
  private final static long MACHINE_LEFT = SEQUENCE_BIT;
  private final static long DATACENTER_LEFT = MACHINE_LEFT + MACHINE_BIT;
  private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

  private long datacenterId; // data center id
  private long machineId; // machine code
  private long sequence = 0L;// sequence
  private AtomicLong al = new AtomicLong(0L);
  private long lastTimestamp = -1L;

  public SnowflakeIdWorker(long datacenterId, long machineId) {
    if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
      throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
    }
    if (machineId > MAX_MACHINE_NUM || machineId < 0) {
      throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
    }
    this.datacenterId = datacenterId;
    this.machineId = machineId;
  }

  public Long nextId() {
    long currStamp = timeGen();
    if (currStamp < lastTimestamp) {
      throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - currStamp));
    }

    if (lastTimestamp == currStamp) {
      // 序列号 = 上次序列号+1 与 生成序列的掩码
      sequence = (sequence + 1) & MAX_SEQUENCE;
      // The sequence overflows in milliseconds.
      if (sequence == 0) {
        // block to the next millisecond and get a new timestamp.
        currStamp = tilNextMillis(lastTimestamp);
      }
    } else {
      sequence = 0L;
    }

    lastTimestamp = currStamp;

    return (currStamp - START_STAMP) << TIMESTMP_LEFT // timestamp
        | datacenterId << DATACENTER_LEFT // data center
        | machineId << MACHINE_LEFT // machine id
        | sequence; // sequence
  }

  @SuppressWarnings("unused")
  private long sequenceGen() {
    long sequence = this.al.incrementAndGet();
    log.debug("get sequence : {}", sequence);
    if (sequence > MAX_SEQUENCE) {
      log.debug("sequence > MAX_SEQUENCE({}), then reset sequence...", MAX_SEQUENCE);
      // reset to 0 if the maximum serial number is exceeded.
      if (!this.al.compareAndSet(sequence, 0)) {
        // 这里使用CAS操作，所以不需要加锁
        sequence = this.al.incrementAndGet();
      } else {
        // 操作成功后，则序列号为0了
        sequence = 0;
      }
      log.debug("after reset sequence : {}", sequence);
    }
    return sequence;
  }

  private long tilNextMillis(long lastTimestamp) {
    long timestamp = timeGen();
    while (timestamp <= lastTimestamp) {
      timestamp = timeGen();
    }
    return timestamp;
  }

  private long timeGen() {
    return System.currentTimeMillis();
  }
}
