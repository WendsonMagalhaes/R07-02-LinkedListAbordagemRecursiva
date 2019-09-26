package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.getData() == null;
	}

	@Override
	public int size() {

		if (this.isEmpty()) {
			return 0;
		} else {
			return 1 + this.getNext().size();
		}

	}

	@Override
	public T search(T element) {
		if (this.isEmpty()) {
			return null;
		} else if (this.getData().equals(element)) {
			return this.getData();
		} else {
			return this.getNext().search(element);
		}
	}

	@Override
	public void insert(T element) {
		
		if (element != null) {
			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<T>());
			} else {
				this.getNext().insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {

		if (!this.isEmpty()) {
			if (this.getData().equals(element)) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			} else {
				this.getNext().remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {

		T[] result = (T[]) new Object[this.size()];
		toArray(result, this, -1);
		return result;

	}

	private void toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int i) {
		i++;
		if (!node.isEmpty()) {
			array[i] = node.getData();

			toArray(array, node.getNext(), i);
		}

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
