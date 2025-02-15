package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * 問題2:配列とリストまたはStreamAPIを使用して、学生の名前と点数を管理するプログラムを作成してください。 名前の追加、削除、点数の更新、平均点の計算ができるようにしてください。
 * 処理をループさせるにはWhile文を使って実現してください。
 */
public class StudentManagement {

  private static final List<Student> studentList = new ArrayList<>(Arrays.asList(
      new Student("田中", 100),
      new Student("劉備", 85),
      new Student("花子", 77),
      new Student("めい", 45),
      new Student("長次郎", 55),
      new Student("きみこ", 66),
      new Student("James", 98)
  ));

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      try {
        System.out.println("現在の学生リスト: ");

        for (Student student : studentList) {
          System.out.println(student);
        }
        System.out.println("""
            以下の項目から入力してください。(例)add,remove
            add:学生と点数を追加
            remove:学生を削除
            newScore:学生の点数を更新
            average:学生の平均点を表示
            allStudent:全ての学生の名前を表示
            exit:終了""");

        String input = scanner.next(); // 選択項目を入力

        switch (input) {
          case "add" -> addStudent(scanner);
          case "remove" -> removeStudent(scanner);
          case "newScore" -> updateStudentScore(scanner);
          case "average" -> showAverageScore();
          case "allStudent" -> showAllStudents();
          case "exit" -> {
            System.out.println("終了します。");
            System.exit(0);
          }
          default -> System.out.println("不明なコマンドです。");
        }
      } catch (InputMismatchException e) {
        System.out.println("入力エラー: 正しい形式で入力してください。");
        scanner.nextLine();
      } catch (Exception e) {
        System.out.println("エラーが発生しました: " + e.getMessage());
      }
    }
  }

  private static void addStudent(Scanner scanner) {
    System.out.println("追加する学生の名前を入力してください。");
    String studentName = scanner.next();
    System.out.println("追加する学生の点数を入力してください。");
    int studentScore = scanner.nextInt();

    studentList.add(new Student(studentName, studentScore));
    System.out.println("学生 " + studentName + " (点数: " + studentScore + ") を追加しました。");
  }

  private static void removeStudent(Scanner scanner) {
    System.out.println("削除する学生の名前を入力してください。");
    String studentName = scanner.next();

    Optional<Student> studentToRemove = studentList.stream()
        .filter(student -> student.getName().equals(studentName))
        .findFirst();

    if (studentToRemove.isPresent()) {
      studentList.remove(studentToRemove.get());
      System.out.println("学生 " + studentName + " を削除しました。");
    } else {
      System.out.println("削除する学生が見つかりません。");
    }
  }

  private static void updateStudentScore(Scanner scanner) {
    System.out.println("点数を更新する学生の名前を入力してください。");
    String studentName = scanner.next();

    Optional<Student> studentToUpdate = studentList.stream()
        .filter(student -> student.getName().equals(studentName))
        .findFirst();

    if (studentToUpdate.isPresent()) {
      System.out.println(studentName + " の新しい点数を入力してください。");
      int newScore = scanner.nextInt();
      studentToUpdate.get().setScore(newScore);
      System.out.println(studentName + " の点数を " + newScore + " に更新しました。");
    } else {
      System.out.println("更新する学生が見つかりません。");
    }
  }

  private static void showAverageScore() {
    double average = studentList.stream()
        .mapToInt(Student::getScore)
        .average()
        .orElse(0);
    System.out.println("学生の平均点は " + average + " 点です。");
  }

  private static void showAllStudents() {
    studentList.forEach(student -> System.out.println("学生: " + student.getName()));
  }
}
