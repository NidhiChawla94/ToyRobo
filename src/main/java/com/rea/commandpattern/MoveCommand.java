package main.java.com.rea.commandpattern;


import main.java.com.rea.robo.ToyRobo;

public class MoveCommand implements Command {

	@Override
	public ToyRobo execute(ToyRobo robo) {
		if (robo == null) {
			System.out.println("Please place the robo first");
            return null;
        }
		
		switch (robo.getDirection()) {
		case NORTH:
			return new ToyRobo(robo.getLocation().getXCord(), robo.getLocation().getYCord() + 1, robo.getDirection());
		case EAST:
			return new ToyRobo(robo.getLocation().getXCord() + 1, robo.getLocation().getYCord(), robo.getDirection());
		case SOUTH:
			return new ToyRobo(robo.getLocation().getXCord(), robo.getLocation().getYCord() - 1, robo.getDirection());
		case WEST:
			return new ToyRobo(robo.getLocation().getXCord() - 1, robo.getLocation().getYCord(), robo.getDirection());
		default:
			System.out.println("Invalid Direction");
			return robo;
		}
	}

}
