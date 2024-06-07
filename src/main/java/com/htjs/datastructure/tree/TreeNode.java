package com.htjs.datastructure.tree;

public class TreeNode {

    String data;
    TreeNode left;
    TreeNode right;

    public TreeNode(String data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void preOrder(TreeNode root) {
        if(root != null) {
            System.out.print(root.data + ",");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.data + ",");
            inOrder(root.right);
        }
    }

    public void postOrder(TreeNode root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + ",");
        }
    }
}
