package pro.sky.services;

import pro.sky.exceptions.IndexOutException;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private final String[] arrayLists;

    public StringListImpl(int size) {
        this.arrayLists = new String[size];
    }

    @Override
    public String add(String item) {
        if (arrayLists[size() - 1] != null) {
            throw new IndexOutException();
        }

        for (int i = 0; i < arrayLists.length; i++) {
            if (arrayLists[i] == null) {
                arrayLists[i] = item;
                break;
            }
        }
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index >= arrayLists.length) {
            throw new IndexOutException();
        }
        if (arrayLists[index] == null) {
            arrayLists[index] = item;
            return item;
        }

        for (int j = arrayLists.length - 1; j >= 1; j--) {
            arrayLists[j] = arrayLists[j - 1];
        }
        arrayLists[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= arrayLists.length) {
            throw new IndexOutException();
        }
        arrayLists[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < arrayLists.length; i++) {
            if (arrayLists[i] != item) {
                throw new IndexOutException();
            }
            if (arrayLists[i] == item) {
                arrayLists[i] = null;
                break;
            }
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index >= arrayLists.length || arrayLists[index] == null) {
            throw new IndexOutException();
        }
        if (arrayLists[index] != null) {
            arrayLists[index] = null;
        }
        return arrayLists[index];
    }

    @Override
    public boolean contains(String item) {
        for (String arrayList : arrayLists) {
            if (arrayList == item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < arrayLists.length; i++) {
            if (arrayLists[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = arrayLists.length - 1; i >= 1; i--) {
            if (arrayLists[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= arrayLists.length) {
            throw new IndexOutException();
        }
        return arrayLists[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IndexOutException();
        }

        int result = 0;
        for (int i = 0; i < arrayLists.length; i++) {
            if (Objects.equals(otherList.get(i), arrayLists[i]) && otherList.size() == arrayLists.length) {
                result++;
            }
        }

        return arrayLists.length == result;
    }

    @Override
    public int size() {
        return arrayLists.length;
    }

    @Override
    public boolean isEmpty() {
        int result = 0;
        for (String arrayList : arrayLists) {
            if (arrayList == null) {
                result++;
                if (arrayLists.length == result) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(arrayLists, null);
    }

    @Override
    public String[] toArray() {
        String[] arr = new String[arrayLists.length];
        System.arraycopy(arrayLists, 0, arr, 0, arr.length);
        return arr;
    }
}
