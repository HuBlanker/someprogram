// 标题:
//      最小栈

// 描述:
//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计

// 思路:

/**
 * Created by huyanshi on 191011
 *
 * 这题没有规定使用什么数据结构来实现栈...所以我偷懒直接用Java的栈了.
 *
 * 用了Java的栈之后,就只有一个实现最小值的获取了.
 *
 * 我在栈里直接维护了一个min. 当新放入值时, 将当前的min和放入值比较获取较小值.
 *
 * 当弹出的值是最小值的时候,需要重新计算最小值.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start


import java.util.Stack;

public class LeetCode155{
       public static void main(String[] args) {
      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Stack<Integer> s;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        min = Math.min(min, x);
        s.push(x);
    }
    
    public void pop() {
        Integer pop = s.pop();
        if (pop == min) {
            min = Integer.MAX_VALUE;
            s.forEach(e -> this.min = Math.min(this.min, e));
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)



}
