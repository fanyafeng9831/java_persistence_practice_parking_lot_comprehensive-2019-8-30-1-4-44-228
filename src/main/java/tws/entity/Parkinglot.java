package tws.entity;

public class Parkinglot {
    private int parkinglotId;
	
    private int parkinglotCapacity;
    private int parkinglotAvailablePositionCount;
    private int parkingboyId;
	public int getParkinglotId() {
		return parkinglotId;
	}
	public void setParkinglotId(int parkinglotId) {
		this.parkinglotId = parkinglotId;
	}
	public int getParkinglotCapacity() {
		return parkinglotCapacity;
	}
	public void setParkinglotCapacity(int parkinglotCapacity) {
		this.parkinglotCapacity = parkinglotCapacity;
	}
	public int getParkinglotAvailablePositionCount() {
		return parkinglotAvailablePositionCount;
	}
	public void setParkinglotAvailablePositionCount(int parkinglotAvailablePositionCount) {
		this.parkinglotAvailablePositionCount = parkinglotAvailablePositionCount;
	}
	public int getParkingboyId() {
		return parkingboyId;
	}
	public void setParkingboyId(int parkingboyId) {
		this.parkingboyId = parkingboyId;
	}
	public Parkinglot(int parkinglotId, int parkinglotCapacity, int parkinglotAvailablePositionCount,
			int parkingboyId) {
		super();
		this.parkinglotId = parkinglotId;
		this.parkinglotCapacity = parkinglotCapacity;
		this.parkinglotAvailablePositionCount = parkinglotAvailablePositionCount;
		this.parkingboyId = parkingboyId;
	}

   
}
