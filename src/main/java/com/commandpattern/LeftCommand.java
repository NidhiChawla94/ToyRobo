package main.java.com.commandpattern;


import main.java.com.robo.ToyRobo;

public class LeftCommand implements Command {
    @Override
    public ToyRobo execute(ToyRobo robo) {
    	if (robo == null) {
    		System.out.println("Please place the robo first");
            return null;
        }
        return new ToyRobo(robo.getLocation(), robo.getDirection().left());
    }

	
}
