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
}
