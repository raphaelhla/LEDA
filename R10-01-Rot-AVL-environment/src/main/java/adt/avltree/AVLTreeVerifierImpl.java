package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {

		 return isBST() && isAVLTree(avlTree.getRoot());
	}

	private boolean isAVLTree(BSTNode<T> node) {
		
		boolean left = true;
		boolean right = true;
		
		if (!node.isEmpty()) {
			
			int balance = this.avlTree.calculateBalance(node);
			
			if (balance < - 1 || balance > 1) {
				
				left = false;
				right = false;
				
			} else {
				
				left = isAVLTree((BSTNode<T>) node.getLeft());
				right = isAVLTree((BSTNode<T>) node.getRight());
			}
		}
		
		return left && right;
	}
}
