
/** 
 * Simple calculator class to perform basic calculation.
 *
 * @author :Vinh Bui
 * @version:1.0/13.07.21
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class ArrayLi
{
    private double result;
    private double first_number;
    private double second_number;
    private char operator;

    /**
     * Constructor for objects of class Calclator
     */
    public Calculator() {
        // initialise instance variables
        first_number= 0;
        second_number= 0;
        result = 0;
        operator = ' ';
    }

    /**
     * Method to perform the calculation
     */
    private void Calculate() {
        switch (operator) {
            case '+':
            result = first_number + second_number;
            break;
            case '-':
            result = first_number - second_number;
            break;
            case '*':
            result = first_number * second_number;
            break;
            case '/':
            result = first_number / second_number;
            break;            
        }
    }

    /**
     * An method to read in an operator from the user input
     *
     * @param  none
     * @return none
     */    
    private void ReadOpearator() {
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
     * An method to read in arguments from the user
     *
     * @param  none
     * @return none   
     */    
    private void ReadArguments() {
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
     * Class to represent a student from file
     */
    class Student {
        String name;
        int id;
    }

    /**
     * Method to read and process students from file (ArrayList version)
     */
    private void readStudentList() {
        ArrayList<Student> studentList = null;
        File studentFile;
        String line = null;
        try {
            studentList = new ArrayList<Student>();           
            studentFile = new File("students.txt");
            Scanner inScanner = new Scanner(studentFile);
            while (inScanner.hasNextLine()) {
                try {
                    line = inScanner.nextLine();
                    //System.out.println(line);
                    Scanner lineScanner = new Scanner(line).useDelimiter(",");
                    Student student = new Student();
                    student.name = lineScanner.next();
                    student.id = lineScanner.nextInt();
                    studentList.add(student);
                }
                catch (java.util.InputMismatchException ex1) {
                    System.out.println("error in the input format: " + line);
                }
                catch (java.util.NoSuchElementException ex2) {
                    System.out.println("error in the input format: " + line);                    
                }                    
            }
        } catch (IOException ex) {
            System.out.println("Errors during the file reading process");
        } finally {
            System.out.println("------------------------------");
            //studentList.forEach(student -> System.out.println(student.name + " : " + student.id));

            Iterator<Student> studentIter = studentList.iterator();
            int i = 0;
            while (studentIter.hasNext()) {
                System.out.print((i + 1) + " : ");
                Student student = studentIter.next();
                System.out.print(student.name + " : ");
                System.out.print(student.id);
                System.out.println();                
                i++;
            }

            //improved for loop
            for (Student student: studentList) {
                System.out.print((i + 1) + " : ");
                System.out.print(student.name + " : ");
                System.out.print(student.id);
                System.out.println();
            }

        }
    }

    /**
     * Method to read and process students from file (array version)
     */
    private void readStudentList_Array() {
        String[] studentNames = null;
        int[] studentIDs = null;
        File studentFile;
        byte index = 0;
        String line = null;
        try {
            studentNames = new String[25];           
            studentIDs = new int[25];                       
            studentFile = new File("students.txt");
            Scanner inScanner = new Scanner(studentFile);
            while (inScanner.hasNextLine()) {
                try {
                    line = inScanner.nextLine();
                    //System.out.println(line);
                    Scanner lineScanner = new Scanner(line).useDelimiter(",");
                    Student student = new Student();
                    studentNames[index] = lineScanner.next();
                    studentIDs[index] = lineScanner.nextInt();
                    index++;
                }
                catch (java.util.InputMismatchException ex1) {
                    System.out.println("error in the input format: " + line);
                }
                catch (java.util.NoSuchElementException ex2) {
                    System.out.println("error in the input format: " + line);                    
                }                    
            }
        } catch (IOException ex) {
            System.out.println("Errors during the file reading process");
        } finally {
            System.out.println("------------------------------");
            for (int i = 0; i < index; i++) {
                System.out.print((i + 1) + " : ");
                System.out.print(studentNames[i] + " : ");
                System.out.print(studentIDs[i]);
                System.out.println();
            }

        }
    }

    /**
     * A method to print results to screen
     * 
     * @param   none
     * @return  none
     */
    private void PrintResult() {

    }

    /**
     * An method to print menu to the user
     *
     * @param  
     * @return    the sum of x and y
     */
    public void ShowMenu() {
        //have a menu loop
        // inside the loop
        // - print out 3 menu options and allow users to select the options by inuting numbers from 1-3
        // - quit the menu if users press Q or q.
        int key = 0;
        boolean quit = false;

        while (!quit) {
            System.out.println();
            System.out.print("Select a menu option [1,2,3]:");
            try {
                key = System.in.read();
            } catch (Exception e) {
            }

            if (key == 49) { //1
                System.out.println ("run 1");

            } else
            if (key == 50) { //2
                System.out.println ("run 2");

            } else
            if (key == 51) { //3
                System.out.println ("run 3");

            }
            if ((key == 113) || (key == 81)) { //qQ
                quit = true;
            }            
        }
    }

    public static void main(String[] arg) {
        Calculator calc = new Calculator ();
        //calc.ShowMenu();
        calc.readStudentList();
        /*
        calc.ReadOpearator();
        calc.ReadArguments();
        calc.calculate();
        calc.PrintScreen();
         */
    }
}