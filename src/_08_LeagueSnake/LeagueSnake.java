package _08_LeagueSnake;

import java.util.ArrayList;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 800;

	/*
	 * Game variables
	 * 
	 * Put all the game variables here.
	 */
	int foodX;
	int foodY;
	int snakeX = 250;
	int snakeY = 250;
	Segment head;
	int direction = UP;
	int food_eaten = 0;
	ArrayList<Segment> tail = new ArrayList<Segment>();


	/*
	 * Setup methods
	 * 
	 * These methods are called at the start of the game.
	 */
	@Override
	public void settings() {
		size(500,500);
	}

	@Override
	public void setup() {
		head = new Segment(10,10);
		frameRate(20);
		dropFood();
	}

	void dropFood() {
		// Set the food in a new random location
		foodX = ((int)random(50)*10);
		foodY = ((int)random(50)*10);
	}

	/*
	 * Draw Methods
	 * 
	 * These methods are used to draw the snake and its food
	 */

	@Override
	public void draw() {
		background(0,0,0);
		drawFood();
		move();
		drawSnake();
		eat();
	}

	void drawFood() {
		// Draw the food\
		fill(255,0,0);
		rect(foodX,foodY,10,10);

	}

	void drawSnake() {
		// Draw the head of the snake followed by its tail
		fill(0,0,255);
		rect(snakeX,snakeY,10,10);
		manageTail();

	}

	void drawTail() {
		// Draw each segment of the tail
		for(int i =0; i<tail.size(); i++) {
			rect(snakeX, snakeY, 10,10);
			//tail.add();
			
		}
	}

	/*
	 * Tail Management methods
	 * 
	 * These methods make sure the tail is the correct length.
	 */

	void manageTail() {
		// After drawing the tail, add a new segment at the "start" of the tail and
		// remove the one at the "end"
		// This produces the illusion of the snake tail moving.
		checkTailCollision();
		drawTail();
		Segment new_segment = new Segment(snakeX, snakeY);
		tail.add(new_segment);
		//What does it mean by remove the first segment from the tail? What's the first segment?
		tail.remove(head);
		}

	void checkTailCollision() {
		// If the snake crosses its own tail, shrink the tail back to one segment
		food_eaten = 1;
		tail = new ArrayList<Segment>();
		Segment reset = new Segment(snakeX, snakeY);
		tail.add(reset);
	}

	/*
	 * Control methods
	 * 
	 * These methods are used to change what is happening to the snake
	 */

	@Override
	public void keyPressed() {
		// Set the direction of the snake according to the arrow keys pressed
		if (key == CODED) {
			if(keyCode  == UP) {
				direction = keyCode;
			}
			
			else if(keyCode  == DOWN) {
				direction = keyCode;
			}
			
			else if(keyCode  == LEFT) {
				direction = keyCode;
			}
			
			else if(keyCode  == RIGHT) {
				direction = keyCode;
			}
		}
	}

	void move() {
		// Change the location of the Snake head based on the direction it is moving.
		if (direction == UP) {
			snakeY-=10;
			checkBoundaries();
		}

		else if (direction == DOWN) {
			snakeY+=10;
			checkBoundaries();
		}

		else if (direction == LEFT) {
			snakeX-=10;
			checkBoundaries();}

		else if (direction == RIGHT) {
			snakeX+=10;
			checkBoundaries();
		}
		/*
        if (direction == UP) {
            // Move head up

        } else if (direction == DOWN) {
            // Move head down

        } else if (direction == LEFT) {

        } else if (direction == RIGHT) {

        }
		 */
	}

	void checkBoundaries() {
		// If the snake leaves the frame, make it reappear on the other side
		if(snakeX<0) {
			snakeX=500;
		}
		if(snakeX>500) {
			snakeX=0;
		}
		
		if(snakeY<0) {
			snakeY=500;
		}
		if(snakeY>500) {
			snakeY=0;
		}
	}

	void eat() {
		// When the snake eats the food, its tail should grow and more
		// food appear
		if(snakeX == foodX && snakeY == foodY) {
			food_eaten+=1;
			dropFood();
			System.out.println(food_eaten);
		}
		if(food_eaten>0) {
			Segment grow = new Segment(snakeX, snakeY);
			tail.add(grow);
		}

	}

	static public void main(String[] passedArgs) {
		PApplet.main(LeagueSnake.class.getName());
	}
}
