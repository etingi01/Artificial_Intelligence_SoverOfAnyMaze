import java.util.Stack;

public class Queue<AnyType> {
	private Stack<AnyType> A;
	private Stack<AnyType> B;

	public Queue(){
		A=new Stack<AnyType>();
		B=new Stack<AnyType>();
	}
	
	public int size(){
		return (A.size()+B.size());
	}
	
	public boolean isEmpty(){
		if (size()==0)
			return true;
		return false;
	}
	
	public void enqueue (AnyType value){
		A.push(value);
	}
	
	public AnyType getFront() throws java.util.NoSuchElementException {
		if (B.isEmpty())
			while (!A.isEmpty())
				B.push(A.pop());
		if (B.isEmpty())
			return null;
		return B.firstElement();
		
	}
	
	public AnyType dequeue() throws java.util.NoSuchElementException{
		if (B.isEmpty()) {
			while (!A.isEmpty()) {
				B.push(A.pop());
		     }
		 }
		if (B.isEmpty())
		 return null;
		return B.pop();
	}

	
	public void clear(){
		while (!A.isEmpty())
			A.pop();
		while (!B.isEmpty())
			B.pop();
	}
}

