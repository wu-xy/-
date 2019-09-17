package cn.wzx.algorithm;

import java.util.Stack;

/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * ���У��Ƚ��ȳ�
 * ջ���Ƚ����
 * stack1��1,2,3,4 ��ջ��4,3,2,1
 * stack2��4,3,2,1 ��ջ��1,2,3,4
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
