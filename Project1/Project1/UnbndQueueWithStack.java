package Project1;

import ch03.stacks.LinkedStack;
import ch03.stacks.UnboundedStackInterface;
import ch05.queues.QueueUnderflowException;
import ch05.queues.UnboundedQueueInterface;

public class UnbndQueueWithStack<T> implements UnboundedQueueInterface<T>{
	public static final boolean IN = true;
	public static final boolean OUT = false;
	
	//proof of concept to prove that any unboundedStack could fill the job. but i choose to use LinkedStack
	private UnboundedStackInterface<T> in = new LinkedStack<>();
	private UnboundedStackInterface<T> out = new LinkedStack<>();
	
	@Override
	public T dequeue() throws QueueUnderflowException {
		//check if is empty, if it is, throw a Queue expection instead of a stack exception, we dont want confusion.
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		//flip stuff to this side
		while(!in.isEmpty()){
			out.push(in.top());
			in.pop();
		}
		
		//get top, pop, and return.
		T ret = out.top();
		out.pop();
		return ret;
	}

	@Override
	public boolean isEmpty() {
		//if either is false, than effectively this collection isEmpty is false
		return in.isEmpty()&&out.isEmpty();
	}

	@Override
	public void enqueue(T element) {
		//ensure side
		while(!out.isEmpty()){
			in.push(out.top());
			out.pop();
		}
		//add to stack
		in.push(element);
	}
}
/*
 * 1: enqueue an element <String>
2: dequeue <String result>
3: isEmpty() <boolean result>
4: new List()
5: exit
Input: 2
Error occured: null errorClass: ch05.queues.QueueUnderflowException
Input: 1
Enter a string for enqueue: tree
Input: 1
Enter a string for enqueue: wolf
Input: 1
Enter a string for enqueue: dragon
Input: 3
is Empty: false
Input: 2
dequeue result: tree
Input: 2
dequeue result: wolf
Input: 2
dequeue result: dragon
Input: 2
Error occured: null errorClass: ch05.queues.QueueUnderflowException
Input: 3
is Empty: true
Input: 1
Enter a string for enqueue: dragon
Input: 1
Enter a string for enqueue: wolf
Input: 1
Enter a string for enqueue: gg
Input: 2
dequeue result: dragon
Input: 3
is Empty: false
Input: 2
dequeue result: wolf
Input: 3
is Empty: false
Input: 1
Enter a string for enqueue: rr
Input: 3
is Empty: false
Input: 2
dequeue result: gg
Input: 2
dequeue result: rr
Input: 2
Error occured: null errorClass: ch05.queues.QueueUnderflowException
Input: 3
is Empty: true
Input: 5
*/
