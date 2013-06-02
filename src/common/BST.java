package common;
public class BST {
	public BST leftChild;
	public BST rightChild;
	public int key;

	public BST(int key) {
		leftChild = null;
		rightChild = null;
		this.key = key;
	}

	public BST find(BST t, int d) {
		if (t == null)
			return null;
		if (d < t.key)
			return find(t.leftChild, d);
		else if (d > t.key)
			return find(t.rightChild, d);
		else
			return t;
	}

	public BST insert(BST t, int key) {
		if (t == null) {
			return new BST(key);
		} else {
			
			if (key < t.key) {
				t.leftChild = insert(t.leftChild, key);
			} else {
				t.rightChild = insert(t.rightChild, key);
			}
			return t;
		}

	}

	public BST remove(BST t, int key) {
		if (t == null) {
			return t;
		}
		if (key < t.key)
			t.leftChild = remove(t.leftChild, key);
		else if (key > t.key)
			t.rightChild = remove(t.rightChild, key);
		else {
			if (t.leftChild == null && t.rightChild == null) {
				return null;
			}
			if (t.leftChild == null) {
				return t.rightChild;
			}
			if (t.rightChild == null) {
				return t.leftChild;
			}
			if (t.leftChild != null && t.rightChild != null) {
				BST temp = findMin(t.rightChild);
				t.key = temp.key;
				t.rightChild = remove(t.rightChild, temp.key);
			}
		}
		return t;
	}

	public BST findMin(BST t) {
		if (t == null)
			return null;
		if (t.leftChild == null)
			return t;
		else
			return findMin(t.leftChild);
	}

	public BST findMin2(BST t){
		if(t == null){
			return null;
		}
		
		while(t.leftChild != null){
			t = t.leftChild;
		}
		return t;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST t = new BST(5);
		t.insert(t, 2);
		t.insert(t, 1);
		t.insert(t, 3);
		t.insert(t, 7);
		t.insert(t, 6);
		// BST min = t.findMin();
		// System.out.print(min.key);

		// t.remove(t, 0);
		// t.remove(t, 3);
		t.preOrderPrint(t);
		System.out.println();
		t.inOrderPrint(t);
		System.out.println();
		t.postOrderPrint(t);
		System.out.println();
		t.preOrderPrint2(t);
		System.out.println();
		t.inOrderPrint2(t);
		System.out.println();
		t.levelOrderPrint(t);

	}

	

	public void preOrderPrint(BST t) {

		if (t != null) {
			System.out.print(t.key);
			preOrderPrint(t.leftChild);

			preOrderPrint(t.rightChild);
		}
	}

	public void inOrderPrint(BST t) {
		if (t != null) {

			inOrderPrint(t.leftChild);
			System.out.print(t.key);
			inOrderPrint(t.rightChild);
		}
	}

	public void postOrderPrint(BST t) {
		if (t != null) {

			postOrderPrint(t.leftChild);

			postOrderPrint(t.rightChild);
			System.out.print(t.key);
		}
	}

	public void inOrderPrint2(BST t) {
		Stack<BST> s = new Stack<BST>();
		BST current = t;
		boolean finished = false;

		while (!finished) {
			if (current != null) {
				s.push(current);
				current = current.leftChild;
			} else {
				if (!s.empty()) {
					current = s.pop();
					System.out.print(current.key);
					current = current.rightChild;
				} else {
					finished = true;
				}
			}

		}
	}
	
	
	//Pre-order -> DFS -> Stack
	public void preOrderPrint2(BST t) {

		Stack<BST> s = new Stack<BST>();

		s.push(t);
		while (!s.empty()) {
			t = s.pop();
			System.out.print(t.key);
			if (t.rightChild != null) {
				s.push(t.rightChild);
			}
			if (t.leftChild != null) {
				s.push(t.leftChild);
			}
		}
	}

	
	//Level-order -> BFS -> Queue
	public void levelOrderPrint(BST t) {
		Queue<BST> q = new Queue<BST>();
		q.enqueue(t);
		q.enqueue(new BST(0));
		while (!q.isEmpty()) {
			BST x = q.dequeue();
			if (x.key == 0) {
				if (!q.isEmpty())
					q.enqueue(new BST(0));
				System.out.println();
			} else {
				System.out.print(x.key);
			}
			if (x.leftChild != null) {
				q.enqueue(x.leftChild);
			}
			if (x.rightChild != null) {
				q.enqueue(x.rightChild);
			}
		}
	}
	
	public void postOrderPrint2(BST t) {

	}

}
