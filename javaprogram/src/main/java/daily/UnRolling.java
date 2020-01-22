package daily;

/**
 * Created by pfliu on 2019/12/19.
 */
public class UnRolling {
    public static void main(String[] args) {

        int []ary = new int[99999999];
        long begin = System.currentTimeMillis();
        int size = ary.length;
        for(int i=0;i<size;i++){
            ary [i] = i;
        }
        System.out.println("未展开--last time = "+(System.currentTimeMillis()-begin));


        long begin2 = System.currentTimeMillis();
        int size2 = ary.length;
        for(int i=0;i<size2;i+=3){
            ary[i] = i;
            ary[i+1] = i+1;
            ary[i+2] = i+2;
        }

        System.out.println("展开--last time = "+(System.currentTimeMillis()-begin2));
    }
}
