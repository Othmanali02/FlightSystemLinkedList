package application;

public class LinkedList<T extends Comparable<T>> {

	protected Node<T> head;

	public LinkedList() {

	}

	public String printPassenger(String ticket_no) {
		if (head == null) {
			System.out.println("Can't get Passenger... List is empty");
		}
		Node<T> curr = head;

		int start = curr.data.toString().indexOf(" ");
		int finish = curr.data.toString().indexOf(" ", start + 1);

		for (; (curr != null) && (Integer.parseInt(
				curr.data.toString().substring(start + 1, finish)) < (Integer.parseInt(ticket_no))); curr = curr.next)
			;// loop that iterates through the list and compares the substring(4, 12)
				// which is the current data ticket number to the input ticket number until the
				// data is matched

		if (curr == null) {
			System.out.println("Nothing to Delete");
		}

		if (curr.data.toString().substring(start + 1, finish).equals(ticket_no)) {
			return curr.data.toString();// if the ticket number matches return true, Reservation checked
		} else {
			return "Not Found";
		}
	}

	public boolean searchPassenger(String ticket_no) {

		if (head == null) {
			System.out.println("Can't get Passenger... List is empty");
			return false;
		}
		Node<T> curr = head;

		int start = curr.data.toString().indexOf(" ");
		int finish = curr.data.toString().indexOf(" ", start + 1);// starts looking for the space after the first space
																	// if that makes sense

		System.out.println(finish);
		for (; (curr != null) && (Integer.parseInt(
				curr.data.toString().substring(start + 1, finish)) < (Integer.parseInt(ticket_no))); curr = curr.next)
			;// loop that iterates through the list and compares the substring of the first
				// space(ticket number)
				// which is the current data ticket number to the input ticket number until the
				// data is matched

		if (curr == null) {
			System.out.println("Nothing to Delete");
		}

		if (curr.data.toString().substring(start + 1, finish).equals(ticket_no)) {
			return true;// if the ticket number matches return true, Reservation checked
		} else {
			return false;
		}
	}

	public int length() {

		int length = 0;
		Node<T> curr = head;

		while (curr != null) {
			length++;
			curr = curr.next;
		}

		return length;
	}

	public Flights getFlight(int flight_no) {

		if (head == null) {
			System.out.println("Can't Access Flight... List is empty");
		}

		Node<T> curr = head;

		for (; (curr != null) && (Integer.parseInt(curr.data.toString().substring(0, 3)) < flight_no); curr = curr.next)
			;
		if (Integer.parseInt(curr.data.toString().substring(0, 3)) == (flight_no)) {
			return (Flights) curr.data;
		} else {
			return null;
		}
	}

	public void deletePassenger(String ticket_no) {

		if (head == null) {
			System.out.println("Can't get Passenger... List is empty");
		}
		Node<T> curr = head, prev = null;

		int start = curr.data.toString().indexOf(" ");
		int finish = curr.data.toString().indexOf(" ", start + 1);

		for (; (curr != null) && (Integer.parseInt(curr.data.toString().substring(start + 1, finish)) < (Integer
				.parseInt(ticket_no))); prev = curr, curr = curr.next)
			;

		if (curr == null) {
			System.out.println("Nothing to Delete");
		}

		if (curr.data.toString().substring(start + 1, finish).equals(ticket_no)) {
			if (curr == head) {
				head = head.next;// i should draw this to make it look more understandable
			} else {
				prev.next = curr.next;
			}
		} else {
			System.out.println("Element Not Found");
		}
	}

	public void deleteFlight(int flight_no) {

		if (head == null) {
			System.out.println("Can't get Flight... List is empty");
		}
		Node<T> curr = head, prev = null;

		for (; (curr != null)
				&& (Integer.parseInt(curr.data.toString().substring(0, 3)) < flight_no); prev = curr, curr = curr.next)
			;

		if (curr == null) {
			System.out.println("Nothing to Delete");
		}

		if (Integer.parseInt(curr.data.toString().substring(0, 3)) == flight_no) {
			if (curr == head) {
				head = head.next;
			} else {
				prev.next = curr.next;
			}
		} else {
			System.out.println("Element Not Found");
		}
	}

	public String traverse() {
		Node<T> temp = head;
		String res = " HEAD ->\n ";

		while (temp != null) {
			res += temp.getData() + " ->\n ";
			temp = temp.getNext();
		}

		return res + "-> NULL";
	}

	public void sortedInsert(T value) {
		Node<T> new_node = new Node<T>(value);
		Node<T> current;

		if (head == null || head.data.compareTo(new_node.data) > 0) {// IF THE NODE WE'RE ADDING IS IN
															//AN EMPTY LINKED
																		// LIST
			new_node.next = head;
			head = new_node;
		} else {
			current = head;// ITERATE THROUGH LINKED LIST TO INSERT AT THE RIGHT SPOT
			while (current.next != null && new_node.data.compareTo(current.next.data) > 0) {
				current = current.next;
			}

			new_node.next = current.next;
			current.next = new_node;
		}
	}

}
