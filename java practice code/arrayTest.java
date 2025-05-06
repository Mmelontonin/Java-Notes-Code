import java.util.*; //import *, wildcard (imports everything) need Arrays to use .toString()

public class arrayTest {

    void printArray(double[] x){ //accepts double 1D array

        System.out.println(x); //prints object reference [D@4517d9a3
        System.out.println(Arrays.toString(x)); //prints [1.0, 2.0]

        System.out.println();
    }

    void print2DArray(int[][] y){

        System.out.println(Arrays.toString(y)); //prints memory address [[I@372f7a8d, [I@2f92e0f4]

        //to print 2D arrays: 
        System.out.println(Arrays.deepToString(y)); //prints multi-dimensional arrays
        System.out.println(y[1][0]); //print elem in 2nd row, 1st column

        System.out.println();        
    }
    
    public static void main(String[] args){
        //static belongs to class, non-static belong to obj instances
        //must make printArray() static or create an instance (did the latter)

        // 1D array test
        arrayTest obj = new arrayTest(); 
        double[] nums = {2.0, 1.0};
        obj.printArray(nums); //pass array

        //alt 1-line vers for 1 time use (anonomous array, no named reference):
        //obj.printArray(new double[]{2.0,1.0});

        obj.print2DArray(new int[2][2]); //creates 2x2 array initialized to zeros
        obj.print2DArray(new int[][] {{2,0,3},{7,8,9}}); //2x3 array or arrays, declares & initializes, dont need to speficy dimentions (inferred from data)        
    }
}
