package com.hash.test;

public class LinearProbing {

	static int size = 10;
	static final int[] hashtable = new int[size];

	public static int hash(int key) {
		return key % size;
	}

	public static int probe(int hash) {

		int i = 0;
		int probe = hash;
		while (hashtable[probe] != 0) {
			probe = (hash + i++) % size;
		}

		return probe;
	}

	public static void insert(int key) {
		int hash = hash(key);

		int probe = probe(hash);

		hashtable[probe] = key;

	}

	public static void main(String[] args) {

		insert(12);
		insert(22);
		insert(32);
		insert(8);
		insert(18);
		insert(19);
	}
}
