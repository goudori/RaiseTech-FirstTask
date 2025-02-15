package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 問題2:配列とリストまたはStreamAPIを使用して、学生の名前と点数を管理するプログラムを作成してください。 名前の追加、削除、点数の更新、平均点の計算ができるようにしてください。
 * 処理をループさせるにはWhile文を使って実現してください。
 */
public class Students {

  private String name;

  private int score;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    boolean isContinue = true; //学生情報を継続

    Map<String, Integer> studentMapList = new HashMap<>(
        Map.of("田中", 100, "劉備", 85, "花子", 77, "めい", 45, "長次郎", 55, "きみこ", 66, "James",
            98)); // 現在の学生と学生の点数

    while (isContinue) {
      try {
        System.out.println("現在の学生と学生の点数は" + studentMapList);

        System.out.println("""
            以下の項目から入力してください。(例)add,remove
            add:学生と点数を追加
            remove:学生を削除
            newScore:学生の点数を更新
            average:学生の平均点を表示
            allStudent:全ての学生の名前を表示
            exit:終了""");

        String input = scanner.next(); //選択項目を入力

        switch (input) {
          case "add" -> { //学生と学生の点数を追加
            System.out.println("追加する学生の名前を入力してください。");
            String studentName = scanner.next();
            System.out.println("追加した学生の点数を入力してください");
            int studentScore = scanner.nextInt();
            studentMapList.put(studentName, studentScore);
            System.out.println(
                "追加した学生は" + studentName + "で、" + "点数は" + studentScore + "点");
            System.out.println("追加した学生を含めた学生リストは" + studentMapList);
          }

          case "remove" -> { //指定した学生を削除する
            System.out.println("削除する学生の名前を入力してください。");
            String studentName = scanner.next();
            if (studentMapList.containsKey(studentName)) {
              studentMapList.remove(studentName);
              System.out.println("削除した学生は" + studentName);
            } else {
              System.out.println("削除する学生が見つかりません。");
            }
            System.out.println("削除した学生により、現在の学生リストは" + studentMapList);
          }

          case "newScore" -> { //指定した学生の点数を更新
            System.out.println("点数を更新する学生を入力してください");
            String studentName = scanner.next();
            if (studentMapList.containsKey(studentName)) {
              System.out.println(studentName + "の更新する点数を入力して下さい");
              int studentNewScore = scanner.nextInt();
              studentMapList.put(studentName, studentNewScore);
              System.out.println(studentName + "の更新した点数は" + studentNewScore + "点");
            } else {
              System.out.println("更新する学生が見当たりません。");
            }
          }

          case "average" -> { // 学生の平均点を表示
            double studentAverage = studentMapList.values().stream().mapToInt(Integer::intValue)
                .average().orElse(0);
            System.out.println("学生の平均点は" + studentAverage + "点");

          }

          case "allStudent" -> { //全ての学生の名前を表示
            List<String> studentList = new ArrayList<>(studentMapList.keySet());
            System.out.println("全ての学生は" + studentList);
          }

          case "exit" -> { //終了
            System.out.println("終了します。");
            isContinue = false;
          }

          default -> System.out.println("不明なコマンドです。");


        }
      } catch (InputMismatchException i) {
        System.out.println("不明なコマンドです。");
      } catch (Exception e) {
        System.out.println("不明なコマンドです。");
      }


    }


  }
}
