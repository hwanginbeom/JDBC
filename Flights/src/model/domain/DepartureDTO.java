package model.domain;

public class DepartureDTO {
	private String airline;
	private String flight;
	private String departuretm;
	private String estimatedtm;
	private String airport;
	private String checkin;
	private int gatenumber;
	private int carousel;
	private int number;
	public DepartureDTO(String airline, String flight, String departuretm, String estimatedtm, String airport,
			String checkin, int gatenumber, int carousel, int number) {
		super();
		this.airline = airline;
		this.flight = flight;
		this.departuretm = departuretm;
		this.estimatedtm = estimatedtm;
		this.airport = airport;
		this.checkin = checkin;
		this.gatenumber = gatenumber;
		this.carousel = carousel;
		this.number = number;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}

	public String getDeparturetm() {
		return departuretm;
	}

	public void setDeparturetm(String departuretm) {
		this.departuretm = departuretm;
	}

	public String getEstimatedtm() {
		return estimatedtm;
	}

	public void setEstimatedtm(String estimatedtm) {
		this.estimatedtm = estimatedtm;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public int getGatenumber() {
		return gatenumber;
	}

	public void setGatenumber(int gatenumber) {
		this.gatenumber = gatenumber;
	}

	public int getCarousel() {
		return carousel;
	}

	public void setCarousel(int carousel) {
		this.carousel = carousel;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("출발편 [항공사=");
		builder.append(airline);
		builder.append(", 항공기명=");
		builder.append(flight);
		builder.append(", 도착시간=");
		builder.append(departuretm);
		builder.append(", 변경된 도착시간=");
		builder.append(estimatedtm);
		builder.append(", 도착공항=");
		builder.append(airport);
		builder.append(", 체크인구역=");
		builder.append(checkin);
		builder.append(", 게이트번호=");
		builder.append(gatenumber);
		builder.append(", 화물벨트번호=");
		builder.append(carousel);
		builder.append(", 즐겨찾기번호=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}

}
