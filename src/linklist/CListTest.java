package linklist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CListTest {

    @Test
    void testPrependAndToStringR() {
        CList<String> cl= new CList<>();
        assertEquals("[]", cl.toString());
        assertEquals("[]", cl.toStringR());
        assertEquals(0, cl.size());
        cl.prepend("CS2110");
        assertEquals("[CS2110]", cl.toString());
        assertEquals("[CS2110]", cl.toStringR());
        assertEquals(1, cl.size());
        cl.prepend("second");
        assertEquals("[second, CS2110]", cl.toString());
        assertEquals("[CS2110, second]", cl.toStringR());
        assertEquals(2, cl.size());
        cl.prepend(null);
        assertEquals("[null, second, CS2110]", cl.toString());
        assertEquals("[CS2110, second, null]", cl.toStringR());
        assertEquals(3, cl.size());
        CList<Integer> c2= new CList<>();
        c2.prepend(0);
        assertEquals("[0]", c2.toString());
        assertEquals("[0]", c2.toStringR());
        assertEquals(1, c2.size());
        c2.prepend(1);
        assertEquals("[1, 0]", c2.toString());
        assertEquals("[0, 1]", c2.toStringR());
        assertEquals(2, c2.size());
        CList<String> c3= new CList<>();
        c3.prepend("");
        assertEquals("[]", c3.toString());
        assertEquals("[]", c3.toStringR());
        assertEquals(1, c3.size());
        c3.prepend("");
        assertEquals("[, ]", c3.toString());
        assertEquals("[, ]", c3.toStringR());
        assertEquals(2, c3.size());
    }

    @Test
    void testChangeHeadToNext() {
        CList<Integer> cl= new CList<>();
        CList<Integer>.Node next;
        next= cl.changeHeadToNext();
        assertEquals(cl.head(), next);
        assertEquals("[]", cl.toString());
        assertEquals("[]", cl.toStringR());
        assertEquals(0, cl.size());
        cl.prepend(6);
        next= cl.changeHeadToNext();
        assertEquals(cl.head(), next);
        assertEquals("[6]", cl.toString());
        assertEquals("[6]", cl.toStringR());
        assertEquals(1, cl.size());
        cl.prepend(4);
        next= cl.changeHeadToNext();
        assertEquals(cl.head(), next);
        assertEquals("[6, 4]", cl.toString());
        assertEquals("[4, 6]", cl.toStringR());
        assertEquals(2, cl.size());
        CList<Integer> c2= new CList<>();
        c2.prepend(6);
        c2.prepend(4);
        c2.prepend(3);
        c2.prepend(5);
        next= c2.changeHeadToNext();
        assertEquals(c2.head(), next);
        assertEquals("[3, 4, 6, 5]", c2.toString());
        assertEquals("[5, 6, 4, 3]", c2.toStringR());
        assertEquals(4, c2.size());
    }

    @Test
    void testAppend() {
        CList<String> cl= new CList<>();
        assertEquals("[]", cl.toString());
        assertEquals("[]", cl.toStringR());
        assertEquals(0, cl.size());
        cl.append("CS2110");
        assertEquals("[CS2110]", cl.toString());
        assertEquals("[CS2110]", cl.toStringR());
        assertEquals(1, cl.size());
        cl.append("second");
        assertEquals("[CS2110, second]", cl.toString());
        assertEquals("[second, CS2110]", cl.toStringR());
        assertEquals(2, cl.size());
        cl.append(null);
        assertEquals("[CS2110, second, null]", cl.toString());
        assertEquals("[null, second, CS2110]", cl.toStringR());
        assertEquals(3, cl.size());
        CList<Integer> c2= new CList<>();
        c2.append(0);
        assertEquals("[0]", c2.toString());
        assertEquals("[0]", c2.toStringR());
        assertEquals(1, c2.size());
        c2.append(1);
        assertEquals("[0, 1]", c2.toString());
        assertEquals("[1, 0]", c2.toStringR());
        assertEquals(2, c2.size());
        CList<String> c3= new CList<>();
        c3.append("");
        assertEquals("[]", c3.toString());
        assertEquals("[]", c3.toStringR());
        assertEquals(1, c3.size());
        c3.prepend("");
        assertEquals("[, ]", c3.toString());
        assertEquals("[, ]", c3.toStringR());
        assertEquals(2, c3.size());
    }

    @Test
    void testGetNode() {
        CList<String> cl= new CList<>();
        cl.append("hey");
        assertEquals(cl.head(), cl.getNode(0));
        cl.append("you");
        assertEquals(cl.tail(), cl.getNode(1));
        cl.prepend("sup");
        assertEquals(cl.head().next(), cl.getNode(1));
        assertThrows(AssertionError.class, () -> { cl.getNode(cl.size()); });
        assertThrows(AssertionError.class, () -> { cl.getNode(-1); });
    }

    @Test
    void testRemove() {
        CList<Double> cl= new CList<>();
        cl.append(1.0);
        cl.remove(cl.getNode(0));
        assertEquals("[]", cl.toString());
        assertEquals("[]", cl.toStringR());
        assertEquals(0, cl.size());
        cl.append(2.0);
        cl.append(3.0);
        cl.remove(cl.getNode(0));
        assertEquals("[3.0]", cl.toString());
        assertEquals("[3.0]", cl.toStringR());
        assertEquals(1, cl.size());
        assertThrows(AssertionError.class, () -> { cl.remove(null); });
    }

    @Test
    void testInsertBefore() {
        CList<Integer> cl= new CList<>();
        cl.append(1);
        cl.insertBefore(0, cl.getNode(0));
        assertEquals("[0, 1]", cl.toString());
        assertEquals("[1, 0]", cl.toStringR());
        assertEquals(2, cl.size());
        cl.insertBefore(2, cl.getNode(1));
        assertEquals("[0, 2, 1]", cl.toString());
        assertEquals("[1, 2, 0]", cl.toStringR());
        assertEquals(3, cl.size());
        cl.insertBefore(3, cl.getNode(2));
        assertEquals("[0, 2, 3, 1]", cl.toString());
        assertEquals("[1, 3, 2, 0]", cl.toStringR());
        assertEquals(4, cl.size());
        assertThrows(AssertionError.class, () -> { cl.insertBefore(1, null); });
    }
}
