package com.htjs.datastructure.tree;


import com.htjs.datastructure.list.Queue;

/**
 * 二叉树
 * @param <Key>
 * @param <Value>
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {

    //记录根节点
    private Node root;
    //记录树中元素的个数
    private int N;

    /**
     * 向树中添加元素 key-value
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);
        if(cmp > 0) {
            //新节点的key大于当前节点的key,继续找当前节点的右子节点
            x.right = put(x.right, key, value);
        } else if(cmp < 0) {
            //新节点的key小于当前节点的key,继续找当前节点的左子节点
            x.left = put(x.left, key, value);
        } else {
            //新节点的key等于当前节点的key,把当前节点的value进行替换
            x.value = value;
        }
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if(x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp > 0) {
            //如果要查询的key大于当前节点的key,则继续找当前节点的右子节点
            return get(x.right, key);
        } else if(cmp < 0) {
            //如果要查询的key小于当前节点的key,则继续找当前节点的左子节点
            return get(x.left, key);
        } else {
            //如果要查询的key等于当前节点的key,则树中返回当前节点的value
            return x.value;
        }
    }

    /**
     * 删除树中key对应的value
     * @param key
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * 删除指定树 x 中的 key 对应的 value ,并返回删除后的新树
     * @param x
     * @param key
     * @return
     */
    private Node delete(Node x, Key key) {
        if(x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp > 0) {
            //新节点的key大于当前节点的key,继续找当前节点的右子节点
            x.right =  delete(x.right, key);
        } else if(cmp < 0) {
            //新节点的key 小于当前节点的key,继续找当前节点的左子节点
            x.left = delete(x.left, key);
        } else {
            //新节点的key 等于当前节点的key,当前节点就是要删除的节点
            //如果当前节点的右子树不存在，则直接返回当前节点的左子节点
            if(x.right == null) {
                return x.left;
            }

            //如果当前节点的左子树不存在，则直接返回当前节点的右子节点
            if(x.left == null) {
                return x.right;
            }
            //当前节点的左右子树都存在
            //找到右子树中最小的节点
            Node minNode = x.right;
            while(minNode.left != null) {
                minNode = minNode.left;
            }
            //删除右子树中最小的节点
            Node n = x.right;
            while(n.left != null) {
                if(n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            //让被删除节点的左子树成为最小节点minNode的左子树，让被删除节点的右子树成为最小节点的右子树
            minNode.left = x.left;
            minNode.right = x.right;
            x = minNode;
            N--;
        }
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        while(x.left != null) {
            x = x.left;
        }
        return x;
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        while(x.right != null) {
            x = x.right;
        }
        return x;
    }


    public int size() {
        return N;
    }

    /**
     * 层序遍历
     * @return
     */
    public Queue<Key> layerErgodic() {
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<Node>();
        nodes.enqueue(root);
        while(!nodes.isEmpty()) {
            Node x = nodes.dequeue();
            keys.enqueue(x.key);
            if(x.left != null) {
                nodes.enqueue(x.left);
            }
            if(x.right != null) {
                nodes.enqueue(x.right);
            }
        }
        return keys;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node x) {
        if(x == null) {
            return 0;
        }
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        //计算左子树的最大深度
        if(x.left != null) {
            maxL = maxDepth(x.left);
        }

        //计算右子树的最大深度
        if(x.right != null) {
            maxL = maxDepth(x.right);
        }
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        return max;
    }


    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
