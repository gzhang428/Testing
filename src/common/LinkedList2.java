package common;
public class LinkedList2 {
	private LinkedListNode head;

	/**
	 * @param args
	 */
	public LinkedList2() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public LinkedListNode add(int d) {
		LinkedListNode node = new LinkedListNode(d);

		if (isEmpty()) {
			head = node;
			return head;
		}

		LinkedListNode p = head;
		while (p.next != null) {
			p = p.next;
		}
		p.next = node;
		return node;
	}

	public void print() {
		LinkedListNode p = head;
		while (p != null) {
			System.out.println(p.data);
			p = p.next;

		}
	}

	LinkedListNode findStart() {
		LinkedListNode n1 = head;
		LinkedListNode n2 = head;
		while (n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			System.out.println(n1.data+" " + n2.data);
			if (n1 == n2) {
				break;
			}
		}

		if (n2.next == null) {
			return null;
		}
		
		n1 = head;
		while(n1 != n2){
			n1 = n1.next;
			n2 = n2.next;
			
		}
		
		return n2;
	}
	
	
	public LinkedListNode findMiddle2(){
		LinkedListNode n1 = head;
		LinkedListNode n2 = head;
		int i = 0;
		while(n1.next!=null){
			if(i == 0){
				n1 = n1.next;
				i = 1;
			}else if(i == 1){
				n1 = n1.next;
				n2 = n2.next;
				i = 0;
			}
		}
		return n2;
		
		
	}
	
	public boolean hasCircle(){
		LinkedListNode n1 = head;
		LinkedListNode n2 = head;
		
		while(true){
			if(n1.next != null)
				n1 = n1.next;
			else
				return false;
			if(n2.next != null)
				n2 = n2.next;
			else
				return false;
			if(n2.next!=null)
				n2 = n2.next;
			else 
				return false;
			if(n1 == n2)
				return true;
			
		}
	}

	public static void main(String[] args) {
		LinkedList2 list = new LinkedList2();
		//list.add(0);
		list.add(1);
		list.add(2);
		LinkedListNode n3 = list.add(3);
		list.add(4);
		LinkedListNode n5 = list.add(5);
		//list.add(6);
		//n5.next = n3;
		
		//list.print();
		//System.out.println(list.hasCircle());
//		LinkedListNode b = list.findStart();
//		System.out.println(b.data);
		System.out.println(list.findMiddle2().data);
	}

}
