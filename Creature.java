/***************************************
 *  Creature.java                      *
 *  Creature data object               *
 *  Version 0.0.1                      *
 *  August 10, 2016                    *
 *  - includes stats and constructors  *
 ***************************************/

import java.util.Random;
import java.util.math;

public class Creature {

	private boolean alive;
	private static int max_lifespan = 1000;
	private int lifespan;
	private int age;

	private boolean sex;
	private double aggression;
	private int speed;
	private static int max_speed = 5;

	private int health;
	private int totalHealth;
	private static int max_health = 100;

	private int attractiveness;
	private static int max_attractive = 20;

	private int strength;
	private static int max_strength = 50;

	private int sight;
	private static int sight_max = 10;

	private double efficiency;
	private double curiosity;

	final static Random random = new Random();

	// constructor for Creature, generated with random stats
	public Creature() {
		this.alive = true;
		this.lifespan = random.nextInt(max_lifespan - 9) + 10;
		this.age = age();

		this.sex = (lifespan % 2 == 1);
		this.aggression = random.nextDouble();
		this.speed = random.nextInt(max_speed);

		this.totalHealth = random.nextInt(max_health/2) + random.nextInt(max_health/2);
		this.health = totalHealth;
		this.attractiveness = random.nextInt(max_attractive);
		this.strength = random.nextInt(max_strength);
		this.sight = 1; // make better
		this.efficiency = random.nextDouble();
		this.curiosity = random.nextDouble();
	}

	// constructor for Creature generated from parent creature stats
	public Creature(Creature p1, Creature p2) {
		this.alive = true;
		this.lifespan = range(0, max_lifespan, (pick(p1.lifespan, p2.lifespan) + random.nextInt(11) -5);
		this.age = 0;

		this.sex = random.nextBoolean();
		this.aggression = range(0.0, 1.0, (pick(p1.aggression, p2.aggression) + (random.nextDouble()/5 -0.1));
		this.speed = range(0, max_speed, (pick(p1.speed, p2.speed) + random.nextInt(3) -1));
		
		this.totalHealth = range(0, max_health, (pick(p1.totalHealth, p2.totalHealth) + random.nextInt(21) -10));
		this.health = totalHealth;
		this.attractiveness = range(0, max_attractive, (pick(p1.attractiveness, p2.attractiveness) + random.nextInt(11) -5));
		this.strength = range(0, max_strength, (pick(p1.strength, p2.strength) + random.nextInt(11) -5));
		this.sight = 1; //range(0, max_sight, (pick(p1.sight, p2.sight) + random.nextInt(5) -2));
		this.efficiency = range(0.0, 1.0, (pick(p1.efficiency, p2.efficiency) + nextDouble()/5 -0.1));
		this.curiosity = range(0.0, 1.0, (pick(p1.curiosity, p2.curiosity) + nextDouble()/5 -0.1));
	}

	// return double value within specified range
	private double range(double min, double max, double val) {
		return math.min(max, math.max(min, val));
	}

	// return int value within specified range
	private int range(int min, int max, int val) {
		return math.min(max, math.max(min, val));
	}

	// choose a random generic of two inputs
	private <E> pick(<E> a, <E> b) {
		if (random.nextBoolean()) return a;
		else return b; 
	}

	// calculate age for random Creature
	private int age() {
		int age = random.nextInt(lifespan);
		return age;
	}

	// check if this Creature will mate with another input Creature
	private boolean checkMate(Creature other) {
		// multiple factors contribute to compatibility
		int score = 0;
		if (other.sex != sex) {
			score--;
		}
		if (other.attractiveness >= random.nextInt(11) +5) {
			score++;
		}
	}
/*******************
 *  Interactions:  *
 *                 *
 *  Mate           *
 *  Fight          *
 *  Eat            *
 *  Sight          *
 *  Path to/away   *
 *******************/
}