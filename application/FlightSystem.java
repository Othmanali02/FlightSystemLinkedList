package application;

public class FlightSystem implements FlightSystemInterface {

	protected LinkedList<Flights> flight_list = new LinkedList<Flights>();

	public FlightSystem() {
		this.flight_list = new LinkedList<Flights>();
	}

	@Override
	public void deleteFlight(int flight_no) {
		flight_list.deleteFlight(flight_no);
	}// used to update the value of the flight

	@Override
	public void addFlight(int flight_no, String Airline, String source, String destination, int Capacity) {
		flight_list.sortedInsert(new Flights(flight_no, Airline, source, destination, Capacity, null));
	}// this methods adds the nodes of the flights to the flight list

	@Override
	public void addPassengertoFlight(int flight_no, String ticket_no, String name, String passport, String nationality,
			String birthdate) {
		flight_list.getFlight(flight_no).addPassenger(flight_no, ticket_no, name, passport, nationality, birthdate);
	}// pretty self explanatory, the getFlight() method returns the node so that the
		// addPassenger() methods can be accessed

	@Override
	public String getAllFlightInfo(int flight_no) {
		return flight_list.getFlight(flight_no).toString();
	}// getFlight() returns the Node in the type (Flights) and toString() to print

	@Override
	public String getAllFlightsInfo() {
		return flight_list.traverse();// print the entire list of flights
	}

	@Override
	public String getAllPassengerInfo(int flight_no) {
		return flight_list.getFlight(flight_no).getAllPassengers();
	}// same stuff the getFlight() methods gets the Node so it can access
		// getAllPassengers() and print the entire passenger list

	@Override
	public void cancelReserve(int flight_no, String ticket_no) {
		flight_list.getFlight(flight_no).removePassenger(ticket_no);
	}// explained more in the Flights class since removePassenger() is found there to
		// deletes the passeneger

	@Override
	public boolean checkReserve(int flight_no, String ticket_no) {
		if (flight_list.getFlight(flight_no).checkPassenger(ticket_no)) {
			return true;// same as cancelReserve() but returns a boolean
		} else {
			return false;
		}
	}

	@Override
	public String searchPassenger(int flight_no, String ticket_no) {
		return flight_list.getFlight(flight_no).printPassenger(ticket_no);
	}// basically these last three methods have the same type of logic just look at
		// it in the Flights class

}
