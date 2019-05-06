package com.lewis.learn.datastruct.linear.array;

import lombok.extern.slf4j.Slf4j;

/**
 * @author minghzhang
 * 实现数组的查询、插入、删除、更新
 * @date 2019/05/06
 */
@Slf4j
public class LewisRawArray {

    private String[] data;

    /**
     * 数组中实际的元素个数
     */
    private int size;
    /**
     * 数组中最大可容纳的元素个数
     */
    private int capacity;

    public LewisRawArray(int capacity) {
        data = new String[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public String find(int index) {
        if (index < 0 || index >= size) {
            return "not_found";
        }
        return data[index];
    }

    public boolean insert(int index, String value) {
        // 数组空间已满
        if (size == capacity) {
            log.info("数组已满，没有可插入的位置");
            return false;
        }
        // 如果size还没满，那么就可以插入数据到数组中
        // 位置不合法
        if (index < 0 || index > size) {
            log.info("插入的位置不合法");
            return false;
        }
        // 位置合法
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        //从删除位置开始，将后面的元素向前移动一位
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        //删除数组末尾元素
        data[size - 1] = null;
        size--;
        return true;
    }

    public void printArray() {
        for (String datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LewisRawArray rawArray = new LewisRawArray(10);
        rawArray.insert(0, "zero");
        rawArray.insert(0, "two");
        rawArray.insert(0, "three");
        rawArray.insert(0, "four");
        rawArray.insert(0, "five");
        rawArray.insert(0, "six");
        rawArray.printArray();
    }
}
