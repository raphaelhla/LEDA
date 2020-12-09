package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {

	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}

	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		return isBST(bst.root);
	}

	private boolean isBST(BSTNode<T> node) {

		boolean resp = true;

		if (!node.isEmpty()) {

			boolean leftValid = verificaSubArvoreEsquerda((BSTNode<T>) node.getLeft(), node.getData());
			boolean rightValid = verificaSubArvoreDireita((BSTNode<T>) node.getRight(), node.getData());

			boolean isBSTLeft = isBST((BSTNode<T>) node.getLeft());
			boolean isBSTRight = isBST((BSTNode<T>) node.getRight());

			resp = leftValid && rightValid && isBSTLeft && isBSTRight;
		}

		return resp;
	}

	private boolean verificaSubArvoreEsquerda(BSTNode<T> node, T value) {

		boolean resp = true;

		if (!node.isEmpty()) {

			if (node.getData().compareTo(value) < 0) {
				
				boolean left = verificaSubArvoreEsquerda((BSTNode<T>) node.getLeft(), value);
				boolean right = verificaSubArvoreEsquerda((BSTNode<T>) node.getRight(), value);
				resp = left && right;

			}else {
				
				resp = false;
				
			}
		}

		return resp;
	}

	private boolean verificaSubArvoreDireita(BSTNode<T> node, T value) {

		boolean resp = true;

		if (!node.isEmpty()) {

			if (node.getData().compareTo(value) > 0) {

				boolean left = verificaSubArvoreDireita((BSTNode<T>) node.getLeft(), value);
				boolean right = verificaSubArvoreDireita((BSTNode<T>) node.getRight(), value);
				resp = left && right;

			} else {

				resp = false;

			}
		}

		return resp;
	}
}
