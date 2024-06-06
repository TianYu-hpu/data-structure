package com.htjs.datastructure.list;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for (String str : stack) {
            System.out.print(str+" ");
        }
        System.out.println("-----------------------------");
        String result = stack.pop();
        System.out.println("弹出了元素："+result);
        System.out.println(stack.size());
        System.out.println("-----------------------------");
        for (String str : stack) {
            System.out.print(str+" ");
        }
    }

}
