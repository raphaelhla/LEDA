package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}

	protected int height(BSTNode<T> node) {

		int height = -1;

		if (!node.isEmpty()) {

			int left = height((BSTNode<T>) node.getLeft());
			int right = height((BSTNode<T>) node.getRight());

			height = 1 + Math.max(left, right);
		}

		return height;
	}

	@Override
	public BSTNode<T> search(T element) {

		BSTNode<T> resp = new BSTNode<T>();

		if (element != null)
			resp = search(element, root);

		return resp;

	}

	private BSTNode<T> search(T element, BSTNode<T> node) {

		BSTNode<T> resp = node;

		if (!resp.isEmpty() && !resp.getData().equals(element)) {

			if (element.compareTo(resp.getData()) < 0)
				resp = search(element, (BSTNode<T>) resp.getLeft());
			else
				resp = search(element, (BSTNode<T>) resp.getRight());

		}

		return resp;
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

		}
	}

	@Override
	public BSTNode<T> maximum() {

		BSTNode<T> resp = null;

		if (!isEmpty())
			resp = maximum(root);

		return resp;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {

		BSTNode<T> resp = node;

		if (!node.getRight().isEmpty())
			resp = maximum((BSTNode<T>) node.getRight());

		return resp;
	}

	@Override
	public BSTNode<T> minimum() {

		BSTNode<T> resp = null;

		if (!isEmpty())
			resp = minimum(root);

		return resp;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {

		BSTNode<T> resp = node;

		if (!node.getLeft().isEmpty())
			resp = minimum((BSTNode<T>) node.getLeft());

		return resp;
	}

	@Override
	public BSTNode<T> sucessor(T element) {

		BSTNode<T> resp = null;
		BSTNode<T> aux = search(element);

		if (element != null && !isEmpty() && !aux.isEmpty()) {

			if (!aux.getRight().isEmpty())
				resp = minimum((BSTNode<T>) aux.getRight());
			else
				resp = sucessor(element, aux);
		}

		return resp;
	}

	private BSTNode<T> sucessor(T element, BSTNode<T> node) {

		BSTNode<T> resp = (BSTNode<T>) node.getParent();

		if (resp != null && resp.getRight().equals(node))
			resp = sucessor(element, resp);

		return resp;
	}

	@Override
	public BSTNode<T> predecessor(T element) {

		BSTNode<T> resp = null;
		BSTNode<T> aux = search(element);

		if (element != null && !isEmpty() && !aux.isEmpty()) {

			if (!aux.getLeft().isEmpty())
				resp = maximum((BSTNode<T>) aux.getLeft());
			else
				resp = predecessor(element, aux);
		}

		return resp;
	}

	private BSTNode<T> predecessor(T element, BSTNode<T> node) {
		BSTNode<T> resp = (BSTNode<T>) node.getParent();

		if (resp != null && resp.getLeft().equals(node))
			resp = predecessor(element, resp);

		return resp;
	}

	@Override
	public void remove(T element) {

		BSTNode<T> node = search(element);

		if (element != null && !node.isEmpty()) {

			if (node.isLeaf()) {

				node.setData(null);
				node.setLeft(null);
				node.setRight(null);

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

			} else {
				T sucessor = sucessor(node.getData()).getData();
				remove(sucessor);
				node.setData(sucessor);
			}
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<T>();
		preOrder(list, root);

		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void preOrder(ArrayList<T> array, BSTNode<T> node) {

		if (!node.isEmpty()) {

			array.add(node.getData());
			preOrder(array, (BSTNode<T>) node.getLeft());
			preOrder(array, (BSTNode<T>) node.getRight());

		}
	}

	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<T>();
		order(list, root);

		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void order(ArrayList<T> array, BSTNode<T> node) {

		if (!node.isEmpty()) {

			order(array, (BSTNode<T>) node.getLeft());
			array.add(node.getData());
			order(array, (BSTNode<T>) node.getRight());

		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<T>();

		postOrder(list, root);

		return (T[]) list.toArray(new Comparable[list.size()]);
	}

	private void postOrder(ArrayList<T> array, BSTNode<T> node) {

		if (!node.isEmpty()) {
			postOrder(array, (BSTNode<T>) node.getLeft());
			postOrder(array, (BSTNode<T>) node.getRight());
			array.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand how
	 * it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}