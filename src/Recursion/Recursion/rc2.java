package Recursion.Recursion;
public class rc2 {

    public static void printNum(int n){
        if(n == 5) {
            return;
        }
        System.out.println(n);
        printNum(n+1);
    }

    public static void main(String args[]){
        int n = 1;
        printNum(n); // n=1
    }
}