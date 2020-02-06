package main.java.com.rea.robo;

/**
 * This enum is used to get the new Direction at which the robot is pointing once the left and right commands have been issued.
 * 
 * There are 4 directions:
 * NORTH,SOUTH,EAST,WEST
 * **/
public enum Direction {
	NORTH,
	EAST,
	SOUTH,
	WEST;
	public Direction left() {
		switch (this) {
		case NORTH:
			return WEST;
		case EAST:
			return NORTH;
		case SOUTH:
			return EAST;
		case WEST:
			return SOUTH;
		default:
			throw new IllegalStateException("INVALID DIRECTION");
		}
	}

	public Direction right() {
		switch (this) {
		case NORTH:
			return EAST;
		case EAST:
			return SOUTH;
		case SOUTH:
			return WEST;
		case WEST:
			return NORTH;
		default:
			throw new IllegalStateException("INVALID DIRECTION");
		}
	}
}
