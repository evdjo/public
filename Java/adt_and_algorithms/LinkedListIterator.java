package abtract_data_types;

/**
 * @author Evdzhan Mustafa Iterator to provide basic operations over a Singly Linked List. Doesn't
 *         support the remove operation.
 * @version 1.0
 */
@SuppressWarnings("unused")
public class LinkedListIterator implements java.util.Iterator<Object> {
    private Node currentPosition;

    public LinkedListIterator(Node firstNode) {
        currentPosition = firstNode.getNext();
    }

    public boolean hasNext() {

        return currentPosition != null;
    }

    @Override
    public Object next() {
        Object returned = currentPosition.getData();
        currentPosition = currentPosition.getNext();
        return returned;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
