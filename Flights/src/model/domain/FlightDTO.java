package model.domain;

public class FlightDTO {
	
	private String airline;
	private String flight;
	private String arrivaltm;
	private String estimatedtm;
	private String airport;
	private int gatenumber;
	private int carousel;
	private int number;
	public FlightDTO(String airline, String flight, String arrivaltm, String estimatedtm, String airport,
			int gatenumber, int carousel, int number) {
		super();
		this.airline = airline;
		this.flight = flight;
		this.arrivaltm = arrivaltm;
		this.estimatedtm = estimatedtm;
		this.airport = airport;
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
	public String getArrivaltm() {
		return arrivaltm;
	}
	public void setArrivaltm(String arrivaltm) {
		this.arrivaltm = arrivaltm;
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
		builder.append("������ [�װ��� =");
		builder.append(airline);
		builder.append(", �װ���=");
		builder.append(flight);
		builder.append(", �����ð�=");
		builder.append(arrivaltm);
		builder.append(", ����� �����ð�=");
		builder.append(estimatedtm);
		builder.append(", ��߰���=");
		builder.append(airport);
		builder.append(", �ⱸ=");
		builder.append(gatenumber);
		builder.append(", ȭ����Ʈ��ȣ=");
		builder.append(carousel);
		builder.append(", ���ã���ȣ=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}