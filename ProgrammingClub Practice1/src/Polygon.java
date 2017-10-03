import java.util.*;
import java.math.*;

public class Polygon {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		double[][] points = new double[n][2];
		for(int i=0; i<n; i++){
			double x = scanner.nextInt();
			double y = scanner.nextInt();
			points[i] = new double[] {x, y};
			
			System.out.println(x);
			System.out.println(y);
		}
		
		double[] lengths = new double[n];
		for(int i=1; i<n;i++){
			double x1 = points[i-1][0];
			double y1 = points[i-1][1];
			double x2 = points[i][0];
			double y2 = points[i][1];
			double d = Math.sqrt(Math.pow((x2-x1), 2)+ Math.pow((y2-y1), 2));
			
			
			lengths[i] = d;
			System.out.println(d);
		}
		
		double perimeter = 0;
		for(int i=0; i<n;i++){
			perimeter+=lengths[i];
		}
		
		double apothem = lengths[0]/2*Math.tan(180/n);
		
		double area = perimeter/2 * apothem;
		
		
		System.out.println(perimeter);
		System.out.println(apothem);
		System.out.println(area);
	}
}
