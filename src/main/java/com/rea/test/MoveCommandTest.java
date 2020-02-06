package main.java.com.rea.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.com.rea.commandpattern.Command;
import main.java.com.rea.commandpattern.MoveCommand;
import main.java.com.rea.robo.Direction;
import main.java.com.rea.robo.ToyRobo;

public class MoveCommandTest {

	private Command moveCommand;
	private ToyRobo robot,testRobot;

	@Before
	public void setUp() {
		moveCommand = new MoveCommand();
	}	
	@Test
	public void test() {
		robot = new ToyRobo(1, 1, Direction.NORTH);
		testRobot = new ToyRobo(1, 2, Direction.NORTH);
		assertEquals(testRobot,
                moveCommand.execute(robot));
	}
	@Test
	public void testNorthBorder() {
		robot = new ToyRobo(0, 4, Direction.NORTH);
		assertEquals(robot,
                moveCommand.execute(robot));
	}
	@Test
	public void testSouthBorder() {
		robot = new ToyRobo(0, 0, Direction.SOUTH);
		assertEquals(robot,
                moveCommand.execute(robot));
	}
	@Test
	public void testEastBorder() {
		robot = new ToyRobo(4, 4, Direction.EAST);
		assertEquals(robot,
                moveCommand.execute(robot));
	}
	@Test
	public void testWestBorder() {
		robot = new ToyRobo(0, 1, Direction.WEST);
		assertEquals(robot,
                moveCommand.execute(robot));
	}

}
