package main.java.com.robo;

public class ToyRobo {
	private final Direction direction;
	private final Location location;

	public ToyRobo(int x, int y, Direction direction) {
		this.direction = direction;
		this.location = new Location(x, y);
	}

	public ToyRobo(Location position, Direction direction) {
		this.direction = direction;
		this.location = position;
	}

	public Direction getDirection() {
		return this.direction;
	}

	public Location getLocation() {
		return this.location;
	}
}
