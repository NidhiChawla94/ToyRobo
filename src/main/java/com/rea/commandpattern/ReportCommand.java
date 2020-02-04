package main.java.com.rea.commandpattern;


import main.java.com.rea.robo.ToyRobo;

public class ReportCommand implements Command {
    @Override
    public ToyRobo execute(ToyRobo robo) {
    	if(robo == null) {
    		System.out.println("Please place the robo first");
    		return null;
    	}
    	System.out.println("REPORTING FROM ReportCommand: "+ robo.getDirection()+ " Location: x- "+robo.getLocation().getXCord()+ " y- "+robo.getLocation().getYCord());
        return robo;
    }
}
