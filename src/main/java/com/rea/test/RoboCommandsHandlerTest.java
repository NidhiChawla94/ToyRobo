package main.java.com.rea.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.java.com.rea.commandpattern.LeftCommand;
import main.java.com.rea.commandpattern.MoveCommand;
import main.java.com.rea.commandpattern.PlaceCommand;
import main.java.com.rea.commandpattern.ReportCommand;
import main.java.com.rea.commandpattern.RightCommand;
import main.java.com.rea.driver.RoboCommandsHandler;

public class RoboCommandsHandlerTest {

	private RoboCommandsHandler handler;
	
	@Before
	public void setup() {
		handler = new RoboCommandsHandler();
	}
	@Test
	public void testLeftProcessing() {
		assertTrue(handler.processCommands("LEFT") instanceof LeftCommand);
	}
	@Test
	public void testRightProcessing() {
		assertTrue(handler.processCommands("RIGHT") instanceof RightCommand);
	}
	@Test
	public void testMoveProcessing() {
		assertTrue(handler.processCommands("MOVE") instanceof MoveCommand);
	}
	@Test
	public void testPlaceProcessing() {
		assertTrue(handler.processCommands("PLACE 0,1,NORTH") instanceof PlaceCommand);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testPlaceXCoordinate() {
		handler.processCommands("PLACE -1,1,NORTH");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testPlaceYCoordinate() {
		handler.processCommands("PLACE 1,-1,NORTH");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testPlaceBorderCoordinate() {
		handler.processCommands("PLACE 5,5,NORTH");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPlaceDirection() {
		handler.processCommands("PLACE 1,1,test");
	}
	@Test
	public void testReportProcessing() {
		assertTrue(handler.processCommands("REPORT") instanceof ReportCommand);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCommandProcessing() {
		handler.processCommands("jguujb");
	}

	
}
