package com.bl.dsa;

public class MyLinkedList<K extends Comparable<K>> {
	INode<K> head;
	INode<K> tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	/* push, unordered */
	public void add(INode<K> myNode) {
		if (this.tail == null)
			this.tail = myNode;
		if (this.head == null) {
			this.head = myNode;
		} else {
			INode<K> tempNode = this.head;
			this.head = myNode;
			this.head.setNext(tempNode);
		}
	}

	/* add at the tail */
	public void append(INode<K> myNode) {
		if (this.head == null)
			this.head = myNode;
		if (this.tail == null) {
			this.tail = myNode;
		} else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}

	/* insert node after a specified node */
	public void insert(INode<K> myNode, INode<K> newNode) {
		INode<K> tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	/* pop, removes from top */
	public INode<K> pop() {
		INode<K> tempNode = this.head;
		this.head = tempNode.getNext();
		return tempNode;
	}

	/* removes from tail */
	public INode<K> popLast() {
		INode<K> prevNode = head;
		while (!prevNode.getNext().equals(tail)) {
			prevNode = prevNode.getNext();
		}
		INode<K> tempNode = tail;
		prevNode.setNext(null);
		tail = prevNode;
		return tempNode;
	}

	/* search by specified key */
	public INode<K> search(K key) {
		INode<K> tempNode = head;
		while (tempNode != null) {
			if (tempNode.getKey() == key)
				return tempNode;
			tempNode = tempNode.getNext();
		}
		return null;
	}

	/* insert node using key, after a specified key */
	public void insert(K prevKey, K newKey) {
		INode<K> prevNode = search(prevKey);
		INode<K> newNode = new MyNode<K>(newKey);
		insert(prevNode, newNode);
	}

	/* deletes a specified node using key */
	public void delete(K key) {
		INode<K> nodeToDelete = search(key);
		INode<K> nextNode = nodeToDelete.getNext();
		INode<K> prevNode = head;
		while (!prevNode.getNext().equals(nodeToDelete)) {
			prevNode = prevNode.getNext();
		}
		prevNode.setNext(nextNode);
	}

	public int size() {
		int size = 0;
		INode<K> tempNode = head;
		while (!tempNode.equals(tail)) {
			tempNode = tempNode.getNext();
			size++;
		}
		return size + 1;
	}

	/*
	 * ascending order sorting will occur
	 * while adding the element to the LinkedList
	 */
	public void addSorted(INode<K> newNode) {
		INode<K> current;
		INode<K> prevNode;

		if (this.head == null) {
			this.head = newNode;
			tail = head;
			return;
		}
		if (this.tail == null) {
			this.tail = newNode;
			head = tail;
			return;
		}
		if (head == null || head.getKey().compareTo(newNode.getKey()) > 0) {
			newNode.setNext(head);
			head = newNode;
			return;
		}
		if (tail != null && tail.getKey().compareTo(newNode.getKey()) < 0) {
			// append(newNode);
			tail.setNext(newNode);
			tail = newNode;
			return;
		}
		prevNode = head;
		current = head;
		while (current.getNext() != null && current.getKey().compareTo(newNode.getKey()) < 0) {
			prevNode = current;
			current = current.getNext();
		}
		newNode.setNext(prevNode.getNext());
		prevNode.setNext(newNode);
	}

	public void print() {
		StringBuffer myNodes = new StringBuffer();
		INode<K> tempNode = head;
		while (tempNode.getNext() != null) {
			myNodes.append(tempNode.getKey());
			if (tempNode != tail)
				myNodes.append("->");
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println(myNodes);
	}

}
