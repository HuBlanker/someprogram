package sort;

/**
 * created by huyanshi on 2019/1/13
 */
public class SortMain {

  private static int[] input = new int[]{26, 13, 3, 5, 27, 36, 42, 2, 4, 44, 34, 25, 59, 58};

  private BaseSort baseSort;

  public static void main(String[] args) {
    SortMain sortMain = new SortMain();
    sortMain.baseSort = new SelectionSort();
    sortMain.baseSort.sort(input);
    printArr(input);

  }

  public static void printArr(int[] input) {
    for (int i = 0; i < input.length; i++) {
      System.out.print(input[i]);
      System.out.print(",");
    }


  }
}