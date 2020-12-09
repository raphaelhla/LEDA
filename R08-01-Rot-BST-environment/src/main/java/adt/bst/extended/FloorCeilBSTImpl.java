package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bt.BTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		
		for (Integer i : array) 
			this.insert(i);
		
		return floorAux(this.root, numero, null);
	}
	
	private Integer floorAux(BTNode<Integer> node, double numero, Integer floor) {

		Integer resp = floor;
		
		if (!node.isEmpty()) {
			
			if (numero == node.getData()) 
				resp = node.getData();
			
			else if (numero > node.getData())
				resp = floorAux(node.getRight(), numero, node.getData());
			
			else if (numero < node.getData()) 
				resp = floorAux(node.getLeft(), numero, floor);
			
		}
		
		return resp;
	}
	
	@Override
	public Integer ceil(Integer[] array, double numero) {
		
		for (Integer i : array) 
			this.insert(i);
		
		return ceilAux(this.root, numero, null);
	}
	
	private Integer ceilAux(BTNode<Integer> node, double numero, Integer ceil) {
		
		Integer resp = ceil;
		
		if (!node.isEmpty()) {
			
			if (numero == node.getData()) 
				resp = node.getData();
			
			else if (numero > node.getData()) 
				resp = ceilAux(node.getRight(), numero, ceil);
			
			else if (numero < node.getData()) 
				resp = ceilAux(node.getLeft(), numero, node.getData());
			
		}
		
		return resp;
	}

}
