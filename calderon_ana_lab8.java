import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class calderon_ana_lab8 {
	public static void main(String[] args) throws FileNotFoundException{

		// Change the path if needed
		String filepath = "/Users/paulinacalderon/Desktop/CS2/boxfile.txt";
		
		//Node head = constructLLFromArray(filepath);
		Node head = constructLLFromFile(filepath);

		// print all the boxes length, width, height and volume
		System.out.println("Full linked list: ");
		printLL(head);
		
		// remove 3rd node
		System.out.println("Without 3rd node: ");
		remove(head, 2);
		printLL(head);
		
		// remove head
		System.out.println("Without head: ");
		remove(head, 0);
		printLL(head);
		
		// remove middle
		System.out.println("Without middle node: ");
		remove(head, 2);
		printLL(head);
		
		// remove last node
		System.out.println("Without last node: ");
		remove(head, 1);
		printLL(head);
		
		//gives original head value
		head = constructLLFromFile(filepath);

		// Get the box with the min volume
		Box minVol = minLL(head);
		System.out.println("Box with minimum volume: ");
		System.out.println("length: "+ minVol.length);
		System.out.println("width: "+ minVol.width);
		System.out.println("height: "+ minVol.height);
		System.out.println("volume: "+ minVol.getVolume());
		
		
		// Get the box with the max volume
		Box maxVol = maxLL(head);
		System.out.println("\nBox with maximum volume: ");
		System.out.println("length: "+ maxVol.length);
		System.out.println("width: "+ maxVol.width);
		System.out.println("height: "+ maxVol.height);
		System.out.println("volume: "+ maxVol.getVolume());
		
		// Get summation of box volumes
		double sumVol = sumLL(head);
		System.out.println("\nSum of volume of all the boxes: "+ sumVol + "\n");
		
		// Print all the boxes 
		System.out.println("All boxes: ");
		printLL(head);
		
		Box insertBox = new Box(111.1,222.2,333.3);
		head = insert(head, insertBox, 2);
		Box insertBox2 = new Box(1.1,2.2,3.3);
		head = insert(head, insertBox2, 0);
		Box insertBox3 = new Box(5.5,6.6,7.7);
		head = insert(head, insertBox3, 100);

		//prints out new box values
		System.out.println("This is new insert box 1's length: " + insertBox.length);
		System.out.println("This is new insert box 1's width: " + insertBox.width);
		System.out.println("This is new insert box 1's height: " + insertBox.height);
		System.out.println("This is new insert box 1's volume: " + insertBox.getVolume());

		System.out.println("This is new insert box 2's length: " + insertBox2.length);
		System.out.println("This is new insert box 2's width: " + insertBox2.width);
		System.out.println("This is new insert box 2's height: " + insertBox2.height);
		System.out.println("This is new insert box 2's volume: " + insertBox2.getVolume());

		System.out.println("This is new insert box 3's length: " + insertBox3.length);
		System.out.println("This is new insert box 3's width: " + insertBox3.width);
		System.out.println("This is new insert box 3's height: " + insertBox3.height);
		System.out.println("This is new insert box 3's volume: " + insertBox3.getVolume());

	}


	static Node remove(Node head, int pos){
		// Write the code to remove any node at the position
		Node temp = head;

		if (pos<0 || temp==null)
			return temp;

		if (pos==0){
			return temp.next;
		}

		for(int i=1; i<pos && temp.next!=null; i++){
			temp = temp.next;
		}

		if(temp.next!=null){
			temp.next = temp.next.next;
		}

		return temp;    
	}

	static Node insert(Node head, Box box, int pos){
		// Write the code to insert any node at the position
		if(head==null){
			if(pos==0){
				return new Node(box);
			}
			else{
				return head;
			}
		}	
		if(pos==0){
			Node temp = new Node(box);	
			temp.next = head;
			return temp;
		}

		Node temp = head;
		Node prev = head;
		for(int i=1; temp!=null; i++){
			if(i==pos){
				Node toInsert = new Node(box);
				prev.next = toInsert;
				toInsert.next = temp;
				return head;
			}
			prev = temp;
			temp = temp.next;
		}

		return head;    
		
	}


	static Box minLL(Node head){
		// Return the Box with minimum volume

		Node temp = head;
		
		while(head!=null){
			if(head.box.getVolume()<temp.box.getVolume()){
				temp = head;
			}
			
			head=head.next;
		}

		return temp.box;
	}

	static Box maxLL(Node head){
		// Return the Box with maximum volume

        Node temp = head;
		
		while(head!=null){
			if(head.box.getVolume()>temp.box.getVolume()){
				temp = head;
			}
			
			head=head.next;
		}

		return temp.box;
	
	}

	static double sumLL(Node head){
		// Return sum of all the volumes
		double sum = 0.0;

		while(head!=null){
			sum = sum + head.box.getVolume();
			head = head.next;
		}

		return sum;

	}

	static void printLL(Node head){    
		// Print the length, width, height and volume of all the boxes
		while(head!=null){
			System.out.println("Length of box: " + head.box.length);
			System.out.println("Width of box: " + head.box.width);
			System.out.println("Height of box: " + head.box.height);
			System.out.println("Volume of box: " + head.box.getVolume());
			System.out.println();
			head = head.next;
		}

		System.out.println();
	}

	static Node constructLLFromArray(String filepath) throws FileNotFoundException{
		
		File file = new File(filepath);	
		Scanner scnr = new Scanner(file);
		int i = 0;
		String n_str = scnr.nextLine();									
		int n = Integer.parseInt(n_str);	
		Box boxes[] = new Box[n];											
		
		// generating array of boxes from the file
		while(i<n){					
			String line = scnr.nextLine();								
			String items[] = line.split(" ");
			double length=Double.parseDouble(items[0]);	
			double width=Double.parseDouble(items[1]);
			double height=Double.parseDouble(items[2]);
			
			Box box = new Box(length, width, height);
			boxes[i]=box;
			i++;

		}
		
		
		// Creating linkedlist from boxes array
		Node head = null;
		if (boxes==null || boxes.length==0)
			
			return head;

		head = new Node(boxes[0]);

		Node temp = head;

		for (i=1; i<boxes.length; i++){
			temp.next = new Node(boxes[i]);
			temp = temp.next;
		}
		
		System.out.println(head.box.length+" "+ head.box.width+" "+ head.box.height);
		return head;


	}

	static Node constructLLFromFile(String filepath) throws FileNotFoundException{
		
		File file = new File(filepath);	
		Scanner scnr = new Scanner(file);
		
		String n_str = scnr.nextLine();									
		int n = Integer.parseInt(n_str);												
		
		// Creating linkedlist from boxfile
		Node head = null;
		Node tmp = null;
		
		int i = 0;
		String line = scnr.nextLine();								
		String items[] = line.split(" ");
		double length=Double.parseDouble(items[0]);	
		double width=Double.parseDouble(items[1]);
		double height=Double.parseDouble(items[2]);
		Box box = new Box(length, width, height);
		
		head = new Node(box);
		tmp = head;
		i=1;
		while(i<n){					
			 line = scnr.nextLine();								
			 String items2[] = line.split(" ");
			 length=Double.parseDouble(items2[0]);	
			 width=Double.parseDouble(items2[1]);
			 height=Double.parseDouble(items2[2]);
			
			box = new Box(length, width, height);
			
			tmp.next = new Node(box);
			
			tmp = tmp.next;
			
			i++;
		}
		
		//System.out.println(head.next.box.length+" "+ head.next.box.width+" "+ head.next.box.height);
		return head;


	}
}