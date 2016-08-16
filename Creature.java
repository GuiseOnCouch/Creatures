/***************************************
 *  Creature.java                      *
 *  Creature data object               *
 *  Version 0.0.3                      *
 *  August 12, 2016                    *
 *  - includes stats and constructors  *
 ***************************************/

public class Creature extends Utilities {
	private char name;
	private static int nameInc = 0;

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

	// constructor for Creature, generated with random stats
	public Creature() {
		this.name = nextName();
		this.alive = true;
		this.lifespan = random.nextInt(max_lifespan - 9) + 10;
		this.age = random.nextInt(lifespan);

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
		this.name = nextName();
		this.alive = true;
		this.lifespan = range(0, max_lifespan, (pick(p1.lifespan, p2.lifespan) + random.nextInt(11) -5));
		this.age = 0;

		this.sex = random.nextBoolean();
		this.aggression = range(0.0, 1.0, (pick(p1.aggression, p2.aggression) + random.nextDouble()/5 -0.1));
		this.speed = range(0, max_speed, (pick(p1.speed, p2.speed) + random.nextInt(3) -1));
		
		this.totalHealth = range(0, max_health, (pick(p1.totalHealth, p2.totalHealth) + random.nextInt(21) -10));
		this.health = totalHealth;
		this.attractiveness = range(0, max_attractive, (pick(p1.attractiveness, p2.attractiveness) + random.nextInt(11) -5));
		this.strength = range(0, max_strength, (pick(p1.strength, p2.strength) + random.nextInt(11) -5));
		this.sight = 1; //range(0, max_sight, (pick(p1.sight, p2.sight) + random.nextInt(5) -2));
		this.efficiency = range(0.0, 1.0, (pick(p1.efficiency, p2.efficiency) + random.nextDouble()/5 -0.1));
		this.curiosity = range(0.0, 1.0, (pick(p1.curiosity, p2.curiosity) + random.nextDouble()/5 -0.1));
	}

	// increment age
	private void age() {
		age++;
		if (age > lifespan) {
			alive = false;
		}
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
		return score > 0;
	}

	// determines this creature's action each round
	public void act() {
		if (health < totalHealth) {
			//path to food
		}
		// path from hostiles
		// path to mate
		// path random (curiosity)
	}

	// determines how this creature will interact with another creature
	public void interact(Creature other) {

	}

	// get the next name
	private char nextName() {
		char name = (char) (nameInc + ((int) 'a'));
		nameInc = (nameInc + 1) % 52;
		return name;
	}
	
	public char getName() {
		return name;
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