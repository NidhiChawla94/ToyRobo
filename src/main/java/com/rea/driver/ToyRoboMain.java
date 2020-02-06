package main.java.com.rea.driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class responsible for taking Input from user and passing the input to command handler for further processing. 
 * */
public class ToyRoboMain {
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
		handler.processCommands(commandsEnterredByUser);
		
	}
}
