import java.lang.System;
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * This is a course project of a simple calculator which proform 
 * basic calculation
 * 
 * @Author (Qiang Wang )
 * @Version (1.5 / 09-08-2021)
 */
public class Calculator{
    private String screen;
    private double first_number;
    private double second_number;  
    private char operator;
    private int menu;
    /**
     * Constructor for objects of class Calculator
     */

    public Calculator()
    {
         
    }
    
    
    public void PrintMenu(){
     boolean quit = false;
     try {
            System.out.println("Welcome to PROG5001 calculator:");
            System.out.println("*****************************************");
            System.out.println("Type 1 and press enter to perform basic calculation");
            System.out.println("Type 2 and press enter to calculate the sum of N integers (N<5)");
            System.out.println("Type 3 and press enter to calculate the factorial of the first N integers (N<10)");
            System.out.println("*****************************************");
            System.out.println("Your choice:");
        while (quit==false){

            int key = System.in.read();
    
            if (key == 49){
                System.out.println("Your choic: 1");
                menu = '1';
            }else
            
            if (key == 50){
                System.out.println("You have seleted sum of N integers (N<10)");
                menu = '2';
            }else
            
            if (key == 51){
                System.out.println("You have seleted factorial of the first N integers (N<10)");
                menu = '3';
            }else
            
            if (key == 81){ /*Q*/
                quit=true;
                System.out.println("Menu quit");
            }else
            
            if (key == 113){ /*q*/
                quit=true;
                System.out.println("Menu quit"); 
            }else{  
                quit=true;
                //System.out.println("Please input a valid number"); 
            }
        }
        } catch (Exception e) {
            System.out.print("Input Error:" + e.getMessage());
        }
        //selection of Menu.
     switch (menu){
        case '1':
            ReadOperator();
            ReadArgument();
            Calculation();
            PrintScreen();
            PressEnter();
            break;
        case '2': 
            SumArray();
            PressEnter();
            break;
        case '3':
            Factorial();
            PressEnter();
            break;
     }
    }

    /**
     * an method to read in operatior from the user
     * 
     * @return the orperator
     *
     */
    private void ReadOperator(){
         String line;
         boolean invalid;
        do {
        invalid = false;
        System.out.print("Please enter an operator [+, -, *, /]");
        Scanner inScanner= new Scanner(System.in);
        line=inScanner.nextLine();
        //line=JOptionPane.showInputDialog(null,"Please enter an operator [+, -, *, /]");
        
        if (line.equals("+")){
            operator = '+';
            //System.out.println("User input + operator");
            //JOptionPane.showMessageDialog(null,"User input + operator");
        }else
        if (line.equals("-")){
            operator = '-';
            //System.out.println("User input - operator");
            //JOptionPane.showMessageDialog(null,"User input - operator");
        }else
        if (line.equals("*")){
            operator = '*';
            //System.out.println("User input * operator");
            //JOptionPane.showMessageDialog(null,"User input * operator");
        }else 
        if (line.equals("/")){
            operator = '/';
            //System.out.println("User input / operator");
            //JOptionPane.showMessageDialog(null,"User input / operator");
        }else {
            //System.out.println("User enter invalid operator");
            //JOptionPane.showMessageDialog(null,"User enter invalid operator");
            invalid = true;
            }
        } while (invalid == true);
     }
    
    
     
    /* readargument from the user
     * 
     */
    private void ReadArgument(){
        
        boolean invalid;
        do {
            try{
                invalid = false;    
                System.out.println("Input your numbers and Press enter: ");
                Scanner inScanner = new Scanner (System.in);
                first_number = inScanner.nextDouble();
                second_number = inScanner.nextDouble();
                //String a;
                //String b;
                //a = JOptionPane.showInputDialog(null,"Input your numbers and Press enter [X ] ");
                //b = JOptionPane.showInputDialog(null,"Input your numbers and Press enter [Y ] ");
                
                //first_number = Double.parseDouble(a);
                //second_number = Double.parseDouble(b);
                
                //System.out.println("User entered " + first_number +" and "+ second_number);
                //JOptionPane.showMessageDialog(null, "User entered " + first_number +" and "+ second_number);
                
            }catch (Exception e){
                System.out.println("Please enter valid number");
                invalid = true;
        }
         }while (invalid == true);
    }
    
    /**
     * Method for calculation 
     * 
     */
    private void Calculation(){
        switch (operator){
            case '+':
                addition();
                break;
            case '-':
                subtraction();
                break;
            case '*':
                multi();
                break;
            case '/':
                devision();
                break;
        }
    }
    
    /**
     * A method to perform additon operation
     *
     * @param 
     * @return 
     */
    private double addition ()
    {
        //perform the calculation
        double result;
        result = first_number + second_number;
        screen = "The result is: " + result;
        return result;
        
    }
    
    /**
     * A method to perfom subtraction 
     * 
     * 
     */
    private double subtraction ()
    { 
        // perform the calculation
        
        double result;
        result = first_number - second_number; 
        screen = "The result of the subctraction is:" + result;
        return result;
        
    }
    
    /**
     * A method for multi
     * 
     * return the sum of x and y
     */
     private double multi(){
         //proform the multi
         double result;
         
         result = first_number * second_number;
         screen = "The result of multiplication is: "+result;
         return result;
     }
     
    /**
     * A method of devision
     * 
     * return devison result
     */
    private double devision(){
        //proform devison
        double result;
        result = first_number / second_number;
        screen = ("The result of devision is: " + result);
        return result;
    }
    
    /**
     * Sum of 10 integer <10
     * 
     */
    
    private void SumArray(){
        System.out.println("Input N and press enter:");
        Scanner numScan = new Scanner(System.in);
        int size = numScan.nextInt();
        int numArray [] = new int [size]; //decide size
        
        //input the array
        try{
        for (int i = 0; i<size; i++){
            System.out.print("Input your first number and press enter"+ (i+1)+":");
            numArray[i]= numScan.nextInt();
            
        }
        
        //print out the array
        int sum = 0;
        for (int i=0; i<size; i++){
             sum= sum+numArray[i];
        }
        System.out.println("The result is:"+sum);
        System.out.println("Press enter to continue");

        } catch (Exception x){
            System.out.println("please input a valid int number");
        }
    }

    private void Factorial (){
        Scanner facScan = new Scanner(System.in);
        System.out.print("Input N and press enter: ");
        int n= facScan.nextInt();
        long result = 1;
            for (int i = 1; i <= n; i++){
                result = result * i;
                
            }
        System.out.println("the factorial of " + n + " is " + result);
    }

    public void PressEnter(){
        System.out.print("Press Enter to continue");
        
        try
        {
            int key = System.in.read();
                System.out.print (key);
                if (key == 10){
                    System.out.print("\f");
                    PrintMenu();

                }else 
                    System.out.print ("Press Enter !");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    /**
     * A method to return the screen value 
     * @param 
     * @return screen value
     */
    private void PrintScreen(){
        System.out.println(screen);        
        //JOptionPane.showMessageDialog(null,screen);
        
    }
    

    
    
    public static void main (String[] args){
        Calculator calc = new Calculator();
        calc.PrintMenu();
    
    }
    }

        
    
