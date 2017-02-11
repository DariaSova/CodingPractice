import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String[] input = readDimentions(sc);
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        
        int[][] values = readArray(sc, rows, columns);
        
        //if array not empty
        int Rmin = 0;
        int Rmax = rows-1;
        int Cmin = 0;
        int Cmax = columns-1;
        
        while(Rmax>=Rmin && Cmax>=Cmin){
        	if(Rmin==Rmax&&Cmax==Cmin)
        		System.out.println(values[Rmin][Cmin]+",");
            //right
            for(int c=Cmin; c<=Cmax; c++)
                System.out.println(values[Rmin][c]+",");
            
           //rdown
            for(int r=Rmin+1; r<=Rmax; r++)
                System.out.println(values[r][Cmax]+",");
           //left
           for(int c=Cmax-1; c>=Cmin; c--)
                System.out.println(values[Rmax][c]+","); 
           //up
           for(int r=Rmax-1; r>Rmin; r--)
                System.out.println(values[r][Cmin]+","); 
            
           Rmax--;
           Rmin++;
           Cmax--;
           Cmin++;
        }
    }
    
    static String[] readDimentions(Scanner sc){
        String curr = sc.nextLine();
        return curr.split(",");
    }
    
    static int[][] readArray(Scanner sc, int rows, int columns){
       
        String curr;
        String[] input;
        //input = curr.split(",");
        //int rows = Integer.parseInt(input[0]);
        //int columns = Integer.parseInt(input[1]);
        int[][] values = new int[rows][columns];
        
        int r =0;
        while(r<rows){
            curr = sc.nextLine();
            input = curr.split(",");
            for(int c =0; c<columns; c++){
                values[r][c] = Integer.parseInt(input[c]);
                //System.out.println(values[r][c] +"ll");
            }
            r++;
        }
        return values;
    }
}
