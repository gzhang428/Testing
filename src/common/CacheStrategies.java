package common;
/**
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="www.sureinterview.com">SureInterview</a>
 */
public class CacheStrategies {

	public interface CacheStrategy<K, T> {
		/**
		 * get the data by key.
		 * 
		 * @param key
		 * @return
		 */
		T get(K key);

		/**
		 * put <key, data> pair
		 * 
		 * @param key
		 * @param data
		 */
		void put(K key, T data);

		/**
		 * helper function
		 * 
		 * @return
		 */
		List<K> toAry();
	}

	class CacheStrategyLRU<K, T> implements CacheStrategy<K, T> {
		class Node {
			T data;
			K key;
			Node next;
			Node prev;

			public Node(K key, T data) {
				this.data = data;
				this.key = key;
			}
		}

		Node head;
		Node tail;
		Map<K, Node> map;

		int maxsize;
		

		public CacheStrategyLRU(int maxsize) {
			this.maxsize = maxsize;
			map = new HashMap<K, Node>();
			// hook up the head and tail nodes
			head = new Node(null, null);
			tail = new Node(null, null);
			head.next = tail;
			tail.prev = head;
		}

		private void attach(Node head, Node node) {
			// add note behind the head.
			node.prev = head;
			node.next = head.next;
			node.next.prev = node;
			node.prev.next = node;
		}

		private void detach(Node node) {
			// detach it from the queue
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		/**
		 * get data
		 */
		@Override
		public T get(K key) {
			Node node = map.get(key);
			if (node == null)
				return null;

			if (map.size() == 1)
				return node.data;

			// refresh
			// - detach it from the queue
			detach(node);
			// - attach it to head
			attach(head, node);
			return node.data;
		}

		/**
		 * put <key,data> into cache.
		 */
		@Override
		public void put(K key, T data) {
			if (maxsize <= 0)
				return;

			Node node = map.get(key);
			if (node != null) {
				// hit, just update data
				detach(node);
				attach(head, node);
				node.data = data;
			} else {
				// miss, create new data
				node = new Node(key, data);
				map.put(key, node);
				attach(head, node);
				if (map.size() > maxsize) {
					// overflow, remove the tail
					map.remove(tail.prev.key);
					detach(tail.prev);
					
				}
			}
		}

		/**
		 * helper function
		 */
		@Override
		public List<K> toAry() {
			List<K> ary = new ArrayList<K>();
			Node head = this.head.next;
			while (head != tail) {
				ary.add(head.key);
				head = head.next;
			}
			return ary;
		}
	}

	public void test() {
		CacheStrategy<Integer, Integer> cs = new CacheStrategyLRU<Integer, Integer>(
				3);
		Integer[][] data = new Integer[][] { //
		// {0:put, 1:get}, {result}
				{ 0, 1 }, { 1 }, // put 1 - add
				{ 0, 2 }, { 2, 1 },// put 2 - add
				{ 0, 3 }, { 3, 2, 1 },// put 3 - add
				{ 0, 2 }, { 2, 3, 1 },// put 2 - refresh, data changed
				{ 1, 1 }, { 1, 2, 3 },// get 1 - get
				{ 0, 3 }, { 3, 1, 2 },// put 3 - refresh, data changed
				{ 1, 4 }, { 3, 1, 2 },// get 4 - miss
				{ 0, 4 }, { 4, 3, 1 },// put 4 - 2 is gone
				{ 0, 0 }, { 0, 4, 3 },// put 0 - 1 is gone
		};

		for (int i = 0; i < data.length; i += 2) {
			int act = data[i][0];
			int d = data[i][1];
			if (act == 1) { // get
				cs.get(d);
			} else { // put
				cs.put(d, d);
			}
			// Assert.assertEquals(cs.toAry(), Lists.newArrayList(data[i + 1]));
		}
	}
}