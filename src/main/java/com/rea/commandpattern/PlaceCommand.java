package main.java.com.rea.commandpattern;


import main.java.com.rea.robo.Direction;
import main.java.com.rea.robo.ToyRobo;

public class PlaceCommand implements Command {

    private final ToyRobo robo;

    public PlaceCommand(int x, int y, Direction direction) {
        this(new ToyRobo(x, y, direction));
    }

    public PlaceCommand(ToyRobo robo) {
        this.robo = robo;
    }

    @Override
    public ToyRobo execute(ToyRobo robo) {
        return this.robo;
    }
}
