package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

		this.previous = null;
	}

	@Override
	public void insert(T element) {

		if (element != null) {

			if (this.isEmpty()) {

				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl());
				this.setPrevious(new RecursiveDoubleLinkedListImpl());

			} else {
				this.getNext().insert(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {

		if (element != null) {
			
			if (this.isEmpty()) {

				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl());
				this.setPrevious(new RecursiveDoubleLinkedListImpl());

			} else {

				this.getPrevious().insertFirst(this, element);

			}

		}

	}

	private void insertFirst(RecursiveDoubleLinkedListImpl<T> head, T element) {

		if(!head.isEmpty()) {
		RecursiveDoubleLinkedListImpl newNode = new RecursiveDoubleLinkedListImpl();
		newNode.setData(head.getData());
		newNode.setNext(head.getNext());
		newNode.setPrevious(head.getPrevious());

		((RecursiveDoubleLinkedListImpl<T>) newNode.getNext()).setPrevious(newNode);
		head.setData(element);
		head.setNext(newNode);
		}else {
			
			insertFirst(head.getPrevious(), element);
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {

			if (this.getPrevious().getData() == null) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
				this.setPrevious(null);
			} else {
				this.getPrevious().removeFirst();
			}
		}
	}

	@Override
	public void removeLast() {

		if (!this.isEmpty()) {

			if (this.getNext().isEmpty()) {

				this.setData(this.getPrevious().getData());
				this.setPrevious(this.getPrevious().getPrevious());
				this.setNext(null);

			} else {

				((DoubleLinkedList<T>) this.getNext()).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
