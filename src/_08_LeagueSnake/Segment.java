package _08_LeagueSnake;

/*
 * This class will be used to represent each part of the moving snake.
 * 
 * 1. Add x and y member variables.
 *    They will hold the corner location of each segment of the snake.
 * 
 * 2. Add a constructor with parameters to initialize each variable.
 */
public class Segment {
    
	int x;
	int y;
	
	public Segment (int x_var, int y_var){
		this.x = x_var;
		this.y = y_var;
	}
}
