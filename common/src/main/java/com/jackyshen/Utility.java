package com.jackyshen;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utility {

  public static boolean isEmpty(String str) {
    return (null == str || "".equals(str) || "".equals(str.trim()));
  }

  public static boolean isEmpty(StringBuffer sb) {
    return (null == sb || sb.length() == 0 || "".equals(sb.toString().trim()));
  }

  public static boolean isEmpty(Object[] array) {
    return (null == array || array.length == 0);
  }

  public static boolean isEmpty(Object obj) {
    return (null == obj);
  }

  public static <T> boolean isEmpty(Collection<T> c) {
    return (null == c || c.isEmpty());
  }

  public static Integer parseInteger(String in) {
    try {
      return (Integer.valueOf(in));
    } catch (Exception e) {
      return (null);
    }
  }

  public static int parseInt(String in) {
    try {
      return Integer.valueOf(in).intValue();
    } catch (Exception e) {
      return 0;
    }
  }

  public static Long parseLong(String in) {
    try {
      return (Long.valueOf(in));
    } catch (Exception e) {
      return (null);
    }
  }

  public static long parseLongValue(String in) {
    try {
      return (Long.valueOf(in)).longValue();
    } catch (Exception e) {
      return 0;
    }
  }

  public static Date parseDatetime(String inStr, String format) {
    if (Utility.isEmpty(inStr)) {
      return (null);
    }
    Date tmpDate = null;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale("en", "US"));
      tmpDate = sdf.parse(inStr);
      return (new Date(tmpDate.getTime()));
    } catch (ParseException pe) {
      return (null);
    }
  }

  public static Timestamp parseTimestamp(String timeStr, String format) {
    if (timeStr == null) {
      return null;
    }
    Date tmpDate = null;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale("en", "US"));
      tmpDate = sdf.parse(timeStr);
      return new Timestamp(tmpDate.getTime());
    } catch (java.text.ParseException e) {
      return null;
    }
  }

  public static Locale parseLocaleString(String localeString) {
    try {
      if (Utility.isEmpty(localeString)) {
        return null;
      }
      return StringUtils.parseLocaleString(localeString);
    } catch (Exception e) {
      return null;
    }
  }

  public static String formatInteger(Integer intValue) {
    if (isEmpty(intValue)) {
      return "";
    }
    return (String.valueOf(intValue));
  }

  public static String formatLong(Long longValue) {
    if (isEmpty(longValue)) {
      return "";
    }
    return (String.valueOf(longValue));
  }

  public static String formatDate(Date timestamp, String format) {
    if (timestamp == null) {
      return "";
    }
    SimpleDateFormat sdf = new SimpleDateFormat(format, new Locale("en", "US"));
    String dateStr = sdf.format(timestamp);
    return dateStr;
  }

  public static void closeStream(Closeable closeable) {
    if (!isEmpty(closeable)) {
      try {
        closeable.close();
      } catch (IOException e) {
        closeable = null;
        log.error(e.getMessage(), e);
      }
    }
  }
}
