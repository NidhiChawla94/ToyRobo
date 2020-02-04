package main.java.com.rea.robo;

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
