package cn.wzx.algorithm;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 队列：先进先出
 * 栈：先进后出
 * stack1：1,2,3,4 出栈：4,3,2,1
 * stack2：4,3,2,1 出栈：1,2,3,4
 * @author Administrator
 *
 */
public class QueueByStack {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	while (!stack2.isEmpty()) {
    		stack1.add(stack2.pop());    		
		}   	
        stack1.add(node);		
    }
    
    public int pop() {
    	
    	while (!stack1.isEmpty()) {
    		stack2.add(stack1.pop());    		
		}
		return stack2.pop();
    	
    }
    
    public static void main(String[] args) {
    	QueueByStack queueByStack = new QueueByStack();
    	queueByStack.push(1);
    	queueByStack.push(2);
    	System.out.println(queueByStack.pop());
    	queueByStack.push(3);
    	queueByStack.push(4);
    	System.out.println(queueByStack.pop());
    	System.out.println(queueByStack.pop());
    	System.out.println(queueByStack.pop());
	}
    
    
}
