/**
 * 
 */
package com.example.LinkedList;

/**
 * @author romiljain
 *
 */
public class TestLinkedList {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		list.add(new Integer(1));
		list.add(new Integer(6));
		list.add(new Integer(9));
		TestLinkedList test = new TestLinkedList();
		test.traverseList(list);
		
		list.remove(new Integer(1));
		test.traverseList(list);
		list.add(new Integer(5), 0);
		test.traverseList(list);
		list.add(new Integer(10), list.size());
		test.traverseList(list);
		list.remove(3);
		test.traverseList(list);
	}
	
	private void traverseList(DoubleLinkedList<Integer> list){
		System.out.println("size--->"+list.size());
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getElement());
		}
	}

}
