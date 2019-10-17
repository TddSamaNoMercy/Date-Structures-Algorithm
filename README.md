# 常见问题总结
## LinkedList
1. 添加节点时需要注意顺序
```
Node<T> node = new Node<>(preNode,preNode.next,t);
        preNode.next.pre = node;
        preNode.next = node;
```
2. 插入数据到双向列表中需要注意判断当前节点的next是否为空
```
public void add(E e, int index) {
        if (index >= 0 && index <= size) {
            Node preNode = dh;
            for (int i = 0; i < index; i++) {
                preNode = preNode.next;
            }
            Node n = new Node(e, preNode, preNode.next);
            if (preNode.next != null) preNode.next.pre = n;
            preNode.next = n;

            if (preNode == tail) tail = n;
            size++;
        } else {
            throw new IllegalArgumentException();
        }
    }
 ```
