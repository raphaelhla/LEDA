package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size, HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {

		if (element != null && indexOf(element) == -1) {

			int i = 0;

			while (i < capacity()) {

				int hash = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, i);

				if (this.table[hash] == null || this.table[hash].equals(this.deletedElement)) {

					this.table[hash] = element;
					this.elements += 1;
					break;

				}
				i += 1;
				this.COLLISIONS += 1;
			}
			if (i == capacity()) 
				throw new HashtableOverflowException();				
		}
	}

	@Override
	public void remove(T element) {

		if (element != null && indexOf(element) != -1) {

			int ind = indexOf(element);
			this.table[ind] = this.deletedElement;
			this.elements -= 1;

		}
	}

	@Override
	public T search(T element) {
		T resp = null;

		if (element != null && indexOf(element) != -1) {
			resp = element;
		}

		return resp;
	}

	@Override
	public int indexOf(T element) {

		int ind = -1;

		if (element != null && !isEmpty()) {

			int i = 0;

			while (i < capacity()) {

				int hash = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, i++);

				if (this.table[hash] == null)
					break;
				if (this.table[hash].equals(element)) {
					ind = hash;
					break;
				}
			}
		}
		return ind;
	}
}
