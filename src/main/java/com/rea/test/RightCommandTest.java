package main.java.com.rea.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.com.rea.commandpattern.Command;
import main.java.com.rea.commandpattern.RightCommand;
import main.java.com.rea.robo.Direction;
import main.java.com.rea.robo.ToyRobo;

public class RightCommandTest {

	private Command rightCommand;
	private ToyRobo robot, testRobot;

	@Before
	public void setUp() {
		rightCommand = new RightCommand();
	}	
	@Test
	public void test() {
		robot = new ToyRobo(1, 1, Direction.NORTH);
		testRobot = new ToyRobo(1, 1, Direction.EAST);
		assertEquals(testRobot,
				rightCommand.execute(robot));
	}

}
