public class LinkedList<Object> {

    private Node first;
    private Node current;
    private Node last;
    private int currentIndex;
    private int numElements;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.numElements = 0;
        this.current = null;
        this.currentIndex = -1;
    }

    private class Node {
        Node next;
        Node previous;
        Object data;
    }

    public boolean hasNext() {
        return (current != null && current.next != null);
    }

    public Object next() {
        if (!this.hasNext()) {
            throw new IllegalStateException("No next");
        }

        current = current.next;
        return current.data;

    }

    public boolean hasPrevious() {
        return (current != null && current.previous != null);

    }

    public Object previous() {
        if (!this.hasPrevious()) {
            throw new IllegalStateException("No previous");
        }
        current = current.previous;
        return current.data;

    }

   int nextIndex() {
        int index = numElements;
        if (hasNext()) {
            index = this.currentIndex + 1;
        }
        System.out.println(index + "The current index is " + current);
        return index;
    }

    int previousIndex() {
        int index = -1;
        if (hasPrevious()) {
            index = this.currentIndex - 1;
        }
        System.out.println(index + "The current index is " + current);
        return index;
    }

    public void set(Object o) {
        if (this.current == null) {
            throw new IllegalStateException("No node found, cannot set.");
        }
        current.data = o;
    }

    public int size() {
        return numElements;
    }

    public void add(Object o) {       
        Node newNode = new Node();
        newNode.data = o;
        if (first == null) {
            first = newNode;
            last = newNode;
            newNode.next = null;

        } else if (first != null) {
            if (current == null) {
                newNode.previous = null;
                newNode.next = first;
                first.previous = newNode;
                first = newNode;
            } else if (current == last) {
                newNode.previous = current;
                newNode.next = null;
                current.next = newNode;
                last = newNode;
            } else {
                newNode.previous = current;
                newNode.next = current.next;
                current.next.previous = newNode;
                current.next = newNode;
            }
        }
        current = newNode;
        numElements++;
        currentIndex++;

    }
    
	public Object get(int position) {
		current = first;
		for(int i=0; i < position; i++)
			current = current.next;
		return current.data;
	}
    

    public void remove() {
        if (current != null) {
            if (current == first && current == last) {
                first = null;
                last = null;
            } else if (current == last) {
                current.previous = null;
                last = current.previous;
            } else if (current == last) {
                current.previous.next = null;
                last = current.previous;
            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
            current = current.next;
            numElements--;
        }
    }
}
