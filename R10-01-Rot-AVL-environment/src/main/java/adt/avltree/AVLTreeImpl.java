package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {

		int balance = 0;

		if (node != null && !node.isEmpty()) {
			balance = height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
		}

		return balance;
	}

	// AUXILIARY
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
		} else {
			// LR
			Util.leftRotation((BSTNode<T>) node.getLeft());
			aux = Util.rightRotation(node);
		}

		if (aux.getParent() == null)
			this.root = aux;

	}

	private void rebalanceRight(BSTNode<T> node) {
		
		BSTNode<T> aux;

		if (calculateBalance((BSTNode<T>) node.getRight()) <= 0) {
			// RR
			aux = Util.leftRotation(node);
		} else {
			// RL
			Util.rightRotation((BSTNode<T>) node.getRight());
			aux = Util.leftRotation(node);
		}

		if (aux.getParent() == null)
			this.root = aux;

	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {

		BSTNode<T> parent = (BSTNode<T>) node.getParent();

		if (parent != null) {
			rebalance(parent);
			rebalanceUp(parent);
		}
	}

	@Override
	public void insert(T element) {

		if (element != null)
			insert(element, root);

	}

	private void insert(T element, BSTNode<T> node) {

		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
			node.setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());

		} else {

			if (element.compareTo(node.getData()) < 0)
				insert(element, (BSTNode<T>) node.getLeft());
			else if (element.compareTo(node.getData()) > 0)
				insert(element, (BSTNode<T>) node.getRight());

			rebalance(node);
		}
	}

	@Override
	public void remove(T element) {

		BSTNode<T> node = search(element);

		if (element != null && !node.isEmpty()) {

			if (node.isLeaf()) {

				node.setData(null);
				node.setLeft(null);
				node.setRight(null);

				rebalanceUp(node);

			} else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) {

				BSTNode<T> filhoValido;
				// Acha o filho do node que nao eh NIL
				if (!node.getRight().isEmpty())
					filhoValido = (BSTNode<T>) node.getRight();
				else
					filhoValido = (BSTNode<T>) node.getLeft();

				// Se o node for a raiz, entao a raiz passa a ser o filhoValido
				if (node.equals(root)) {

					this.root = filhoValido;
					this.root.setParent(null);

				} else { // Se o node nao for a raiz, entao o pai dele vai virar o pai do filhoValido
							// dele

					BSTNode<T> parentNode = (BSTNode<T>) node.getParent();
					filhoValido.setParent(parentNode);

					if (parentNode.getLeft().equals(node))
						parentNode.setLeft(filhoValido);
					else
						parentNode.setRight(filhoValido);

				}

				rebalanceUp(node);

			} else {
				T sucessor = sucessor(node.getData()).getData();
				remove(sucessor);
				node.setData(sucessor);
			}
		}
	}
}
