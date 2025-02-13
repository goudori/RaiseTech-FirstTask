package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 問題3: 正規表現を使用して、ハイフン付きの国内携帯電話番号の有効性をチェックするプログラムを作成してください。
 * 有効な携帯電話番号の条件を自分で定義し、その条件に合致するかどうかを判定してください。 携帯電話を使用した国は、「日本」、「アメリカ」
 */
public class PhoneRegex {

  public static void main(String[] args) {

    String regexJapanPhone = "^0\\d{2}-\\d{4}-\\d{4}$"; //ハイフン付きの日本国内の携帯電話番号の正規表現
    String regexUSPhone = "^\\d{3}-\\d{4}-\\d{4}$"; //ハイフン付きのアメリカの携帯電話番号の正規表現



    int errorCount = 0;

    Scanner scanner = new Scanner(System.in);

    while (true) {

      try {
        System.out.println("""
            日本もしくは、アメリカの携帯電話番号を１つだけ入力して下さい。
            
            日本国内の「先頭が0から始まるハイフン付き」の携帯電話番号を入力して下さい。
            (例）090-123-4567
                080-901-2345
                070-111-2222
            
            アメリカの「先頭が0以外の数字から始まるハイフン付き」の携帯電話番号を入力して下さい。
            (例）123-4564-7890
            　　 987-6545-3210
            　　 555-1234-4567
            """);

        String inputPhone = scanner.next();

        if (Pattern.matches(regexJapanPhone, inputPhone)) {
          System.out.println("日本国内の有効な携帯電話番号です。");
        } else if (Pattern.matches(regexUSPhone, inputPhone)) {
          System.out.println("アメリカの有効な携帯電話番号です。");
        } else {
          System.out.println("無効な携帯電話番号です。");
          errorCount++;
          if (errorCount == 3) {
            System.out.println("３回エラーを起こしたので、終了します。");
            System.exit(0);
            break;
          }
        }
      } catch (InputMismatchException e) {
        System.out.println("正しい携帯電話番号を入力して下さい。");

      }

    }
    scanner.close();

  }

}
