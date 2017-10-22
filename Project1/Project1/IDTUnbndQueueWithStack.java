package Project1;

import java.util.Scanner;

public class IDTUnbndQueueWithStack {
	public static void main(String...strings){
		String element;
		Scanner scan = new Scanner(System.in);
		UnbndQueueWithStack<String> queue = load(scan);
		
		System.out.println("1: enqueue an element <String>");
		System.out.println("2: dequeue <String result>");
		System.out.println("3: isEmpty() <boolean result>");
		System.out.println("4: new List()");
		System.out.println("5: exit");
		
		while(true){
			
			System.out.print("Input: ");
			
			int value = getInteger(scan,1,8);
			
			switch(value){
				case 1: //enqueue
					System.out.print("Enter a string for enqueue: ");
					element = scan.nextLine();
					queue.enqueue(element);
					break;
				case 2: //dequeue
					try{
						System.out.println("dequeue result: "+queue.dequeue());
					}
					catch(Exception ex){
						System.out.println("Error occured: "+ex.getMessage() + " errorClass: "+ex.getClass().getName());
					}
					break;
				case 3:
					System.out.println("is Empty: "+queue.isEmpty());
					break;
				case 4: //newList
					queue = load(scan);
					break;
				case 5://end case
					return;
			}
		}
		
		
		
		
	}
	private static UnbndQueueWithStack<String> load(Scanner scan){
		return new UnbndQueueWithStack<String>();
	}
	private static int getInteger(Scanner scan, int min, int max){
		while(true){
			String obj = scan.nextLine();
			try{
				int o = Integer.parseInt(obj);
				if(min <= o && o <= max){
					return o;
				}
				else{
					System.out.print("Invalid input,"+(min > 0?"value too low":"value too high: "));
				}
			}
			catch(Exception ex){
				System.out.print("Invalid input, not an Integer: ");
			}
		}
	}
}
/*	 <SAMPLE RUN>
		1: enqueue an element <String>
		2: dequeue <String result>
		3: isEmpty() <boolean result>
		4: new List()
		5: exit
		Input: 3
		is Empty: true
		Input: 1
		Enter a string for enqueue: 1
		Input: 1
		Enter a string for enqueue: 2
		Input: 1
		Enter a string for enqueue: 3
		Input: 2
		dequeue result: 1
		Input: 2
		dequeue result: 2
		Input: 1
		Enter a string for enqueue: 4
		Input: 1
		Enter a string for enqueue: 5
		Input: 2
		dequeue result: 3
		Input: 3
		is Empty: false
		Input: 2
		dequeue result: 4
		Input: 3
		is Empty: false
		Input: 2
		dequeue result: 5
		Input: 2
		Error occured: null errorClass: ch05.queues.QueueUnderflowException
		Input: 5
*/