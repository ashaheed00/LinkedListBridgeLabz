package com.bl.dsa;

public class MyNode<K> {

	private K key;
	private MyNode<K> next;

	public MyNode(K key) {
		this.key = key;
		this.next = null;
	}

	public MyNode<K> getNext() {
		return next;
	}

	public void setNext(MyNode<K> mySecondNode) {
		this.next = mySecondNode;
	}
}
