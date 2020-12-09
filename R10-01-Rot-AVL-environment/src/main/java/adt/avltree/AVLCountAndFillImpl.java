package adt.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}
	
	@Override
	public void fillWithoutRebalance(T[] array) {
		
		if (array != null && array.length > 0) {
			
			List<T> arrayList = new ArrayList<>();
			
			for (T element : preOrder())
				arrayList.add(element);
			
			for (T element : array)
				if (!arrayList.contains(element))
					arrayList.add(element);

			this.root = new BSTNode<>();
			Collections.sort(arrayList);
			
			Map<Integer, List<T>> mapa = new HashMap<>();
			auxFillWithoutRebalance(mapa, 0, 0, arrayList.size() - 1, arrayList);
			
			int altura = 0;
			while (mapa.containsKey(altura)) {
				
				for (T element : mapa.get(altura)) 
					insert(element);
				
				altura += 1;
			}
		}
	}

	private void auxFillWithoutRebalance(Map<Integer, List<T>> mapa, int altura,  int leftIndex, int rightIndex, List<T> array) {
		
		if (leftIndex <= rightIndex) {
			
			int middle = (leftIndex + rightIndex) / 2;
			T element = array.get(middle);
			
			if (!mapa.containsKey(altura))
				mapa.put(altura, new ArrayList<T>());
			
			mapa.get(altura).add(element);
			
			auxFillWithoutRebalance(mapa, altura + 1, leftIndex, middle - 1, array);
			auxFillWithoutRebalance(mapa, altura + 1, middle + 1, rightIndex, array);
		}
	}

	@Override
	protected void rebalance(BSTNode<T> node) {

		int balance = calculateBalance(node);

		if (balance > 1)
			rebalanceLeft(node);
		else if (balance < -1)
			rebalanceRight(node);

	}

	private void rebalanceLeft(BSTNode<T> node) {

		BSTNode<T> aux;

		if (calculateBalance((BSTNode<T>) node.getLeft()) >= 0) {
			// LL
			aux = Util.rightRotation(node);
			LLcounter++;
		} else {
			// LR
			Util.leftRotation((BSTNode<T>) node.getLeft());
			aux = Util.rightRotation(node);
			LRcounter++;
		}

		if (aux.getParent() == null)
			this.root = aux;

	}

	private void rebalanceRight(BSTNode<T> node) {

		BSTNode<T> aux;

		if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
			// RR
			aux = Util.leftRotation(node);
			RRcounter++;
		} else {
			// RL
			Util.rightRotation((BSTNode<T>) node.getRight());
			aux = Util.leftRotation(node);
			RLcounter++;
		}

		if (aux.getParent() == null)
			this.root = aux;

	}
}
