package main.java.com.rea.commandpattern;

import main.java.com.rea.robo.ToyRobo;

public interface Command {
	ToyRobo execute(ToyRobo robo);
}
