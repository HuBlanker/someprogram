package lintcode.string;

public class SpaceReplace {

  public static void main(String[] args) {

    SpaceReplace spaceReplace = new SpaceReplace();

    String str = "i love you ";
    spaceReplace.replaceBlank(str.toCharArray(), str.length());

  }


  public int replaceBlank(char[] string, int length) {
    int j = length - 1;
    int num = 0;
    for (int i = 0; i < length; i++) {
      if (string[i] == ' ') {
        num++;
      }
    }
    int bigIndex = length + 2 * num;

    for (; j >= 0; j--) {
      if (string[j] == ' ') {
        string[--bigIndex] = '0';
        string[--bigIndex] = '2';
        string[--bigIndex] = '%';
      } else {
        string[--bigIndex] = string[j];
      }
    }
    System.out.print(string);
    return bigIndex;

  }


}