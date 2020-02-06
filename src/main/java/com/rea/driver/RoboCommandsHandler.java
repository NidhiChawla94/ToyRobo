package main.java.com.rea.driver;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.rea.commandpattern.Command;
import main.java.com.rea.commandpattern.LeftCommand;
import main.java.com.rea.commandpattern.MoveCommand;
import main.java.com.rea.commandpattern.PlaceCommand;
import main.java.com.rea.commandpattern.ReportCommand;
import main.java.com.rea.commandpattern.RightCommand;
import main.java.com.rea.robo.Direction;
import main.java.com.rea.robo.ToyRobo;
import main.java.com.rea.util.Constants;

/**
 * Responsible for sending the commands after interpreting the user input.
 * **/
public class RoboCommandsHandler {
	private static ToyRobo robo = null;
	
	void processCommands(List<String> commandsEnterredByUser) {
		Command commantToBeExecuted = null;
		/**
		 * For each command enterred by user
		 * check which type of command it is and accordingly invoke respective command handlers.
		 * */
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
			/*
			 * Ignoring all the commands that are enterred before the first place command.
			 * This is to ensure robot is first placed and then any other commands are executed
			 * **/
			if(commantToBeExecuted!=null) {
				if(!(robo == null && !(commantToBeExecuted instanceof PlaceCommand))) {
					robo = commantToBeExecuted.execute(robo);
				}
			}
		}
		
	}

	/**
	 * This function is the processor of place command. It creates the command object after parsing through the string.
	 * This function also makes sure that command has correct pattern.
	 * @param command: place command in string format.
	 * @return Command obj if the command is valid else null.
	 * */
	private static Command processPlaceCommand(String command) {
		Pattern PLACE_EXP = Pattern.compile("PLACE [0-4],[0-4],[A-Za-z]+");
		Matcher matcher = PLACE_EXP.matcher(command);
		// checks if it matches the regex. 
		if (matcher.matches()) {
			//create command obj if it matches
			String[] commandDetails = command.split(" ")[1].split(",");
			return new PlaceCommand(Integer.parseInt(commandDetails[0]), Integer.parseInt(commandDetails[1]), getDirectionFromCommand(commandDetails[2]));
		} else {
			System.out.println("Invalid Command: "+ command);
		}
		return null;
	}

	/**
	 * This function returns the enum of Direction to be used while creating command
	 * **/
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
