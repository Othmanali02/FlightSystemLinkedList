package application;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
	public static void main(String[] args) throws NumberFormatException, IOException {

		File flights = new File("src/flights.txt");
		File passengers = new File("src/passengers.txt");

		BufferedReader flights_br = new BufferedReader(new FileReader(flights));
		BufferedReader passengers_br = new BufferedReader(new FileReader(passengers));

		FlightSystem instance = new FlightSystem();

		String st_flight = "";
		while ((st_flight = flights_br.readLine()) != null) {// READING FROM FILES
			String[] split = st_flight.split(",");
			for (int i = 0; i < split.length - 4; i++) {
				instance.addFlight(Integer.parseInt(split[i]), split[i + 1], split[i + 2], split[i + 3],
						Integer.parseInt(split[i + 4]));
			}
		}
		
		try {
			String st_passegners = "";
			while ((st_passegners = passengers_br.readLine()) != null) {//ADDING PASSENGERS BASED ON FLIGHT NUMBER
				String[] split = st_passegners.split(",");
				for (int i = 0; i < split.length - 5; i++) {
					instance.addPassengertoFlight(Integer.parseInt(split[i]), split[i + 1], split[i + 2], split[i + 3],
							split[i + 4], split[i + 5]);
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		flights_br.close();
		passengers_br.close();
		

		System.out.println(instance.getAllFlightsInfo());
		
		instance.getAllFlightInfo(330);
		
		instance.deleteFlight(128);
		
		System.out.println(instance.getAllFlightsInfo());

		/*
		instance.addPassengertoFlight(543, "84012975", "Othman", "T934253", "Palestinian", "31/12/2002");
		
		instance.cancelReserve(543, "8401975");
		
		System.out.println(instance.checkReserve(543, "84012975"));
		
		System.out.println(instance.getAllPassengerInfo(543));
		
		instance.searchPassenger(235, "5644327");
		*/
		
	}
}