/**
 * @author Bianca Steele
 * @version 7/13/16 This is the ArrayList class portion of the Lists, Stacks,
 *          and Queues homework. It creates a small three element array and can
 *          resize itself as needed. It contains the insert, remove, toString,
 *          equals, isEmpty, shiftLeft, shiftRight, and size methods.
 */
public class ArrayList {

	// Data elements
	private int capacity = 2;
	private Object[] data = new Object[capacity];
	private int numElements;

	// Precondition: An Object is sent to be added to the ArrayList
	// Postcondition: The element is added to the ArrayList object at the index
	// after the elements starting at the index are shifted right. ArrayList
	// is resized as needed. The numElements value is incremented.
	public void insert(Object next, int index) {
		// If loop determines if array needs to be resized
		if (numElements == capacity)
			doubleInSize();
		if (index < 0 || index > numElements) {
			throw new RuntimeException("Bad index.");
		}
		shiftRight(index);
		numElements++;
		data[index] = next;
	}

	// Precondition: An index of an element to be removed is sent to the
	// ArrayList
	// Postcondition: The element at the index is removed. The following
	// elements are shifted left. The removed element is returned.
	public Object remove(int index) {
		if (data[numElements - 1] == null) {
			throw new IllegalStateException();
		}
		if (index < 0 || index > numElements) {
			throw new RuntimeException("Bad index.");
		} else {
			Object outObject = data[index];
			// The shiftLeft method is now called to shift the ArrayList
			shiftLeft(index);
			numElements--;
			return outObject;
		}
	}

	// Precondition: An item is removed from the ArrayList object
	// Postcondition: Each element is shifted one place to the left starting at
	// the index.
	private void shiftLeft(int index) {
		for (int i = index; i < numElements - 1; i++) {
			data[i] = data[i + 1];
		}
	}

	// Precondition: An item is added to the ArrayList object
	// Postcondition: Each element is shifted one place to the right starting at
	// the index.
	private void shiftRight(int index) {
		for (int i = numElements - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
	}

	// Precondition: None
	// Postcondition: The number of elements in the ArrayList is returned.
	public int size() {
		int temp = numElements;
		return temp;
	}

	// Precondition: None
	// Postcondition: Returns boolean value based on emptiness of ArrayList
	// object
	public boolean isEmpty() {
		return numElements == 0;
	}

	// Precondition: An element is sent to be found in the ArrayList
	// Postcondition: If the element exists in the ArrayList, it's index is
	// returned. If the element doesn't exist in the ArrayList, -1 is returned.
	public int indexOf(Object that) {
		for (int i = 0; i < numElements; i++) {
			if (this.data[i] == that) {
				return i;
			}
		}
		return -1;
	}

	// Precondition: ArrayList has reached capacity
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

	// Precondition: An ArrayList object is sent to be compared to the calling
	// ArrayList
	// object
	// Postcondition: A boolean is returned stating if the two ArrayLists are
	// equal
	// in size and content
	boolean equals(ArrayList that) {
		if (that != null && that instanceof ArrayList) {
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
	// Postcondition: The ArrayList is converted to a String object and returned
	@Override
	public String toString() {
		String line = "";
		for (int i = 0; i < numElements; i++) {
			line = line + data[i];
		}
		return line;
	}

}
