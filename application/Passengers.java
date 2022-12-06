package application;

public class Passengers implements Comparable<Passengers>{
	private String ticket_no;
	private String full_name;
	private String passport;
	private String nationality;
	private String birthdate;
	private int flight_no;
	
	public Passengers(int flight_no, String ticket_no, String full_name, String passport, String nationality,
			String birthdate) {
		this.flight_no = flight_no;
		this.ticket_no = ticket_no;
		this.full_name = full_name;
		this.passport = passport;
		this.nationality = nationality;
		this.birthdate = birthdate;
	}
	
	public int getFlight_no() {
		return flight_no;
	}

	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}

	public Passengers() {
		
	}
	
	public String getTicket_no() {
		return ticket_no;
	}

	public void setTicket_no(String ticket_no) {
		this.ticket_no = ticket_no;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	@Override
	public String toString() {
		return flight_no + " " + ticket_no + " " + full_name + " " + passport + " " + nationality + " " + birthdate;
	}

	@Override
	public int compareTo(Passengers o) {
		if(this.full_name.compareTo(o.full_name) > 0) {
			return 1;
		}
		else if(this.full_name.compareTo(o.full_name) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
