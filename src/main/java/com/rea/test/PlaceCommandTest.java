package main.java.com.rea.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.com.rea.commandpattern.Command;
import main.java.com.rea.commandpattern.PlaceCommand;
import main.java.com.rea.robo.Direction;
import main.java.com.rea.robo.ToyRobo;


public class PlaceCommandTest {

	private Command placeCommand;
	private ToyRobo robot;
	
	@Before
	public void setUp() {
		robot = new ToyRobo(1, 1, Direction.SOUTH);
		placeCommand = new PlaceCommand(1,1,Direction.SOUTH);
	}	
	@Test
	public void testPlaceCommandWhenRobotIsNull() {
		assertEquals(robot, placeCommand.execute(null));
	}

	@Test
	public void testPlaceCommandWhenRobot() {
		ToyRobo testRobot = new ToyRobo(4, 4, Direction.EAST);
		assertEquals(robot, placeCommand.execute(testRobot));
	}
	
}
