package money.queens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * calculation the gain from transaction
 */
public class ShareTransaction {


  /**
   * get input from terminal
   * @return
   */
  private Integer start() {
    Scanner sc = new Scanner(System.in);
    List<String> in = new ArrayList<>();

    String s;
    while (sc.hasNextLine()) {
      s = sc.nextLine();
      in.add(s);
      if ("".equals(s)) {
        break;
      }
    }

    return calculation(in);
  }


  /**
   * calculation the result
   * @param transactions
   * @return
   */
  private Integer calculation(List<String> transactions) {
    int result = 0;

    //make the input to sell-100-20 format
    List<String> t = new ArrayList<>();
    for (String transaction : transactions) {
      if ("".equals(transaction)) {
        continue;
      }
      String[] ss = transaction.split(" ");
      t.add(ss[0] + "-" + ss[1] + "-" + ss[4].replace("$", ""));
    }

    for (int i = 0; i < t.size(); i++) {
      //cal while sell
      if (t.get(i).startsWith("sell")) {
        //get the num and the sell price
        int num = Integer.valueOf(t.get(i).split("-")[1]);
        int sellPrice = Integer.valueOf(t.get(i).split("-")[2]);
        //cal the buy before sell
        for (int j = 0; j < i; j++) {
          //sell shares, use FIFO.
          String[] sss = t.get(j).split("-");
          //if sell num < buy num, cal sell num shares in that transcation.
          if (num <= Integer.valueOf(sss[1])) {
            result += num * (sellPrice - Integer.valueOf(sss[2]));
            break;
          } else {
            //if sell num > buy num, cal all shares ,and cal new sellnum.
            result += Integer.valueOf(sss[1]) * (sellPrice - Integer.valueOf(sss[2]));
            num -= Integer.valueOf(sss[1]);
          }
        }
      }
    }

    return result;

  }

  //main, include some test codes
  public static void main(String[] args) {
    //test use program
    List<String> s = new ArrayList<>();

    s.add("buy 100 share(s) at $20 each");
    s.add("buy 20 share(s) at $24 each");
    s.add("buy 200 share(s) at $36 each");
    s.add("sell 150 share(s) at $30 each");

    ShareTransaction a = new ShareTransaction();
    System.out.println(a.calculation(s));

    //test use scanner
    System.out.println(new ShareTransaction().start());

  }

}
