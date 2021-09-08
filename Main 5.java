import java.util.Scanner;
import java.util.Random;

class Main {
/**
   ■ゲームを作ってもらいます
  　・登場人物
  　　MJ HP100
  　　みっちー HP100
 　■ゲームの流れ
  　・MJに行動を選択肢を表示させ入力させる
  　　選択肢→攻撃、防御
  　・攻撃を選択した場合
  　　パンチ、キックの選択肢を表示
  　　パンチ→みっちーのHPを30減らせる
  　　キック→みっちーのHPを40減らせる（キックは一回のみしか使えない）
  　　※二回目選択したら使えません等のメッセージを出す
  　・防御を選択した場合
  　　みっちーの攻撃を半減させる
  　　
  　・MJの行動選択後みっちーが攻撃してくる
  　　覇王色の覇気（30ダメージ）かビンタ（20ダメージ）を50％ずつの確率で行う
  　　覇王色の覇気（たまに一撃必殺）※確率はおまかせ

  　・ゲームなのでダメージを与えたら相手の残りのHP
  　　相手が攻撃してきたら自分の残HPを表示

　 ■条件
  　・MJの攻撃メソッド（攻撃の種類を投げるとダメージを返してくれる）を作ってください
  　・みっちーの攻撃メソッドを作ってください
  　・ゲームなので他に楽しそうな要素があったら盛り込んでください（仕様の変更はせずに）　
  　・Scanner sc1 = new Scanner(System.in);を利用して文字の入力をできるようにしてください。
**/
public static int defence = 0;
public static int MJ_HP = 100;
public static int YK_HP = 100;
public static int kick_frag = 0;
public static String[] YK_actions = {"覇王色の覇気","ビンタ"};
public static String[] MJ_actions = {"攻撃","防御"};
public static String[] MJ_attacks_all = {"パンチ","キック"};
public static int[] MJ_dmg = {30,40};
public static int[] YK_dmg = {30,20,MJ_HP};
public static String YK_action = null;
public static String MJ_action = null;
public static String scan = null;
public static String str = null;
public static String left = "left";
public static String right = "right";
public static int r = 0;
public static int count = 0;

  public static void main(String[] args) {

    System.out.println("注意！");
    System.out.println("このゲームは’半角英数字’入力にしてプレイしてください");
    System.out.println("行動を選択する際はlまたはrを入力しエンターキーを押してください");

    MJ_actions();
    fight_fin();
  }

  private static void MJ_actions(){
    do{
      count = 0;
      System.out.println("MJの行動を選択してください．");
      System.out.println("left．攻撃　right．防御");
      Scanner scan = new Scanner(System.in);
      str = scan.next();
      if(!(str.equals(left)) && (!(str.equals(right)))){
        System.out.println("行動を選択する際はleftまたはrightを入力してください");
        count = 1;
      }else{
        continue;
      }
    }while(count == 1);

    if(str.equals(left)){
      MJ_attacks();
      if(YK_HP > 0){
        YK_attacks();
      }else{
        System.out.println("みっちーの体力がなくなりました");
      }
    }else{
      MJ_defence();
      YK_attacks();
    }
  }

  private static void MJ_attacks(){
    do{
      count = 0;
      System.out.println("left．パンチ　right．キック");
      scan = new Scanner(System.in);
      attack = scan.next();
      if((kick_frag == 1) && (str.equals(right))){
        System.out.println("※二回目選択したら使えません");
        count = 1;
      }else if(!(str.equals(left)) && (!(str.equals(right)))){
        System.out.println("行動を選択する際はleftまたはrightを入力してください");
        count = 1;
      }
    }while(count == 1);

    if(str.equals(left)){
      YK_HP -= 30;
    }else{
      YK_HP -= 40;
      kick_frag = 1;
    }
  }

  private static void MJ_defence(){
    System.out.println("MJ_defence()を実行しました");
  }

  private static void YK_attacks(){
    System.out.println("YK_attacks()を実行しました");
  }

  private static void fight_fin(){
    System.out.println("fight_fin()を実行しました");
  }
}
