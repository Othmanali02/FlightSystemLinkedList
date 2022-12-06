package application;

public interface FlightSystemInterface {
	
	public void addFlight(int flight_no, String Airline, String source, String destination, int Capacity);
	
	public void deleteFlight(int flight_no);
	
	public void addPassengertoFlight(int flight_no, String ticket_no, String name, String passport, String nationality, String birthdate);

	public String getAllFlightInfo(int flight_no);
	
	public String getAllFlightsInfo();
	
	public String getAllPassengerInfo(int flight_no);
	
	public void cancelReserve(int flight_no, String ticket_no);
	
	public boolean checkReserve(int flight_no, String ticket_no);
	
	public String searchPassenger(int flight_no, String ticket_no);
	
}