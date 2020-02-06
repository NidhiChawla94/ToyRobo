# ToyRobo
To run the project import in any IDE and click run.

This robot which can move in 5*5 box index ranging from 0-4 in both x and y coordinates.
Assume 0,0 is the south west direction. For example: 

				  N
					
					
		   W			 E
					
			(0,0)		
				  S
					

Approach:
	1. The user enters the list of commands.
	2. Each command is processed and accordingly command is executed.
	3. The solution implements command pattern to execute the actions entered by the user.
	4. Move command : move only on valid coordinates.
	5. Direction: this enum calculates which direction will be at left/right side of current direction.