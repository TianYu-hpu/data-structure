package com.htjs.datastructure.list;

public class SequenceListTest {

    public static void main(String[] args) {
        SequenceList<String> sequenceList = new SequenceList<String>(5);
        sequenceList.insert("姚明");
        sequenceList.insert("科比");
        sequenceList.insert("麦迪");
        sequenceList.insert("艾佛特");
        sequenceList.insert("卡特");
        sequenceList.insert("麦弗逊");

        for(String s : sequenceList) {
            System.out.println(s);
        }
    }

}
