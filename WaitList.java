public class WaitList<E> {
	class Node<E> {
		E value;
		Node<E> next;
		public Node(E value_) {
			this.value = value_;
			this.next = null;
		}
	}
	private Node<E> front;
	private Node<E>rear;
	public WaitList() {
		front = null;
		rear = null;
	}
	public void addToWaitList(E obj) {
		Node<E> newNode = new Node<E>(obj);
		if (rear == null) {
			front = newNode;
			rear = newNode;
			return;
		}
		rear.next = newNode;
		rear = newNode;
	}
	public E getNext() {
		if (front == null)
			return null;
		Node<E> rtnNode = front;
		if (front.next == null) {
			front = null;
			rear = null;
		}
		else {
			front = front.next;
		}
		return rtnNode.value;
	}
	public boolean isEmpty() {
		return front == null && rear == null;
	}
}
