import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToyRoboMain {

	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RoboCommandsHandler handler = new RoboCommandsHandler();
		List<String> commandsEnterredByUser = new ArrayList<>();
		System.out.println("Please enter commands. (hit enter after every command)");
		System.out.println("To see the output press CTRL+Z");
		System.out.println();

		while (scanner.hasNext()) {
			commandsEnterredByUser.add(scanner.nextLine().trim().toUpperCase());
		}
		scanner.close();
		handler.processCommands(commandsEnterredByUser);
		
	}
}
