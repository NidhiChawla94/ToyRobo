package main.java.com.rea.robo;

/**
 * The main Robo object.
 * Robo has a location and a direction it is pointing to.
 * **/
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToyRobo other = (ToyRobo) obj;

		if (direction != other.direction)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location)){
			return false;
		}

		return true;
	}


}
