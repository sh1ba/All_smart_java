class Main {
  /**
  【課題】
　　以下の文字列変数「sentence」の中に、アルファベット小文字のa～eがそれぞれ何個含まれているかを数え、棒グラフ状に表示しなさい。
   String sentence = "The Java programming language is a general-purpose, concurrent, class-based, object-oriented language. It is designed to be simple enough that many programmers can achieve fluency in the language. The Java programming language is related to C and C++ but is organized rather differently, with a number of aspects of C and C++ omitted and a few ideas from other languages included. It is intended to be a production language, not a research language, and so, as C. A. R. Hoare suggested in his classic paper on language design, the design has avoided including new and untested features. The Java programming language is strongly and statically typed. This specification clearly distinguishes between the compile-time errors that can and must be detected at compile time, and those that occur at run time. Compile time normally consists of translating programs into a machine-independent byte code representation.";

　【出力例】(a,bの列だけ出力しています)
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *
  *
  **
  -----
  abcde

　棒グラフはアスタリスク「*」を積み上げて表現します。
　「*」1個が、数えた文字の個数5個分に相当し、5個未満の個数は切り捨てます(含まれている文字数が17個なら、「*」が3個)。
・aは77個含まれるので、77 / 5 = 15...2 で、*が15個
・bは9個含まれるので、9 / 5 = 1...4 で、*が1個

　【ヒント1】
　　a～eが含まれる個数を数える処理と、棒グラフを出力する処理は別の処理(≒別個の繰り返し処理)になります。
　　文字列の中から特定の文字の個数を数える方法はいろいろありますので、ネットで調べて好きなの使ってください。

　【ヒント2】
　　文字列を1文字ずつばらして配列に格納する方法は以下のようなやり方があります。

　　char[] a = 文字列変数.toCharArray();
　　とすると、char型配列には、文字列を分解した1文字ずつが各要素に入ります。
　　なお、文字の比較はequalsでなく、普通に==で比較できます。

　　例
　　char[] charArray = str.toCharArray();

　　if (charArray[0] == 'b') {
　　　// char型配列charArrayの0番目の要素が文字'b'と等しい場合の処理
　　}


　　もしくは、String[] a = 文字列変数.split("");
　　とすると、String型配列には、文字列を分解した1文字分の文字列が各要素に入ります。
　　なお、文字列の比較はequalsを使用します。

　　例
　　String[] strArray = str.split("");

　　if ("c".equals(strArray[0])) {
　　　// String型配列strArrayの0番目の要素が文字列"c"と等しい場合の処理
　　}

  **/
  public static void main(String[] args) {
    // 文字列変数を宣言し、課題の文字列で初期化する
    String sentence = "The Java programming language is a general-purpose, concurrent, class-based, object-oriented language. It is designed to be simple enough that many programmers can achieve fluency in the language. The Java programming language is related to C and C++ but is organized rather differently, with a number of aspects of C and C++ omitted and a few ideas from other languages included. It is intended to be a production language, not a research language, and so, as C. A. R. Hoare suggested in his classic paper on language design, the design has avoided including new and untested features. The Java programming language is strongly and statically typed. This specification clearly distinguishes between the compile-time errors that can and must be detected at compile time, and those that occur at run time. Compile time normally consists of translating programs into a machine-independent byte code representation.";
    //a-eそれぞれ何文字含まれているか求める．64bit整数．
    //StreamPipeline 参考->https://www.slideshare.net/AyaEbata/java-java8-56125523?next_slideshow=1
    long count_a = sentence.chars().filter(ch -> ch == 'a').count();
    long count_b = sentence.chars().filter(ch -> ch == 'b').count();
    long count_c = sentence.chars().filter(ch -> ch == 'c').count();
    long count_d = sentence.chars().filter(ch -> ch == 'd').count();
    long count_e = sentence.chars().filter(ch -> ch == 'e').count();

    long a[] = new long[5];

    a[0] = count_a/5;
    a[1] = count_b/5;
    a[2] = count_c/5;
    a[3] = count_d/5;
    a[4] = count_e/5;

    for(int i=1; i<=18; i++){
      for(int j=0; j<=4; j++){
        if(a[j] <= 18-i){
          System.out.print(' ');
        } else {
          System.out.print('*');
        }
      }
      System.out.println();
    }
    for(int k=1; k<=20; k++){
      System.out.print('-');
    }
    System.out.println();
    System.out.println("abcde");
	}
}
