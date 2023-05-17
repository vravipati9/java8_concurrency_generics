package generics.model;

public class Box<T> {
	
	private T t;          

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
    
    public void add(T t) {
    	
    }
    
    public <U extends Number> void inspect(U u) {
    	System.out.println("U: "+u.getClass().getName());
    	System.out.println("T: "+t.getClass().getName());
    }

    public static void boxTest(Box<Number> n) {
        System.out.println("* * * box test called * * *");
    }
    
	public static void main(String[] args) {
		Box<Integer> box = new Box<>();
		box.set(new Integer(5));
		Box<Number> box1 = new Box<>();
		box1.add(new Integer(1));
		box.inspect(1);

		boxTest(box1);
	}
}
