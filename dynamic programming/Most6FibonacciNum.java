import java.util.*;

public class Most6FibonacciNum
{

    static ArrayList<Integer> fib (int i, int n){
        ArrayList<Integer> v1=new ArrayList<Integer>();
        v1.add(0);
        v1.add(1);
        while(v1.get(v1.size()-1)<n){
            v1.add(v1.get(i-1)+v1.get(i-2));
            i++;
        }
        return v1;
    }
	public static void main(String[] args) {
    System.out.println(fib(2,10));
	}
}
