package application;

public class Flights implements Comparable<Flights> {
	
	
	private int flight_no;
	private String airline;
	private String source;
	private String destination;
	private int capacity;
	LinkedList<Passengers> passenger_list = new LinkedList<Passengers>();

	public Flights(int flight_no, String airline, String source, String destination, int capacity,
			LinkedList<Passengers> passenger_list) {
		this.flight_no = flight_no;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.capacity = capacity;
		this.passenger_list = new LinkedList<Passengers>();
	}

	public Flights() {
	}

	public void addPassenger(int flight_no, String ticket_no, String name, String passport, String nationality,
			String birthdate) {
		if (passenger_list.length() < capacity) {
			passenger_list.sortedInsert(new Passengers(flight_no, ticket_no, name, passport, nationality, birthdate));
		} // Checking whether it is allowed to add a passenger by comparing the length of
			// the passenger list to the capacity of the flight
		else {
			System.out.println("Unable to Add Passenger because the Capacity has been reached...");
		}//yes this happens
	}

	public void removePassenger(String ticket_no) {
		passenger_list.deletePassenger(ticket_no);//go to linkedlist for the logic
	}

	public String printPassenger(String ticket_no) {
		return passenger_list.printPassenger(ticket_no);
	}//search for the passenger and print their info

	public boolean checkPassenger(String ticket) {
		return passenger_list.searchPassenger(ticket);
	}//check linked list

	public String getAllPassengers() {
		return passenger_list.traverse();
	}//traversing the passenger list

	public int getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return flight_no + " " + airline + " " + source + " " + destination + " " + capacity;
	}

	@Override
	public int compareTo(Flights o) {// compare method to sort based on flight number
		if (this.flight_no > o.flight_no) {
			return 1;
		} else if (this.flight_no < o.flight_no) {
			return -1;
		} else {
			return 0;
		}
	}

}