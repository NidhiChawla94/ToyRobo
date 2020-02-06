package main.java.com.rea.commandpattern;

import main.java.com.rea.robo.ToyRobo;
import main.java.com.rea.util.Constants;

/**
 * This class implements the interface command so this class is responsible for moving the robot one step in the direction it was facing.
 * **/
public class MoveCommand implements Command {

	@Override
	public ToyRobo execute(ToyRobo robo) {
		if (robo == null) {
			System.out.println("Please place the robo first");
            return null;
        }
		
		
		switch (robo.getDirection()) {
		case NORTH:
			if(robo.getLocation().getYCord() == Constants.YCordMaxBORDER)
				return robo;
			
			return new ToyRobo(robo.getLocation().getXCord(), robo.getLocation().getYCord() + 1, robo.getDirection());
		case EAST:
			if(robo.getLocation().getXCord() == Constants.XCordMaxBORDER)
				return robo;
			
			return new ToyRobo(robo.getLocation().getXCord() + 1, robo.getLocation().getYCord(), robo.getDirection());
		case SOUTH:
			if(robo.getLocation().getYCord() == Constants.YCordMinBORDER)
				return robo;
			
			return new ToyRobo(robo.getLocation().getXCord(), robo.getLocation().getYCord() - 1, robo.getDirection());
		case WEST:
			if(robo.getLocation().getXCord() == Constants.XCordMinBORDER)
				return robo;
			
			return new ToyRobo(robo.getLocation().getXCord() - 1, robo.getLocation().getYCord(), robo.getDirection());
		default:
			System.out.println("Invalid Direction");
			return robo;
		}
	}

}
