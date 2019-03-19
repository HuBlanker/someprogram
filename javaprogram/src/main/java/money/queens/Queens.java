package money.queens;

import java.util.HashMap;
import java.util.Map;

/**
 * created by huyanshi on 2019/3/7
 */
public class Queens {


  private Integer queens;

  // 同栏是否有皇后，1表示有
  private Integer[] column;

  // 右上至左下是否有皇后
  private Integer[] rup;

  // 左上至右下是否有皇后
  private Integer[] lup;

  // 解答
  private Integer[] queen;

  // 独立解 及其对称图形
  private Map<String, String> results = new HashMap<String, String>();

  // 解答编号
  private int num;

  public Queens(int queens) {
    this.queens = queens;
    column = new Integer[queens + 1];
    rup = new Integer[(2 * queens) + 1];
    lup = new Integer[(2 * queens) + 1];
    queen = new Integer[queens + 1];

    for (int i = 0; i <= queens; i++) {
      column[i] = queen[i] = 0;
    }

    for (int i = 0; i <= (2 * queens); i++) {
      rup[i] = lup[i] = 0; // 初始定义全部无皇后
    }


  }

  public void backtrack(int i) {
    if (i > queens) {
      showAnswer();
    } else {
      for (int j = 1; j <= queens; j++) {
        if ((column[j] == 0) && (rup[i + j] == 0) && (lup[i - j + queens] == 0)) {
          // 若无皇后
          queen[i] = j;
          // 设定为占用
          column[j] = rup[i + j] = lup[i - j + queens] = 1;
          backtrack(i + 1); // 循环调用
          column[j] = rup[i + j] = lup[i - j + queens] = 0;
        }
      }
    }
  }

  protected void showAnswer() {
    num++;
    if (!isIndependence(num)) {
      return;
    }
    System.out.println("解答" + num + ":");
    for (int y = 1; y <= queens; y++) {
      for (int x = 1; x <= queens; x++) {
        if (queen[y] == x) {
          System.out.print(" Q");
        } else {
          System.out.print(" .");
        }
      }
      System.out.println(" ");
    }
    System.out.println();
  }

  protected boolean isIndependence(int number) {
    // 自身
    String newSolution = resultToString(queen);
    String flag = results.get(newSolution);

    if (flag != null) {
      //System.out.println("非独立解答解答, 同解答 " + flag + " 对称。");
      return false;
    }

    // 左右对称
    Integer[] leftRight = new Integer[queen.length];
    // 上下对称
    Integer[] upDown = new Integer[queen.length];
    // 左上右下对称
    Integer[] lurd = new Integer[queen.length];
    // 右上左下对称
    Integer[] ruld = new Integer[queen.length];
    // 顺时针第1次旋转
    Integer[] cw1 = new Integer[queen.length];
    for (int i = 1; i < queen.length; i++) {
      leftRight[i] = queen[queen.length - i];
      upDown[i] = queen.length - queen[i];
      lurd[queen.length - queen[i]] = queen.length - i;
      ruld[queen[i]] = i;
      cw1[queen[i]] = queen.length - i;
    }
    // 顺时针第2次旋转
    Integer[] cw2 = new Integer[queen.length];
    for (int i = 1; i < queen.length; i++) {
      cw2[cw1[i]] = queen.length - i;
    }
    // 顺时针第3次旋转
    Integer[] cw3 = new Integer[queen.length];
    for (int i = 1; i < queen.length; i++) {
      cw3[cw2[i]] = queen.length - i;
    }

    results.put(newSolution, number + "_self");
    putNewSolution(leftRight, number + "_lr");
    putNewSolution(upDown, number + "_ud");
    putNewSolution(lurd, number + "_lurd");
    putNewSolution(ruld, number + "_ruld");
    putNewSolution(cw1, number + "_cw1");
    putNewSolution(cw2, number + "_cw2");
    putNewSolution(cw3, number + "_cw3");

    return true;
  }

  protected void putNewSolution(Integer[] temp, String mark) {
    String newSolution = resultToString(temp);
    String flag = results.get(newSolution);

    if (flag == null) {
      results.put(newSolution, mark);
    }
  }

  protected String resultToString(Integer[] result) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < queen.length; i++) {
      sb.append(result[i]);
    }
    return sb.toString();
  }

  // 计算复杂度 15720
  public static void main(String[] args) {
    Queens queen = new Queens(8);
    queen.backtrack(1);
  }


}
