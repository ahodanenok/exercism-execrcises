/**
 * Linked List
 * https://exercism.org/tracks/java/exercises/linked-list
 */
public class DoublyLinkedList<T> {

    private Element<T> head;

    void push(T value) {
        Element<T> tail = tail();
        Element<T> element = new Element<T>(value, tail, null);
        if (tail != null) {
            tail.next = element;
        } else {
            head = element;
        }
    }

    T pop() {
        Element<T> tail = tail();
        if (tail == null) {
            return null;
        }

        if (tail.prev != null) {
            tail.prev.next = null;
        } else {
            head = null;
        }
        tail.prev = null;

        return tail.value;
    }

    void unshift(T value) {
        Element<T> element = new Element<>(value, null, head);
        if (head != null) {
            head.prev = element;
        }
        head = element;
    }

    T shift() {
        if (head == null) {
            return null;
        }

        Element<T> element = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        element.next = null;

        return element.value;
    }

    private Element<T> tail() {
        if (head == null) {
            return null;
        }

        Element<T> element = head;
        while (element.next != null) {
            element = element.next;
        }

        return element;
    }

    private static final class Element<T> {

        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
