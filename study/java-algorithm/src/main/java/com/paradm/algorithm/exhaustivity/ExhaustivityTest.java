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
    System.out.println("��ٷ���⼦��ͬ������!");
    System.out.print("������ͷ��:");
    try (Scanner input = new Scanner(System.in)) {
      head = input.nextInt();
      System.out.print("���������:");
      foot = input.nextInt();
      if (exhaustivity(head, foot) == 1) {
        System.out.println("����" + chichen + "ֻ������" + habbit + "ֻ��");
      } else {
        System.out.println("�޷����!");
      }
    }
  }

}
