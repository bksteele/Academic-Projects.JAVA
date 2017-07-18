/**
 * @author Bianca Steele
 * @version 7/13/16 This is the Queue class portion of the Lists, Stacks, and
 *          Queues homework. It creates a small three element array and can
 *          resize itself as needed. It contains the enqueue, dequeue, toString,
 *          equals, isEmpty, and size methods.
 */
public class Queue {

	// Data elements
	private int capacity = 2;
	private Object[] data = new Object[capacity];
	private int numElements;

	// Precondition: An Object is sent to be enqueued
	// Postcondition: An element is added to the Queue and the numElements is
	// incremented. Queue is resized as needed.
	public void enqueue(Object next) {
		// If loop determines if array needs to be resized
		if (numElements == capacity)
			doubleInSize();
		data[numElements++] = next;
	}

	// Precondition: None
	// Postcondition: An element is removed from the Queue object
	public Object dequeue() {
		if (data[numElements - 1] == null) {
			throw new IllegalStateException();
		} else {
			Object outObject = data[0];
			// The shiftLeft method is now called to shift and resize the Queue
			// array
			shiftLeft();
			numElements--;
			return outObject;
		}
	}

	// Precondition: An item is dequeued from the Queue object
	// Postcondition: Each element is shifted one place to the left.
	private void shiftLeft() {
		for (int i = 0; i < numElements - 1; i++) {
			data[i] = data[i + 1];
		}
		Object[] temp = new Object[capacity];
		for (int i = 0; i < numElements; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	// Precondition: None
	// Postcondition: The number of elements in the Queue is returned.
	public int size() {
		int temp = numElements;
		return temp;
	}

	// Precondition: None
	// Postcondition: Returns boolean value based on emptiness of Queue object
	public boolean isEmpty() {
		return numElements == 0;
	}

	// Precondition: Queue has reached capacity
	// Postcondition: Capacity is doubled and a new array is created by copying
	// the old one
	private void doubleInSize() {
		capacity = capacity * 2;
		Object[] temp = new Object[capacity];
		for (int i = 0; i < numElements; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	// Precondition: A Queue object is sent to be compared to the calling Queue
	boolean equals(Queue that) {
		if (that != null && that instanceof Queue) {
			if (this.size() == that.size()) {
				for (int i = 0; i < this.size(); i++) {
					if (this.data[i] != that.data[i]) {
						return false;
					}
					return true;
				}
			}
		}
		return false;
	}

	// Precondition: None
	// Postcondition: The Queue is converted to a String object and returned
	@Override
	public String toString() {
		String line = "";
		for (int i = 0; i < numElements; i++) {
			line = line + data[i];
		}
		return line;
	}

	/*
	//Bonus indexOf method
	// Precondition: An element is sent to be found in the Queue
	// Postcondition: If the element exists in the Queue, it's index is
	// returned. If the element doesn't exist in the Queue, -1 is returned.
	public int indexOf(Object that) {
		for (int i = 0; i < numElements; i++) {
			if (this.data[i] == that) {
				return i;
			}
		}
		return -1;
	}
	*/
}
