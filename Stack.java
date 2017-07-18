/**
 * @author Bianca Steele
 * @version 7/13/16 This is the Stack class portion of the Lists, Stacks, and
 *          Queues homework. It creates a small three element array and can
 *          resize itself as needed. It contains the push, pop, toString,
 *          equals, isEmpty, peek, and size methods.
 */
public class Stack {

	// Class data
	private int capacity = 2;
	private Object[] data = new Object[capacity];
	private int numElements;

	// Precondition: An Object is sent to be pushed to the Stack object.
	// Postcondition: The element is added to the Stack and the numElements
	// variable is incremented. Stack is resized as needed.
	public void push(Object next) {
		if (numElements == capacity)
			doubleInSize();
		data[numElements++] = next;
	}

	// Precondition: None
	// Postcondition: The last element of the Stack is popped, numElements is
	// decremented
	public Object pop() {
		if (data[numElements - 1] == null) {
			throw new IllegalStateException();
		} else {
			Object returnItem = data[numElements - 1];
			numElements--;
			// Bonus resizing function that decreases the size of the Stack when
			// it gets
			// down to half of its capacity
			/*
			 * if (numElements == capacity / 2) { Object[] temp = new
			 * Object[capacity]; for (int i = 0; i < numElements; i++) { temp[i]
			 * = data[i]; } data = temp; }
			 */
			return returnItem;
		}
	}

	// Precondition: Stack has reached capacity
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

	// Precondition: None
	// Postcondition: The number of elements in the Stack is returned.
	public int size() {
		int temp = numElements;
		return temp;
	}

	// Precondition: None
	// Postcondition: Returns boolean value based on emptiness of Stack object
	public boolean isEmpty() {
		return numElements == 0;
	}

	// Precondition: A Stack object is sent to be compared to the calling Stack
	// object
	// Postcondition: A boolean is returned stating if the two Stacks are equal
	// in size and content
	boolean equals(Stack that) {
		if (that != null && that instanceof Stack) {
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
	// Postcondition: The Stack is converted to a String object and returned
	@Override
	public String toString() {
		String line = "";
		for (int i = 0; i < numElements; i++) {
			line = line + data[i];
		}
		return line;
	}
	/*
	 * //Bonus indexOf and peek methods
	 * 
	 * // Precondition: An element is sent to be found in the Stack //
	 * Postcondition: If the element exists in the Stack, it's index is //
	 * returned. If the element doesn't exist in the Stack, -1 is returned.
	 * public int indexOf(Object that) { for (int i = 0; i < numElements; i++) {
	 * if (this.data[i] == that) { return i; } } return -1; }
	 * 
	 * // Precondition: None // Postcondition: Returns last value in Stack
	 * without popping it public Object peek() { return this.data[numElements -
	 * 1]; }
	 */
}