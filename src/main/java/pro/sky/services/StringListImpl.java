package pro.sky.services;

import pro.sky.exceptions.*;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private final String[] arrayLists;
    private int size;

    public StringListImpl() {
        arrayLists = new String[10];
    }

    public StringListImpl(int initSize) {
        arrayLists = new String[initSize];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        arrayLists[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);

        if (index == size) {
            arrayLists[size++] = item;
            return item;
        }

        System.arraycopy(arrayLists, index, arrayLists, index + 1, size - index);
        arrayLists[index] = item;
        size++;

        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        arrayLists[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = arrayLists[index];
        if (index != size) {
            System.arraycopy(arrayLists, index + 1, arrayLists, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (arrayLists[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayLists[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return arrayLists[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arrayLists, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == arrayLists.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > 0) {
            throw new InvalidIndexException();
        }
    }
}
