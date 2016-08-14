/*************************************************
 *  Utilities.java                               *
 *  Utility functions for Creatures and Board    *
 *  Version 0.0.1                                *
 *  August 12, 2016                              *
 *  - includes randoms and picking random items  *
 *************************************************/

import java.util.Random;
import java.lang.Math;

public class Utilities {
	public final static Random random = new Random();

	// return double value within specified range
	public double range(double min, double max, double val) {
		return Math.min(max, Math.max(min, val));
	}

	// return int value within specified range
	public int range(int min, int max, int val) {
		return Math.min(max, Math.max(min, val));
	}

	// choose a random double of two inputs
	public double pick(double a, double b) {
		if (random.nextBoolean()) return a;
		else return b;
	}

	// choose a random int of two inputs
	public int pick(int a, int b) {
		if (random.nextBoolean()) return a;
		else return b;
	}
}