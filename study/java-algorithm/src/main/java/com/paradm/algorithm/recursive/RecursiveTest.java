package com.paradm.algorithm.recursive;

import java.util.Scanner;

public class RecursiveTest {

  public static int fibonacci(int n) {
    if (n == 1 || n == 2) {
      return 1;
    } else {
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }

  public static void main(String[] args) {
    System.out.println("�����㷨������Ӳ�������!");
    System.out.print("��������ʱ��:");
    try (Scanner input = new Scanner(System.in)) {
      int n = input.nextInt();
      int num = fibonacci(n);
      System.out.println("����" + n + "���µ�ʱ�䣬���ܷ�ֳ��" + num + "������!");
    }
  }

}
