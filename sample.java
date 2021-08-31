
/** 
 * Simple calculator class to perform basic calculation.
 *
 * @author :Vinh Bui
 * @version:1.0/13.07.21
 */
import java.util.Scanner;

public class sample
{
    private String screen;
    private double first_number;
    private double second_number;
    private char operator;

    /**
     * Constructor for objects of class Calclator
     */
    public sample()
    {
        // initialise instance variables
        first_number= 10;
        second_number= 20;
        screen = "Welcome to my calculator";
    }

    /*
     * 
     */
    public void calculate() {
        switch (operator) {
            case '+':
                Addition();
                break;
            case '-':
                Subtraction();
                break;
            case '*':
                Multiplication();
                break;
            case '/':
                Division();
                break;            
        }
    }

     /**
     * An method to read in arguments from the user
     *
     * @param  
     * @return    
     */    
    public void ReadArguments() {
        boolean invalid;

        do {
            try {
                invalid = false;
                System.out.print("Please enter two numbers for the calculation [x y]:");
                Scanner inScanner = new Scanner(System.in);
                first_number = inScanner.nextDouble();        
                second_number = inScanner.nextDouble(); 
                System.out.println("User entered: " + first_number + " and " + second_number);
            } catch (Exception e) {
                System.out.println("Please enter valid numnbers");
                invalid = true;
            }            
        } while (invalid == true);
    }

    /**
     * An method to read in an operator from the user
     *
     * @param  
     * @return    the operator
     */    
    public void ReadOpearator() {
        String line;
        boolean invalid;
        do {
            invalid = false;
            System.out.print("Please enter an operator [+-*/]:");
            Scanner inScanner = new Scanner(System.in);
            line = inScanner.nextLine();        
            if (line.equals("+")) {
                operator = '+';
                System.out.println("User enter + operator");
            } else
            if (line.equals("-")) {
                operator = '-';                
                System.out.println("User enter - operator");
            } else
            if (line.equals("*")) {
                operator = '*';                
                System.out.println("User enter * operator");
            } else
            if (line.equals("/")) {
                operator = '/';                
                System.out.println("User enter / operator");
            }        
            else {
                System.out.println("User enter invalid operator");
                operator = ' ';                
                invalid = true;
            }
        } while (invalid == true);
    }

    /**
     * An method to print menu to the user
     *
     * @param  
     * @return    the sum of x and y
     */
    public void PrintMenu() {
        //have a menu loop
        // inside the loop
        // - print out 3 menu options and allow users to select the options by inuting numbers from 1-3
        // - quit the menu if users press Q or q.
        int key = 0;
        boolean quit = false;

        while (!quit) {
            try {
                key = System.in.read();
            } catch (Exception e) {
            }

            if (key == 49) { //1
                System.out.println ("turn on the calculator");

            } else
            if (key == 50) { //2
                System.out.println ("turn off the calculator");

            } else
            if (key == 51) { //3
                System.out.println ("please enter your formula");

            }
            if ((key == 113) || (key == 81)) { //qQ
                quit = true;
            }            
        }
    }

    /**
     * An method to perform addition operation
     *
     * @param  
     * @return    the sum of x and y
     */
    public double Addition() {
        //perform the clculation
        double result;
        result = first_number + second_number;
        screen = "The result of the addition is: " + result;
        return result;
    }

    /**
     * An method to perform subtraction operation
     *
     * @param  
     * @return    the sum of x and y
     */
    public double Subtraction() {
        //perform the clculation
        double result;
        result = first_number - second_number;
        screen = "The result of the subtraction is: " + result;
        return result;
    }

    /**
     * An method to perform division operation
     *
     * @param  
     * @return    the sum of x and y
     */
    public double Division() {
        //perform the clculation
        double result;
        result = first_number / second_number;
        screen = "The result of the division is: " + result;
        return result;
    }

    /**
     * An method to perform multipication operation
     *
     * @param  
     * @return    the sum of x and y
     */
    public double Multiplication() {
        //perform the clculation
        double result;
        result = first_number * second_number;
        screen = "The result of the multipication is: " + result;
        return result;
    }

    /**
     * A method to return the screen value
     * 
     * @param
     * @return screen value
     */
    public void PrintScreen() {
        System.out.println(screen);
    }

    public static void main(String[] arg) {
        sample calc = new sample ();
        calc.ReadOpearator();
        calc.ReadArguments();
        calc.calculate();
        calc.PrintScreen();
    }
}