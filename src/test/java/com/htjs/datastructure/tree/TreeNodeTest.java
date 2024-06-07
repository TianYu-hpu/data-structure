package com.htjs.datastructure.tree;

/**
 * https://www.jb51.net/program/303754uap.htm
 */
public class TreeNodeTest {

    public static void main(String[] args) {

        TreeNode D = new TreeNode("D", null, null);
        TreeNode E = new TreeNode("E", null, null);
        TreeNode H = new TreeNode("F", null, null);
        TreeNode C = new TreeNode("C", D, E);
        TreeNode G = new TreeNode("G", H, null);
        TreeNode B = new TreeNode("B", null, C);
        TreeNode F = new TreeNode("F", null, G);
        TreeNode A = new TreeNode("A", B, F);
        System.out.println("前序遍历");
        A.preOrder(A);
        System.out.println("--------------------------------");
        System.out.println("中序遍历");
        A.inOrder(A);
        System.out.println("--------------------------------");
        System.out.println("后序遍历");
        A.postOrder(A);

    }

}
