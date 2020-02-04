package main.java.com.robo.driver;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.commandpattern.Command;
import main.java.com.commandpattern.LeftCommand;
import main.java.com.commandpattern.MoveCommand;
import main.java.com.commandpattern.PlaceCommand;
import main.java.com.commandpattern.ReportCommand;
import main.java.com.commandpattern.RightCommand;
import main.java.com.robo.Direction;
import main.java.com.robo.ToyRobo;
import main.java.com.robo.util.Constants;

public class RoboCommandsHandler {
	private static ToyRobo robo = null;
	
	void processCommands(List<String> commandsEnterredByUser) {
		Command commantToBeExecuted = null;
		for(String command: commandsEnterredByUser) {
			if (command.equals(Constants.LEFT)) {
				commantToBeExecuted = new LeftCommand();
			} else if (command.equals(Constants.MOVE)) {
				commantToBeExecuted = new MoveCommand();
			} else if (command.startsWith(Constants.PLACE)) {
				commantToBeExecuted =  processPlaceCommand(command);
			} else if (command.equals(Constants.REPORT)) {
				commantToBeExecuted =  new ReportCommand();
			} else if (command.equals(Constants.RIGHT)) {
				commantToBeExecuted =  new RightCommand();
			} else  {
				System.out.println("Invalid command: "+ command);
			}
			if(commantToBeExecuted!=null) {
				if(robo == null && !(commantToBeExecuted instanceof PlaceCommand)) {
					System.out.println("Ignoring Command: ");
				} else {
					robo = commantToBeExecuted.execute(robo);
				}
				
			}
		}
		
	}

	private static Command processPlaceCommand(String command) {
		Pattern PLACE_EXP = Pattern.compile("PLACE [0-4],[0-4],[A-Za-z]+");
		Matcher matcher = PLACE_EXP.matcher(command);
		if (matcher.matches()) {
			String[] commandDetails = command.split(" ")[1].split(",");
			return new PlaceCommand(Integer.parseInt(commandDetails[0]), Integer.parseInt(commandDetails[1]), getDirectionFromCommand(commandDetails[2]));
		} else {
			System.out.println("Invalid Command: "+ command);
		}
		return null;
	}

	private static Direction getDirectionFromCommand(String directionInCommand) {
		if (directionInCommand.equals(Constants.NORTH)) {
			return Direction.NORTH;
		} else if (directionInCommand.equals(Constants.EAST)) {
			return Direction.EAST;
		} else if (directionInCommand.equals(Constants.SOUTH)) {
			return Direction.SOUTH;
		} else if (directionInCommand.equals(Constants.WEST)) {
			return Direction.WEST;
		} else {
			throw new IllegalArgumentException("Invalid direction");
		}
	}
}
