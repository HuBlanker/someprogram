package leetcode.other;

/**
 * Created by pfliu on 2019/10/11.
 * <p>
 * 数组模拟台阶积水问题.
 * <p>
 * 参考链接: https://blog.csdn.net/u013309870/article/details/70978279
 */
public class MaxWater {

    /*
    积水问题, 其实就是对于每一个台阶, 计算出他的左右两边最高的台阶, 取两边的低点, 减去当前的高度就是本台阶的积水.
     所以首先求出每一个值, 他的左右两边的最高点存起来, 然后减一下就好了.
     */
    public static final int water1(int[] arr) {
        if (arr == null || arr.length <= 2) return 0;

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            left[i] = max;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            max = Math.max(arr[i], max);
            right[i] = max;
        }

        int water = 0;
        for (int i = 0; i < arr.length; i++) {
            water += (Math.min(left[i], right[i]) - arr[i]);
        }
        return water;
    }


    /*
    这是一个更节省空间的方法,对于左右的最大值, 其实并不是必须存起来的, 在运行过程中动态的获得也可以.

    左右两边各自放一个指针,从两头开始. 保存当前左边最大值和右边最大值.

    取两者较小的那一个, 并对那一侧当前的位置进行积水的计算, 然后移动. 当左右指针交汇, 就完成了.
    举例: 4, 1, 5, 3, 5
    1: left= 4, right = 5; left_largest= 4, right_largest=5.那么计算第一个位置的积水量= 4 -4 = 0;
    2. left = 1, right = 5, l_max = 4, r_max = 5. 计算第二个位置的积水量 = 4 -1 = 3;
    3. left = 5, right = 5, l_max = 5, r_max = 5, 计算第5个位置的积水量 = 5-5=0
    4. left = 5, right = 3, l_max = 5, r_max = 5, 计算第4个位置的积水量 = 5 -3 = 2.
    5. 左右交错. 结束. 总积水量 = 5.
     */
    public static int water3(int[] arr) {
        int water = 0;
        if (arr == null || arr.length <= 1)
            return 0;
        int largestLeft = 0, largestRight = 0;
        //分别保存左右两边最大值
        int left = 0, right = arr.length - 1;
        while (left < right) {
            largestLeft = Math.max(arr[left], largestLeft);
            largestRight = Math.max(arr[right], largestRight);
            //获得左右两边最大值
            if (largestLeft > largestRight) {
                //如果左边最大值大于右边则右指针向移动
                water += largestRight - arr[right--];
            } else {
                //否则左指针向右移动
                water += largestLeft - arr[left++];
            }
        }

        return water;
    }

    public static void main(String[] args) {
        System.out.println(water3(new int[]{4, 1, 5, 3, 5}));
        System.out.println(water1(new int[]{4, 1, 5, 3, 5}));
    }
}
