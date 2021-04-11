
public class ObjectQueue<T>
{
	private ObjectBox<T> head = null;
	private ObjectBox<T> tail = null;
	private int size = 0;
	public void push(T obj) {
		ObjectBox<T> ob = new ObjectBox();
		ob.setObject(obj);
		if (head == null) {
			head = ob;
		} else {
			tail.setNext(ob);
		}
		tail = ob;
		size++;
	}
	public T pull() {
		if (size == 0) {
			return null;
		}
		T obj = head.getObject();
		head = head.getNext();
		if (head == null) {
			tail = null;
		}
		size--;
		return obj;
	}
	public T get(int index) {
		if(size == 0 || index >= size || index < 0) {
			return null;
		}
		ObjectBox<T> current = head;
		int pos = 0;
		while(pos < index) {
			current = current.getNext();
			pos++;
		}
		T obj = current.getObject();
		return obj;
	}
	public int size() {
		return size;
	}
	private class ObjectBox<T>
	{
		private T object;
		private ObjectBox<T> next;
		public T getObject() {
			return object;
		}
		public void setObject(T object) {
			this.object = object;
		}
		public ObjectBox<T> getNext() {
			return next;
		}
		public void setNext(ObjectBox<T> next) {
			this.next = next;
		}
	}
}
