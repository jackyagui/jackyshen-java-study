package com.paradm.algorithm.exhaustivity;

import java.util.Scanner;

public class ExhaustivityTest {

  static int chichen, habbit;

  public static int exhaustivity(int head, int foot) {
    int re = 0, j;
    for (int i = 0; i <= head; i++) {
      j = head - i;
      if (i * 2 + j * 4 == foot) {
        re = 1;
        chichen = i;
        habbit = j;
      }
    }
    return re;
  }

  public static void main(String[] args) {
    int head, foot;
    System.out.println("穷举法求解鸡兔同笼问题!");
    System.out.print("请输入头数:");
    try (Scanner input = new Scanner(System.in)) {
      head = input.nextInt();
      System.out.print("请输入脚数:");
      foot = input.nextInt();
      if (exhaustivity(head, foot) == 1) {
        System.out.println("鸡有" + chichen + "只，兔有" + habbit + "只。");
      } else {
        System.out.println("无法求解!");
      }
    }
  }

}
