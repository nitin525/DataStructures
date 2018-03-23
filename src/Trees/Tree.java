package Trees;

public interface Tree<T> {
	
		public void traversal();
		public void insert(T insertData);
		public void delete(T deleteData);
		public T getMaxValue();
		public T getMinValues();

}
