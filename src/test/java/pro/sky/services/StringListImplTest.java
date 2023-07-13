package pro.sky.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.exceptions.IndexOutException;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {
    private StringList stringListOne;
    private StringList stringListTwo;

    @BeforeEach
    void setUp() {
        stringListOne = new StringListImpl(2);
        stringListTwo = new StringListImpl(2);
    }

    @Test
    void add() {
        stringListOne.add("one_item");
        stringListOne.add("two_item");
        assertThrows(IndexOutException.class, () -> stringListOne.add("three_item"));
        assertThrows(IndexOutException.class, () -> stringListOne.add(2, "three_item"));
    }

    @Test
    void set() {
        assertThrows(IndexOutException.class, () -> stringListOne.set(3, "item"));
    }

    @Test
    void remove() {
        assertThrows(IndexOutException.class, () -> stringListOne.remove("not_item"));
        assertThrows(IndexOutException.class, () -> stringListOne.remove(3));
    }

    @Test
    void contains() {
        stringListOne.add(0, "one");
        assertTrue(stringListOne.contains("one"));
    }

    @Test
    void indexOf() {
        stringListOne.add(0, "one");
        int actual = stringListOne.indexOf("one");
        int expected = stringListOne.indexOf("one");
        assertEquals(actual, expected);
    }

    @Test
    void lastIndexOf() {
        stringListOne.add(0, "one");
        int actual = stringListOne.lastIndexOf("one");
        int expected = stringListOne.lastIndexOf("one");
        assertEquals(actual, expected);
    }

    @Test
    void get() {
        assertThrows(IndexOutException.class, () -> stringListOne.get(5));
    }

    @Test
    void equals() {
        stringListOne.add(0, "one");
        stringListTwo.add(0, "one");
        String[] actual = stringListOne.toArray();
        String[] expected = stringListTwo.toArray();

        assertThrows(IndexOutException.class, () -> stringListOne.equals(null));
        assertArrayEquals(actual, expected);
    }

    @Test
    void size() {
        int actual = stringListOne.size();
        int expected = 2;

        assertEquals(actual, expected);
    }

    @Test
    void isEmpty() {
        assertTrue(stringListOne.isEmpty());
    }

    @Test
    void clear() {
        stringListOne.add(0, "one");
        stringListOne.clear();
        for (int i = 0; i < stringListOne.size(); i++) {
            assertNull(stringListOne.get(i));
        }
    }

    @Test
    void toArray() {
        String[] actual = stringListOne.toArray();
        String[] expected = stringListOne.toArray();
        assertArrayEquals(actual, expected);
    }

}
