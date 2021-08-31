import java.lang.System;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * This is a course project of a simple calculator which proform 
 * basic calculation
 * 
 * @Author (Qiang Wang )
 * @Version (1.3 / 27-07-2021)
 */
public class CopyOfCopyOfCalculator{
    private String screen;
    private double first_number;
    private double second_number;  
    private char operator;
    private int menu;
    /**
     * Constructor for objects of class CopyOfCopyOfCalculator
     */

    public CopyOfCopyOfCalculator()
    {
         
    }
    
    public void readStudentList(){
        String [] studentName =null;
        int[] studentIDs = null;
        File studentFile;
        byte index =0;
        String line = null;
        try{
            studentName = new String[25];
            studentIDs =new int[25];
            index = 0;
            studentFile = new File("students.txt");
            Scanner inScanner = new Scanner(studentFile);
            while(inScanner.hasNextLine()){
                try{
                    line= inScanner.nextLine();
                    System.out.println(line);
                    Scanner lineScanner = new Scanner(line).useDelimiter(","); //readin the lines
                    //System.out.println(lineScanner);
                    studentName[index]=lineScanner.next();
                    //System.out.println(studentName[index]);
                    studentIDs[index]=lineScanner.nextInt();
                    //System.out.println(studentIDs[index]);
                    index++;
                }
                catch (java.util.InputMismatchException ex1){
                    System.out.println("Error in the input format:" +line);
                }
                catch (NoSuchElementException ex2){
                    System.out.println("error in the input format:" +line);
                }
            }
        }catch (IOException ex){
            System.out.println("Errors during the filereading process");
        }finally{ 
            System.out.println("-----------------------------------------");
            for (int i = 0; i <index; i++){
                System.out.print((i+1)+":");
                System.out.print(studentName[i]+":");
                System.out.print(studentIDs[i]);
                System.out.println();
            }
        }
}
    
    public void printMenu(){
     boolean quit = false;
     try {
            System.out.println("Welcome to PROG5001 calculator:");
            System.out.println("*****************************************");
            System.out.println("Type 1 and press enter to perform basic calculation");
            System.out.println("Type 2 and press enter to calculate the sum of N integers (N<5)");
            System.out.println("Type 3 and press enter to calculate the factorial of the first N integers (N<10)");
            System.out.println("*****************************************");
        while (quit==false){

            int key = System.in.read();
    
            if (key == 49){
                System.out.println("You have seleted basic calculation");
                menu = '1';
            }else
            
            if (key == 50){
                System.out.println("You have seleted sum of N integers (N<5)");
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
                System.out.println("Please enter a valid number");
            }
        }
        } catch (Exception e) {
            System.out.print("Input Error:" + e.getMessage());
        }
    }

    /**
     * method of menu selector 
     * the method will jump to corsponding operations the user selected
     * 
     */
    public void Choice(){
        switch (menu){
            case 1:
                ReadOperator();
                break;
        }
    }
    
    
    /**
     * an method to read in operatior from the user
     * 
     * @return the orperator
     *
     */
    public void ReadOperator(){
         String line;
         boolean invalid;
    do {
        invalid = false;
        //System.out.print("Please enter an operator [+, -, *, /]");
        //Scanner inScanner= new Scanner(System.in);
        //line=inScanner.nextLine();
        line=JOptionPane.showInputDialog(null,"Please enter an operator [+, -, *, /]");
        
        if (line.equals("+")){
            operator = '+';
            //System.out.println("User input + operator");
            JOptionPane.showMessageDialog(null,"User input + operator");
        }else
        if (line.equals("-")){
            operator = '-';
            //System.out.println("User input - operator");
            JOptionPane.showMessageDialog(null,"User input - operator");
        }else
        if (line.equals("*")){
            operator = '*';
            //System.out.println("User input * operator");
            JOptionPane.showMessageDialog(null,"User input * operator");
        }else 
        if (line.equals("/")){
            operator = '/';
            //System.out.println("User input / operator");
            JOptionPane.showMessageDialog(null,"User input / operator");
        }else {
            //System.out.println("User enter invalid operator");
            JOptionPane.showMessageDialog(null,"User enter invalid operator");
            invalid = true;
            }
    } while (invalid == true);
     }
    
    
     
    /* readargument from the user
     * 
     */
    public void ReadArgument(){
        
        boolean invalid;
        do {
            try{
                invalid = false;    
                //System.out.println("Input your numbers and Press enter [X Y] ");
                //Scanner inScanner = new Scanner (System.in);
                //first_number = inScanner.nextDouble();
                //second_number = inScanner.nextDouble();
                String a;
                String b;
                a = JOptionPane.showInputDialog(null,"Input your numbers and Press enter [X ] ");
                b = JOptionPane.showInputDialog(null,"Input your numbers and Press enter [Y ] ");
                
                first_number = Double.parseDouble(a);
                second_number = Double.parseDouble(b);
                
                //System.out.println("User entered " + first_number +" and "+ second_number);
                JOptionPane.showMessageDialog(null, "User entered " + first_number +" and "+ second_number);
                
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
    public void Calculation(){
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
    public double addition ()
    {
        //perform the calculation
        double result;
        result = first_number + second_number;
        screen = "The result of the addition is: " + result;
        return result;
        
    }
    
    /**
     * A method to perfom subtraction 
     * 
     * 
     */
    public double subtraction ()
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
     public double multi(){
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
    public double devision(){
        //proform devison
        double result;
        result = first_number / second_number;
        screen = ("The result of devision is: " + result);
        return result;
    }
    
    
    /**
     * A method to return the screen value 
     * @param 
     * @return screen value
     */
    public void PrintScreen(){
        //System.out.println(screen);
        JOptionPane.showMessageDialog(null,screen);
        
    }
        
    
    
    public static void main (String[] args){
        CopyOfCopyOfCalculator calc = new CopyOfCopyOfCalculator();
        
        //calc.printMenu();
        //calc.Choice();
        //calc.ReadOperator();
        //calc.ReadArgument();
        //calc.Calculation();
        //calc.PrintScreen();
        
        calc.readStudentList();
    
    }
}

        
    
