import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class Main {
  /**
    ■数字を入力したらその数値の役が何かを判定するシステムを作ってもらいます
    ストレート
    →数字が連続している

    4カード
    →5枚中4枚同一の数字

    フルハウス
    →3枚同一の数字、2枚同一の数字

    3カード
    →5枚中3枚同一の数字

    2ペア
    →5枚中2枚同一が2組

    1ペア
    →5枚中2枚同一

    役なし
    →上記以外

　　【例】
    12345⇒ストレート
    77775⇒4カード
    55666⇒フルハウス（3カードではないので注意）
    22295⇒3カード
    13355⇒2ペア
    11346⇒1ペア
    14689⇒役なし

    上記のように数字を入力したら対応する役が出力されるようにしてください
    その他の数字を入力しても、対応する役が出力されるようにしてください

    【条件】
      入力可能な数字は1～9です
      5桁の数字以外を入力した場合は、「正常な値を入力してください」と表示してください
      同一の数字を5個以上入力した場合は「正常な値を入力してください」と表示してください
      数字の入力→役判定→数字入力と何回も入力できるようにするためwhile文は残しておいてください
  */

public static int[] count_num = new int[10];
public static int[] num_array = new int[5];
public static int num = 0;
public static int two_card = 0;
public static int three_card = 0;
public static int error = 0;

  public static void main(String[] args) {
    while(true){
      input_number();
      if(error == 0){
        role_judge();
      }
      error = 0;


    }
  }

  public static void input_number() {
    System.out.println("数字を５つ入力してください");
    Scanner scan = new Scanner(System.in);
    num = scan.nextInt();
    int num_length = (int)Math.log10(num) + 1;

    for(int h=0; h<=9; h++){
      count_num[h] = 0;
    }

    if(num_length == 5){
      num *= 10;
      num_array[4] = num/(int)Math.pow(10,num_length);
      for(int i=num_length-1; i>=1; i--){
        int d = (int)Math.pow(10,i);
        num_array[i-1] = (num % (d*10) - num % d)/d;
      }

      for(int j=0; j<=4; j++){
        count_num[num_array[j]]++;
      }
      num /= 10;
    }else{
      System.out.println("正常な値を入力してください");
      error = 1;
    }
  }

  public static void role_judge() {
    if(five_card()){
      System.out.println("正常な値を入力してください");
      return;
    }

    if(straight()){
      System.out.println(num+"⇒ストレート");
      return;
    }

    if(four_card()){
      System.out.println(num+"⇒フォーカード");
      return;
    }

    if(full_house()){
      System.out.println(num+"⇒フルハウス");
      return;
    }

    if(three_cards()){
      System.out.println(num+"⇒3カード");
      return;
    }


    if(two_pair()){
      System.out.println(num+"⇒2ペア");
      return;
    }


    if(one_pair()){
      System.out.println(num+"⇒1ペア");
      return;
    }

    System.out.println(num+"⇒役なし");
  }

  public static void pair() {
    two_card = 0;
    if(!(three_cards())){
      for(int i=1; i<=9; i++){
        if(count_num[i] == 2){
          two_card += 1;
        }
      }
    }
  }

  public static boolean one_pair() {
    pair();
    if(two_card == 1){
      return true;
    }
    return false;

  }

  public static boolean two_pair() {
    pair();
    if(two_card == 2){
      return true;
    }
    return false;
  }

  public static boolean three_cards() {
    if(!(full_house())){
      for(int i=1; i<=9; i++){
        if(count_num[i] == 3){
          return true;
        }
      }
    }
    return false;
  }

  public static boolean full_house() {
    int cnt2 = 0;
    int cnt3 = 0;
    for(int i=1; i<=9; i++){
      if(count_num[i] == 2){
        cnt2 = 1;
      }

      if(count_num[i] == 3){
        cnt3 = 1;
      }
      if((cnt2 == 1) && (cnt3 == 1)){
        return true;
      }
    }
    return false;
  }

  public static boolean four_card() {
    for(int i=1; i<=9; i++){
      if(count_num[i] == 4){
        return true;
      }
    }
    return false;
  }

  public static boolean straight() {
    int cnt = 0;
    for(int j=1; j<=9-4; j++){
      for(int i=j; i<=j+4; i++){
        if(count_num[i] != 1){
          cnt = 0;
          break;
        }else{
          cnt = cnt+1;
        }
      }
      if(cnt == 5){
        return true;
      }
    }
    return false;
  }

  public static boolean five_card() {
    for(int i=1; i<=9; i++){
      if(count_num[i] == 5){
        return true;
      }
    }
    return false;
  }
}
