package com.htjs.datastructure.list;

public class LinkListReverseTest {

    public static void main(String[] args) {
        LinkList<String> list = new LinkList<String>();
        list.insert(0, "张三");
        list.insert(1, "李四");
        list.insert(2, "王五");
        list.insert(3, "赵六");

        for(Object s : list) {
            System.out.println(s);
        }

        System.out.println("------------------------");
        list.reverse();

        for(Object s : list) {
            System.out.println(s);
        }
    }

}
