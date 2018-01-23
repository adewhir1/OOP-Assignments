import java.util.*;

/**
 *Contains methods to determine whether three user-defined coordinates
 *are the vertices of a real triangle.
 *
 *@version 1.0 13 Sept 2017
 *@author Andrea Dewhirst
 */
public class TriangleTester {

	/**
	 *Helper class to store coordinate values.
	 */
	private static class Coordinate {
		int x, y;

		Coordinate(int X, int Y) {
			x = X;
			y = Y;
		}
	}

	/**
	 *@param x1 the x value of the first point
	 *@param y1 the y value of the first point
	 *@param x2 the x value of the second point
	 *@param y2 the y value of the second point
	 *@return the length of the line segment between the given points
	 */
	public static double getLength(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
	}

	/**
	 *Retrieves a specific coordinate value from the user.
	 *
	 *@param n the name of the coordinate
	 *@param xOrY tells whether the user should input an x or y value
	 *@return the value the user chose as coordinate n's x or y value
	 */
	public static int getValue(char n, char xOrY) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter " + xOrY + " value for coordinate " + n);
		return scan.nextInt();
	}

	/**
	 *Determines and prints whether three coordinates (A, B, and C) with 
	 *user-defined x and y values form the vertices of a real triangle.
	 */
	public static void main(String[] args) {
		
		double side1, side2, side3;
		
		//This paragraph declares three coordinates (A, B, and C),
		//for which the user assigns all respective x and y values.
		Coordinate A = new Coordinate(getValue('A','x'), getValue('A','y'));
		Coordinate B = new Coordinate(getValue('B','x'), getValue('B','y'));
		Coordinate C = new Coordinate(getValue('C','x'), getValue('C','y'));

		//side1 is the length of line segment AB; side2 is the length of
		//line segment AC; side3 is the length of line segment BC 
		side1 = getLength(A.x, A.y, B.x, B.y);
		side2 = getLength(A.x, A.y, C.x, C.y);
		side3 = getLength(B.x, B.y, C.x, C.y);

		if((side1+side2)>side3 && (side1+side3)>side2 && (side2+side3)>side1 ){
			System.out.println("These coordinates form the vertices of a real triangle.");
		} else {
			System.out.println("These coordinates do not form the vertices of a real triangle.");
		}

	}
}	
