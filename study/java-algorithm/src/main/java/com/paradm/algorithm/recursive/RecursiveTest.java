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
    System.out.println("递推算法求解兔子产仔问题!");
    System.out.print("请先输入时间:");
    try (Scanner input = new Scanner(System.in)) {
      int n = input.nextInt();
      int num = fibonacci(n);
      System.out.println("经过" + n + "个月的时间，共能繁殖成" + num + "对兔子!");
    }
  }

}
