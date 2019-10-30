// 标题:
//      用队列实现栈

// 描述:
//使用队列实现栈的下列操作： 
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计

// 思路:

/**
 * Created by huyanshi on 191020.
 * 用 先进先出来模拟先进后出.
 * 每次都拿出队列中的全部元素, 返回最后一个, 然后将剩下的再依次入队即可.
 *
 * 这就是 这道题的核心思想, 至于这个移动所有元素的操作, 是放在压入操作, 还是放在弹出操作. 就随意了.
 *
 * 可以 在 插入的时候提前调整好顺序, 也可以在 弹出的时候再调整顺序.
 */
 
// ===============思路end=============

 
package leetcode.leetcode.editor.cn;

// My Code Start

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225{
       public static void main(String[] args) {
           MyStack s = new LeetCode225().new MyStack();
           s.push(1);
           s.push(2);

           System.out.println(s.top());
           System.out.println(s.pop());
           System.out.println(s.pop());
           System.out.println(s.empty());

      }


// My Code End




//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    public Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = this.queue.size();
        while (size > 1) {
            this.queue.offer(this.queue.poll());
            size--;
        }
        return this.queue.poll();
    }
    
    /** Get the top element. */
    public int top() {

        int size = this.queue.size();
        while (size > 1) {
            this.queue.offer(this.queue.poll());
            size--;
        }
        Integer peek = this.queue.poll();
        this.queue.offer(peek);
        return peek;

    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.size() <= 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)



}
