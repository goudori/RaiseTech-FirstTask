package org.example;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 「Windowsの場合は、Shift + F10で実行して下さい。」,「Macの場合は、Control + R で実行して下さい。」
 * <p>
 * コンソール画面で、「calc,student.phone,exit」の中から選択して実行して下さい。
 * <p>
 * ※もしMain.javaファイルで実行できない場合は、以下のファイルの中から選択して、実行して下さい。
 * <p>
 * Calculator.java →計算機プログラム StudentManagement.java　→学生管理プログラム  PhoneRegex.java →携帯電話番号チェックプログラム
 */
public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      try {
        System.out.println("calc, student,phone,exitの中から選択して実行してください。");

        String input = scanner.next();

        switch (input) {

          case "calc": // Calculator.java
            Calculator.main(args);
            break;

          case "student": // StudentManagement.java
            StudentManagement.main(args);
            break;

          case "phone": // PhoneRegex.java
            PhoneRegex.main(args);
            break;

          case "exit": // 終了
            System.out.println("終了します。");
            System.exit(0);

          default:
            System.out.println("不明なコマンドです。");
        }
      } catch (InputMismatchException i) {
        System.out.println("不明なコマンドです。");
      } catch (Exception e) {
        System.out.println("不明なコマンドです。");
      }
    }


  }


}
