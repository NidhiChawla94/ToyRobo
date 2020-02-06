package main.java.com.rea.commandpattern;


import main.java.com.rea.robo.Direction;
import main.java.com.rea.robo.ToyRobo;

/**
 * This class implements the interface command so this class is responsible for executing the place command.
 * **/
public class PlaceCommand implements Command {

    private final ToyRobo robo;

    public PlaceCommand(int x, int y, Direction direction) {
        this.robo =new ToyRobo(x, y, direction);
    }
    
    @Override
    public ToyRobo execute(ToyRobo robo) {
        return this.robo;
    }
}
