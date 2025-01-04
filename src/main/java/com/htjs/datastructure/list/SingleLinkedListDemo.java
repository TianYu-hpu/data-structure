package com.htjs.datastructure.list;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");

//        singleLinkedList.add(node1);
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);
//        singleLinkedList.add(node4);

        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.list();
        System.out.println("逆序打印单链表");
        singleLinkedList.reversePrint();
//        System.out.println("链表翻转");
//        singleLinkedList.list();
//        System.out.printf("单链表长度%d", singleLinkedList.size());
//        System.out.println("链表倒数第i个节点");
//        System.out.println(singleLinkedList.findLastIndexNode(2));
        /*System.out.println("删除后节点");
        singleLinkedList.delete(1);
        singleLinkedList.delete(2);
        singleLinkedList.delete(3);
        singleLinkedList.delete(4);
        singleLinkedList.list();*/
        /*//测试修改节点的代码
        HeroNode newHeroNode2 = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(2, newHeroNode2);
        System.out.println("修改后链表");
        singleLinkedList.list();*/
    }
}

class SingleLinkedList {
    //先初始化一个头结点，头结点不要动
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode findLastIndexNode(int index) {
        if(head.next == null) {
            return null;
        }
        int size = size();
        int loopCount = size - index;
        if(index <= 0 || index > size) {
            System.out.println("输入参数不合法");
        }
        HeroNode curr = head.next;
        for (int i = 0; i < loopCount; i++) {
            curr = curr.next;
        }
        return curr;
    }


    public void reverserList() {
        //如果当前链表为空，或者只有一个节点，无需翻转，直接返回
        if(head.next == null || head.next.next == null) {
            return;
        }
        HeroNode curr = head.next;
        //指向当前节点的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在心的链表reverseHead的最前端
        while(curr != null) {
            //保存当前节点的下一个节点
            next = curr.next;
            //将curr节点的下一个节点指向链表的最前端
            curr.next = reverseHead.next;
            reverseHead.next = curr;
            curr = next;
        }
        head.next = reverseHead.next;
    }

    public void reversePrint() {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode curr = head.next;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next指向新的节点
     * @param node
     */
    public void add(HeroNode node) {
        HeroNode tmp = head;
        while(true) {
            //找到链表的最后
            if(tmp.next == null) {
                break;
            }
            //如果没有找到最后
            tmp = tmp.next;
        }
        //当退出循环时，tmp指向了链表的最后
        tmp.next = node;
    }

    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while(true) {
            if(temp.next == null) {
                break;
            }
            if(temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的节点%d不存在", no);
        }
    }

    public int size(){
        HeroNode temp = head.next;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public void update(int no, HeroNode node) {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        //标志更新的编号是否存在
        boolean flag = false;
        while(true) {
            //说明temp已经在链表的最后
            if(temp == null) {
                break;
            }
            //位置找到
            if(temp.no == node.no) {
                flag = true;
                break;
            }
            //后移
            temp = temp.next;
        }
        if(flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.println("未找到该节点");
        }
    }

    public void addByOrder(HeroNode node) {
        //因为头结点不能动，因此我们仍然通过一个辅助指针来帮助找到添加的位置
        //因为单链表，因为我们找的temp节点是要添加的节点的前一个节点，否则插入不了
        HeroNode temp = head;
        //标志添加的编号是否存在
        boolean flag = false;
        while(true) {
            //说明temp已经在链表的最后
            if(temp.next == null) {
                break;
            }
            //位置找到
            if(temp.next.no > node.no) {
                break;
            } else if(temp.next.no == node.no) {
                //说明希望添加的编号已经存在
                flag = true;
            }
            //后移
            temp = temp.next;
        }
        //判断flag的值
        if(flag) {
            System.out.printf("准备插入的英雄%d已经存在 \n", node.no);
        } else {
            //插入到temp节点后面
            node.next = temp.next;
            temp.next = node;
        }

    }

    public void list() {
        HeroNode tmp = head;
        if(tmp.next == null) {
            System.out.println("链表为空");
            return;
        }
        while(true) {
            if(tmp == null) {
                break;
            }
            System.out.println(tmp);
            //一定要后移
            tmp = tmp.next;
        }

    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //为了显示方便重写toString方法


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
