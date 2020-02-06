package main.java.com.rea.commandpattern;


import main.java.com.rea.robo.ToyRobo;
/**
 * This class implements the interface command so this class is responsible for executing the place command.
 * **/	
public class ReportCommand implements Command {
    @Override
    public ToyRobo execute(ToyRobo robo) {
    	if(robo == null) {
    		System.out.println("Please place the robo first");
    		return null;
    	}
    	System.out.println("Position of the robot: "+robo.getLocation().getXCord()+ " ,"+robo.getLocation().getYCord()+ " ,"+ robo.getDirection());
        return robo;
    }
}
