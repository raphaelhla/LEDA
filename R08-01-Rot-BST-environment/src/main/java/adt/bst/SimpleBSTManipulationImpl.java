package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equalsAux(tree1.getRoot(), tree2.getRoot());
	}

	private boolean equalsAux(BTNode<T> node1, BTNode<T> node2) {
		
		boolean equalLeft = false;
		boolean equalRight = false;
		
		if (node1.isEmpty() && node2.isEmpty()) {
			
			equalLeft = true;
			equalRight = true;
			
		} else if (!node1.isEmpty() && !node2.isEmpty() && node1.equals(node2)) {
			
			equalLeft = equalsAux(node1.getLeft(), node2.getLeft());
			equalRight = equalsAux(node1.getRight(), node2.getRight());
				
		}
		
		return equalLeft && equalRight;
	}
	
//  	@Override
//  	public boolean equals(BST<T> tree1, BST<T> tree2) {
//  		return equalsAuxiliar(tree1.getRoot(), tree2.getRoot());
//  
//  	}
//  
//  	private boolean equalsAuxiliar(BTNode<T> node1, BTNode<T> node2) {
//  		if(node1.isEmpty() && node2.isEmpty()){
//  			return true;
//  		}
//  		if(!node1.isEmpty() && !node2.isEmpty()){
//  			if(node1.getData().equals(node2.getData())){
//  				if(equalsAuxiliar(node1.getLeft(), node2.getLeft())){
//  					if(equalsAuxiliar(node1.getRight(), node2.getRight())){
//  						return true;
//  					}
//  				}
//  			}
//  		}
//  		return false;
//  	}
	
	
	
	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilarAux(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilarAux(BTNode<T> node1, BTNode<T> node2) {
		
		boolean similarLeft = false;
		boolean similarRight = false;
		
		if (node1.isEmpty() && node2.isEmpty()) {
			
			similarLeft = true;
			similarRight = true;
			
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			
			similarLeft = isSimilarAux(node1.getLeft(), node2.getLeft());
			similarRight = isSimilarAux(node1.getRight(), node2.getRight());
				
		}
		
		return similarLeft && similarRight;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		
		T resp = null;
		
		if (k >= 1 && k <= tree.size()) {
			
			BSTNode<T> min = tree.minimum();
			resp = orderStatistic(tree, k, min);
			
		}
		
		return resp;
	}

	private T orderStatistic(BST<T> tree, int k, BTNode<T> node) {
		T resp = node.getData();
		
		if (k > 1) {
			resp = orderStatistic(tree, k - 1, tree.sucessor(node.getData()));
		}
		
		return resp;
	}

}
