import java.util.*;

public class stringTest {
    void Reverser(String[] x){
        String rv ="";
        for (String s : x){
            String tmp ="";
            for (char c : s.toCharArray()){
                tmp = tmp +c;
            }
        rv = tmp+" "+rv;
        }
        System.out.println(rv);
        System.out.println();
    }
    public static void main(String[] args){
        String s = "Hello world ";
        String rep = s.repeat(3); //repeat() us method of String class
        System.out.println(rep);

        //reverser test
        stringTest obj = new stringTest();

        String[] arr = s.split(" "); //splits by space char, ["Hello", "World"] 
        obj.Reverser(arr); //prints world Hello
        //1st it tmp = "Hello" & rv = "Hello"
        //2nd it tmp = "world" & rv = "world Hello"


    }
}
