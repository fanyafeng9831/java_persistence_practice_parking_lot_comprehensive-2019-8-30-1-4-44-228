package tws.entity;

public class Parkingboy {
    private String parkingboyId;
    private String name;
    private int parkingboyAge;
	
	public String getParkingboyId() {
		return parkingboyId;
	}
	public void setParkingboyId(String parkingboyId) {
		this.parkingboyId = parkingboyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParkingboyAge() {
		return parkingboyAge;
	}
	public void setParkingboyAge(int parkingboyAge) {
		this.parkingboyAge = parkingboyAge;
	}
	public Parkingboy(String parkingboyId, String name, int parkingboyAge) {
		super();
		this.parkingboyId = parkingboyId;
		this.name = name;
		this.parkingboyAge = parkingboyAge;
	}

    
}
