package common;
public class LinkedList {

	public LinkedListNode head;

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void add(int d) {
		LinkedListNode node = new LinkedListNode(d);

		if (isEmpty()) {
			head = node;
			return;
		}

		LinkedListNode p = head;
		while (p.next != null) {
			p = p.next;
		}
		p.next = node;
	}

	public void insert(int d, int pos) {
		LinkedListNode node = new LinkedListNode(d);

		if (isEmpty()) {
			head = node;
			return;
		}
		if (pos == 1) {
			node.next = head;
			head = node;
			return;
		}

		LinkedListNode prev = head;
		while (pos > 2 && prev.next != null) {
			pos--;
			prev = prev.next;
		}
		if (prev.next != null) {
			node.next = prev.next;
			prev.next = node;
		}

	}

	public void delete(int d) {

		if (isEmpty()) {
			return;
		}

		if (head.data == d) {
			head = head.next;
			return;
		}

		LinkedListNode prev = head;
		while (prev.next != null && prev.next.data != d) {
			prev = prev.next;
		}
		if (prev.next != null) {
			prev.next = prev.next.next;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.insert(0, 5);

		list.print();
		list.reverse();
		list.print();
	
	}

	private void reverse() {

		LinkedListNode p = head;
		LinkedListNode next;
		LinkedListNode prev = null;
		
		while(p != null){
			next = p.next;
			p.next = prev;
			prev = p;
			p = next;
		}
		
		head = prev;
	}

	public void print() {
		LinkedListNode p = head;
		while (p != null) {
			System.out.println(p.data);
			p = p.next;

		}
	}
	
	

}
