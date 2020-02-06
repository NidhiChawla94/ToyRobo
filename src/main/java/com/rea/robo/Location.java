package main.java.com.rea.robo;

/**
 * This class object holds the location details in terms of x and y coordinates.
 * */

public class Location {
	private final int xCord;
    private final int yCord;

    public Location(int xCord, int yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public int getXCord() {
        return this.xCord;
    }

    public int getYCord() {
        return this.yCord;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xCord;
		result = prime * result + yCord;
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
		Location other = (Location) obj;
		if (xCord != other.xCord)
			return false;
		if (yCord != other.yCord)
			return false;
		return true;
	}
    
    
}
