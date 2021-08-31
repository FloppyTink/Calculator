
/**
 * Write a description of class input here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 

import java.util.Scanner;

public class USERINPUT {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //allow user  input;
        System.out.println("How many numbers do you want to enter?");
        int num = input.nextInt();

        int array[] = new int[num];

        System.out.println("Enter the " + num + " numbers now.");

        for (int i = 0 ; i < array.length; i++ ) {
           array[i] = input.nextInt();
        }

        //you notice that now the elements have been stored in the array .. array[]

        System.out.println("These are the numbers you have entered.");
        printArray(array);

        input.close();

    }

    //this method prints the elements in an array......
    //if this case is true, then that's enough to prove to you that the user input has  //been stored in an array!!!!!!!
    public static void printArray(int arr[]){

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
