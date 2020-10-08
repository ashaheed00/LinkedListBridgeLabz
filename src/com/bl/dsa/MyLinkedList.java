package com.bl.dsa;

public class MyLinkedList<K> {
	INode<K> head;
	INode<K> tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

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

	public void insert(INode<K> myNode, INode<K> newNode) {
		INode<K> tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	public INode<K> pop() {
		INode<K> tempNode = this.head;
		this.head = tempNode.getNext();
		return tempNode;
	}

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

	public INode<K> search(K key) {
		INode<K> tempNode = head;
		while (tempNode != null) {
			if (tempNode.getKey() == key)
				return tempNode;
			tempNode = tempNode.getNext();
		}
		return null;
	}

	// Overloaded insert method to insert element using keys
	public void insert(K prevKey, K newKey) {
		INode<K> prevNode = search(prevKey);
		MyNode<K> newNode = new MyNode<>(newKey);
		insert(prevNode, newNode);
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
