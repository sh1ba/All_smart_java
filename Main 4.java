import java.util.Scanner;
class Main {
  /*
    英単語のテストの採点ではどこまでをスペルミスとみなしてどこまでを別の単語とみなすかが悩みどころです。
      そこで以下の様な採点基準を導入してこれに従って厳密に採点することにしています。
      【条件】
      ・正解の単語と完全一致→ ◯ 2 点
      ・正解の単語と長さ(文字数)が異なる→ × 0 点
      ・正解の単語と長さは同じだが 1 文字だけ異なる→ △ 1 点
      ・正解の単語と長さは同じだが 2 文字以上異なる→ × 0 点

      ここで「文字が異なる」とは、同じ位置にある文字が異なるということを意味しています。
      【例】
      正解: apple, 解答: aple → 0 点 (長さが異なる)
      正解: orange, 解答: olange → 1 点 (長さは同じだが 1 文字だけ異なる)
      正解: grape, 解答: glepe → 0 点 (長さは同じだが 2 文字異なる)
      正解: lemon, 解答: lemon → 2 点 (完全一致)

      以下のように正解数、部分点数、不正回数、合計得点を出力てください。
      【出力】
      全4問 正解数1 部分点数1 不正解数2
      合計3点
  **/

  public static void main(String[] args) {
    String correct_1 = "apple";
    String correct_2 = "orange";
    String correct_3 = "grape";
    String correct_4 = "lemon";

    char[] apple = correct_1.toCharArray();
    char[] orange = correct_2.toCharArray();
    char[] grape = correct_3.toCharArray();
    char[] lemon = correct_4.toCharArray();

    int correct_length_1 = apple.length;
    int correct_length_2 = orange.length;
    int correct_length_3 = grape.length;
    int correct_length_4 = lemon.length;

    int score_1 = 2;
    int score_2 = 2;
    int score_3 = 2;
    int score_4 = 2;
    int score = 0;
    int count = 0;
    int count_p = 0;
    int count_c = 0;

    System.out.println("問１．りんご");
    Scanner scan_1 = new Scanner(System.in);
    String str_1 = scan_1.next();

    char[] ans_1 = str_1.toCharArray();
    int ans_length_1 = ans_1.length;

    System.out.println("問２．オレンジ");
    Scanner scan_2 = new Scanner(System.in);
    String str_2 = scan_2.next();

    char[] ans_2 = str_2.toCharArray();
    int ans_length_2 = ans_2.length;

    System.out.println("問３．ぶどう");
    Scanner scan_3 = new Scanner(System.in);
    String str_3 = scan_3.next();

    char[] ans_3 = str_3.toCharArray();
    int ans_length_3 = ans_3.length;

    System.out.println("問４．レモン");
    Scanner scan_4 = new Scanner(System.in);
    String str_4 = scan_4.next();

    char[] ans_4 = str_4.toCharArray();
    int ans_length_4 = ans_4.length;




    if(ans_length_1 != correct_length_1){
      score_1 = 0;
      System.out.println("正解は" +correct_1+ "です。得点は"+str_1+" → "+score_1+"点(長さが異なる)");
    }else{
      for(int i=0; i<=ans_length_1-1; i++){
        if((apple[i] != ans_1[i])&&(score_1 >= 1)){
          score_1 = score_1 - 1;
        }
      }
      score += score_1;
      if(score_1 == 0){
        System.out.println("正解：" +correct_1+ "，解答："+str_1+" → "+score_1+"点(長さは同じだが 2 文字以上異なる)");
      }else if(score_1 == 1){
        System.out.println("正解：" +correct_1+ "，解答："+str_1+" → "+score_1+"点(長さは同じだが 1 文字だけ異なる)");
        count_p += 1;
      }else{
        System.out.println("正解：" +correct_1+ "，解答："+str_1+" → "+score_1+"点(完全一致)");
        count_c += 1;
      }
    }


    if(ans_length_2 != correct_length_2){
      score_2 = 0;
      System.out.println("正解は" +correct_2+ "です。得点は"+str_2+" → "+score_2+"点(長さが異なる)");
    }else{
      for(int i=0; i<=5; i++){
        if((orange[i] != ans_2[i])&&(score_2 >= 1)){
          score_2 = score_2 - 1;
        }
      }
      score += score_2;
      if(score_2 == 0){
        System.out.println("正解：" +correct_2+ "，解答："+str_2+" → "+score_2+"点(長さは同じだが 2 文字以上異なる)");
      }else if(score_2 == 1){
        System.out.println("正解：" +correct_2+ "，解答："+str_2+" → "+score_2+"点(長さは同じだが 1 文字だけ異なる)");
        count_p += 1;
      }else{
        System.out.println("正解：" +correct_2+ "，解答："+str_2+" → "+score_2+"点(完全一致)");
        count_c += 1;
      }
    }


    if(ans_length_3 != correct_length_3){
      score_3 = 0;
      System.out.println("正解は" +correct_3+ "です。得点は"+str_3+" → "+score_3+"点(長さが異なる)");
    }else{
      for(int i=0; i<=4; i++){
        if((grape[i] != ans_3[i])&&(score_3 >= 1)){
          score_3 = score_3 - 1;
        }
      }
      score += score_3;
      if(score_3 == 0){
        System.out.println("正解：" +correct_3+ "，解答："+str_3+" → "+score_3+"点(長さは同じだが 2 文字以上異なる)");
      }else if(score_3 == 1){
        System.out.println("正解：" +correct_3+ "，解答："+str_3+" → "+score_3+"点(長さは同じだが 1 文字だけ異なる)");
        count_p += 1;
      }else{
        System.out.println("正解：" +correct_3+ "，解答："+str_3+" → "+score_3+"点(完全一致)");
        count_c += 1;
      }
    }


    if(ans_length_4 != correct_length_4){
      score_4 = 0;
      System.out.println("正解は" +correct_4+ "です。得点は"+str_4+" → "+score_4+"点(長さが異なる)");
    }else{
      for(int i=0; i<=4; i++){
        if((lemon[i] != ans_4[i])&&(score_4 >= 1)){
          score_4 = score_4 - 1;
        }
      }
      score += score_4;
      if(score_4 == 0){
        System.out.println("正解：" +correct_4+ "，解答："+str_4+" → "+score_4+"点(長さは同じだが 2 文字以上異なる)");
      }else if(score_4 == 1){
        System.out.println("正解：" +correct_4+ "，解答："+str_4+" → "+score_4+"点(長さは同じだが 1 文字だけ異なる)");
        count_p += 1;
      }else{
        System.out.println("正解：" +correct_4+ "，解答："+str_4+" → "+score_4+"点(完全一致)");
        count_c += 1;
      }
    }
    count = 4-count_c-count_p;
    System.out.println("全4問 正解数"+count_c+"部分点数"+count_p+"不正解数"+count);
    System.out.println("合計"+score+"点");
  }
}
