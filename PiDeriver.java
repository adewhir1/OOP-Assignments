//Reference for random number generation: 
//https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
//Source for Ellipse2D use: 
//https://docs.oracle.com/javase/7/docs/api/java/awt/geom/Ellipse2D.Double.html

import java.util.*;
import java.awt.geom.*;

/**
 *Contains methods that can calculate an approximation of pi using
 *the Monte Carlo technique.
 *
 *@version 1.0 16 Oct 2017
 *@author Andrea Dewhirst
 */
public class PiDeriver {

	/**
	 *Creates a unit circle around the origin. The Random number
	 *generator then generates 4000000000 points between 0 and 1-
	 *that is, in the square that contains the upper right quadrant
	 *of the circle. Pi is derived from the ratio of points inside
	 *the circle to points inside the square.
	 */ 
	public static void main(String[] args) {

		long pointsInCircle = 0L;
		long pointsInSquare = 0L;
		Random r = new Random();
		double x, y, piApproximation;

		Ellipse2D.Double c = new Ellipse2D.Double();
		c.setFrame(-1, -1, 2, 2);

		for(long i=0L; i<4000000000L; i++) {
			x = r.nextDouble();
			y = r.nextDouble();
			if(c.contains(x, y)) pointsInCircle++;
			pointsInSquare++;
		}

		piApproximation = 4 * (double)pointsInCircle/pointsInSquare;

		System.out.println(piApproximation);
		
		c = null;
		r = null;
	}

} 
