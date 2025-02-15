package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 問題1:Javaの基本構文を使用して、計算機プログラムを作成してください。加減乗除の四則演算ができ、 ユーザーから入力を受け取り、結果を表示するものとします。
 */
public class Calculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true){

      try {

        System.out.println("最初の数値を入力して下さい。");

        int firstNum = scanner.nextInt(); //最初の数値を入力

        System.out.println("(+,-,*,/)の中から演算子を入力して下さい");
        char operator = scanner.next().charAt(0);

        System.out.println("次の数値を入力して下さい。");

        int secondNum = scanner.nextInt(); //次の数値を入力

        int result = 0;

        switch (operator) {
          case '+': //足し算
            result = firstNum + secondNum;
            break;

          case '-': //引き算
            result = firstNum - secondNum;
            break;

          case '*': // 掛け算
            result = firstNum * secondNum;
            break;

          case '/': // 割り算
            result = firstNum / secondNum;
            break;

          default:
            System.out.println("不正な数値が入力されたので、正しい数値を入力して下さい。");
            System.exit(1);


        }

        System.out.println("計算結果=" + result + "です。");
      } catch (InputMismatchException e) {
        System.out.println("不正な入力が行われました。");
        scanner.next();

      } catch (ArithmeticException e) {
        System.out.println("0で割る事はできません。");

      } catch (Exception e) {
        System.out.println("不明なエラー発生!!!");

      }
      System.out.println("計算を続けるなら、「y」、終了するなら、「n」を入力する。");

      char response = scanner.next().charAt(0);

      if (response == 'n' || response == 'N') {
        break;
      }
    }
  }
}
