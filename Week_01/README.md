学习笔记
一周的学习，感觉有点力不从心，虽然已尽量抽出时间来完成，但还是有一大半题目没有做完，更别提做两遍了。
算法思路比较薄弱，一些简单的问题甚至都木有思路，有思路的也需要花费较长时间来完成，还是需要多加练习才行。

本周首先是对算法基础知识进行了了解：
1.
时间复杂度:算法执行的次数，常用的时间负责度有：O(n)、O(1)、O(logn)、O(n^2)、O(n!)等
可以通过主定理来计算递归的时间复杂度（暂时还记下主定理）
空间复杂度：一般指数组的长度或者递归的深度；如果两者同时存在，取最大值!

2.
学习到了一个新的数据结构跳表,跳表(Skip list)简单来说是优化队列访问元素的时间复杂度为O(n)
注意：跳表只能用于元素有序的情况，所以其对标的是平衡树（ACL)和二分查找
其插入、删除、搜索的时间复杂度都是O(logn)的
Redis、LevelDB使用了跳表

PriorityQueue源码分析
//如果采用其默认的无参构造器，默认初始化大小为11
public PriorityQueue() {
     this(DEFAULT_INITIAL_CAPACITY, null);
}
我们可以实现自己的比较器来定义队列中元素如何排序
 public PriorityQueue(Comparator<? super E> comparator) {
           this(DEFAULT_INITIAL_CAPACITY, comparator);
} 

1.add()、offer()方法：
//add方法底层直接调用的offer方法
public boolean add(E e) {
        return offer(e);
}
我们直接看offer方法：
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        //队列修改次数+1
        modCount++;
        int i = size;
        if (i >= queue.length)
        //如果超过队列长度进行扩容，原长度<64则2倍，否则1.5倍
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
        //siftUp方法中，对comparator和comparable进行了区别，两方法内部实现一样
            siftUp(i, e);
        return true;
    } 
    
下面是Comparable实现
大体意思是采用二分法，如果当前索引前一位二分位置值>插入值，则将二分位置值插入到当前位置，
以此类推，直到二分位置值<=插入值，将插入值赋值给该二分位置parent位置
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }
