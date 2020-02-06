package main.java.com.rea.driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.rea.commandpattern.Command;
import main.java.com.rea.commandpattern.PlaceCommand;
import main.java.com.rea.robo.ToyRobo;

/**
 * Main class responsible for taking Input from user and passing the input to command handler for further processing. 
 * */
public class ToyRoboMain {
	private static ToyRobo robo = null;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RoboCommandsHandler handler = new RoboCommandsHandler();
		List<String> commandsEnterredByUser = new ArrayList<>();
		
		/**
		 * Take input from user
		 * Save the input in an array after trimming and converting it to uppercase.
		 * ***/
		
		System.out.println("Please enter commands. (hit enter after every command)");
		System.out.println("To see the output press CTRL+Z");
		System.out.println();

		while (scanner.hasNext()) {
			commandsEnterredByUser.add(scanner.nextLine().trim().toUpperCase());
		}
		scanner.close();
		//pass the saved commands to handler's process command function.
		for(String command: commandsEnterredByUser) {
			Command processedCommand = handler.processCommands(command);
			/*
			 * Ignoring all the commands that are enterred before the first place command.
			 * This is to ensure robot is first placed and then any other commands are executed
			 * **/
			if(processedCommand!=null) {
				if(!(robo == null && !(processedCommand instanceof PlaceCommand))) {
					robo = processedCommand.execute(robo);
				}
			}
		}
	}
}
