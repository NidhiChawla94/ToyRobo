package main.java.com.commandpattern;

import main.java.com.robo.ToyRobo;

public interface Command {
	ToyRobo execute(ToyRobo robo);
}
