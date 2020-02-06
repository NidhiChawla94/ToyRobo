package main.java.com.rea.driver;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.rea.commandpattern.Command;
import main.java.com.rea.commandpattern.LeftCommand;
import main.java.com.rea.commandpattern.MoveCommand;
import main.java.com.rea.commandpattern.PlaceCommand;
import main.java.com.rea.commandpattern.ReportCommand;
import main.java.com.rea.commandpattern.RightCommand;
import main.java.com.rea.robo.Direction;
import main.java.com.rea.util.Constants;

/**
 * Responsible for sending the commands after interpreting the user input.
 * **/
public class RoboCommandsHandler {

	/**
	 * For command entered by user
	 * check which type of command it is and accordingly create respective command handlers.
	 * 
	 * @param String command: command entered by user
	 * @return Command: object of the command to be executed.
	 * */
	public Command processCommands(String command) {
		Command commandToBeExecuted = null;
		if (command.equals(Constants.LEFT)) {
			commandToBeExecuted = new LeftCommand();
		} else if (command.equals(Constants.MOVE)) {
			commandToBeExecuted = new MoveCommand();
		} else if (command.startsWith(Constants.PLACE)) {
			commandToBeExecuted =  processPlaceCommand(command);
		} else if (command.equals(Constants.REPORT)) {
			commandToBeExecuted =  new ReportCommand();
		} else if (command.equals(Constants.RIGHT)) {
			commandToBeExecuted =  new RightCommand();
		} else  {
			throw new IllegalArgumentException("Invalid command: "+ command);
		}

		return commandToBeExecuted;
	}



	/**
	 * This function is the processor of place command. It creates the command object after parsing through the string.
	 * This function also makes sure that command has correct pattern.
	 * @param command: place command in string format.
	 * @return Command object if the command is valid else null.
	 * */
	private static Command processPlaceCommand(String command) {
		Pattern placeExp = Pattern.compile("PLACE [0-4],[0-4],[A-Za-z]+");
		Matcher matcher = placeExp.matcher(command);
		// checks if it matches the regex. 
		if (matcher.matches()) {
			//create command obj if it matches
			String[] commandDetails = command.split(" ")[1].split(",");
			return new PlaceCommand(Integer.parseInt(commandDetails[0]), Integer.parseInt(commandDetails[1]), getDirectionFromCommand(commandDetails[2]));
		} else {
			throw new IllegalArgumentException("Invalid Command location: "+ command);
		}
	}

	/**
	 * This function returns the Direction to be used while creating command
	 * @param String: directionInCommand: direction entered by user
	 * @return Direction: direction at which robot has to be pointed.
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
