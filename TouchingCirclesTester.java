import java.util.*;

/**
 *Contains functions that determine whether two user-defined circles
 *touch, overlap,or enclose one another.
 *
 *@version 1.0 13 Sept 2017
 *@author Andrea Dewhirst
 */
public class TouchingCirclesTester {

	/**
	 *Computes the distance between two points.
	 *@param x1 the x value of the first point
	 *@param y1 the y value of the first point
	 *@param x2 the x value of the second point
	 *@param y2 the y value of the second point
	 *@return the distance between (x1,y1) and (x2,y2)
	 */
	public static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}

	/**
	 *Accepts user input for the centerpoints and radii of two
	 *circles. Outputs whether the circles touch, overlap, or
	 *enclose.
	 */
	public static void main(String[] args) {
		int x1, y1, x2, y2, radius1, radius2, smallerRadius;
		Scanner scan = new Scanner(System.in);
		double distance;

		//This paragraph takes user input regarding circle 1.
		System.out.println("Enter x value of circle1's centerpoint");
		x1 = scan.nextInt();
		System.out.println("Enter y value of circle1's centerpoint");
		y1 = scan.nextInt();
		System.out.println("Enter circle1's radius");
		radius1 = scan.nextInt();

		//This paragraph takes user input regarding circle 2.
		System.out.println("Enter x value of circle2's centerpoint");
		x2 = scan.nextInt();
		System.out.println("Enter y value of circle2's centerpoint");
		y2 = scan.nextInt();
		System.out.println("Enter circle2's radius");
		radius2 = scan.nextInt();

		//Stores the distance between the centerpoints.
		distance = distance(x1, y1, x2, y2);

		//This paragraph determines and outputs the relationship
		//between the two circles.
		if(distance < Math.abs(radius1 - radius2)){ 
		   System.out.println("One circle encloses the other.");
		} else if(distance - (radius1 + radius2) < 0){
		   System.out.println("The circles overlap.");
		} else if(distance - (radius1 + radius2) == 0){
		   System.out.println("The circles' edges touch.");
		} else if(distance - (radius1 + radius2) > 0)
		   System.out.println("The circles are not touching.");
	}
}
