package com.htjs.datastructure.heap;

public class HeapSort {

    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private static void exch(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    /**
     * 根据原始数据source,构造出堆heap
     * @param source
     * @param heap
     */
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        //把source中的元素拷贝到heap中，heap中的元素形成了一个堆，这个堆是无序的堆
        System.arraycopy(source, 0, heap, 1, source.length);
        //对堆中的元素下沉调整，调整范围从长度的一半出开始，往索引1处扫描
        for(int i = (heap.length / 2);i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }

    }

    /**
     * 对source数组中的数据从小到大排序
     * @param source
     */
    public static void sort(Comparable[] source) {
        //构造堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        //定义一个变量，记录未排序元素中最大索引
        int N = heap.length - 1;
        //通过循环交互1索引处元素和未排序元素最大索引处元素
        while(N != 1) {
            //交换元素
            exch(heap, 1, N);
            //排除交换后最大元素所在的索引，让它不要参与堆的下沉
            N--;
            //对索引1处进行堆下沉调整
            sink(heap, 1, N);
        }
        //把heap中的元素复制到原数据中
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    /**
     * 在heap堆中，对target处元素做下沉，范围是0 - range
     * @param heap
     * @param target
     * @param range
     */
    private static void sink(Comparable[] heap, int target, int range) {
        while(2 * target <= range) {
            //找出当前节点的较大子节点
            int max;
            if(2 * target + 1 <= range) {
                if(less(heap, 2 * target, 2 * target + 1)) {
                    max = 2 * target + 1;
                } else {
                    max = 2 * target;
                }
            } else {
                max = 2 * target;
            }
            //比较当前节点值和较大子节点值
            if(!less(heap, target, max)) {
                break;
            }
            exch(heap, target, max);
            target = max;
        }
    }

}
