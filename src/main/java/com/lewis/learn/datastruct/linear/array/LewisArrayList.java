package com.lewis.learn.datastruct.linear.array;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author minghzhang
 * @date 2019/05/06
 */
public class LewisArrayList {
    private Object[] data;
    /**
     * 容器中元素的实际个数
     */
    private int size;

    private static final int INDEX_NOT_FOUND = -1;

    public LewisArrayList(int capacity) {
        Preconditions.checkArgument(capacity >= 0, "capacity must be >= 0!");
        data = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(Object target) {
        for (int i = 0; i < data.length; i++) {
            if (Objects.equal(target, data[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public int lastIndexOf(Object target) {
        for (int i = data.length; i >= 0; i--) {
            if (Objects.equal(target, data[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public boolean contains(Object target) {
        return indexOf(target) >= 0;
    }

    public boolean add(Object element) {

        return true;
    }

    public boolean add(int index, Object element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        //todo
        for (int i = index; i < size; i++) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= data.length) {
            int oldCapacity = data.length;
            int newCapacity = oldCapacity + oldCapacity >> 1;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
        }
    }

    public static void main(String[] args) {
        System.out.println(Objects.equal(null, null));
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(1, "1");
        String[] ss = new String[]{"1", "2", "3", "4"};
        String[] sss = new String[9];
        String[] strings = Arrays.copyOf(ss, 9);
        System.out.println(strings);
    }

}
