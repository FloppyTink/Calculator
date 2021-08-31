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

public class CalDemo
{
    private double result;
    private double first_number;
    private double second_number;
    private char operator;

    /**
     * Constructor for objects of class Calclator
     */
    public CalDemo() {
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
            } else
            if (line.equals("-")) {
                operator = '-';                
            } else
            if (line.equals("*")) {
                operator = '*';                
            } else
            if (line.equals("/")) {
                operator = '/';                
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
     * A method to print results to screen
     * 
     * @param   none
     * @return  none
     */
    private void PrintResult() {
        System.out.println("Result: " + result);
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
    private void ReadStudentList() {
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
            System.out.println("------------UNSORTED------------------");
            //studentList.forEach(student -> System.out.println(student.name + " : " + student.id));
            int i = 0;
            for (Student student: studentList) {
                System.out.print((i + 1) + " : ");
                System.out.print(student.name + " : ");
                System.out.print(student.id);
                System.out.println();
            }
            /*
            for (int i = 0; i < studentList.size(); i++) {
                System.out.print((i + 1) + " : ");
                Student student = studentList.get(i);
                System.out.print(student.name + " : ");
                System.out.print(student.id);
                System.out.println();                
                
            }
            */
            //sort students based on their ID
            sortStudentList(studentList);
            //Collections.sort(studentList, new StudentComparator());
            //
            System.out.println("---------------SORTED---------------");
            i = 0;
            for (Student student: studentList) {
                System.out.print((i + 1) + " : ");
                System.out.print(student.name + " : ");
                System.out.print(student.id);
                System.out.println();
            }
            
            /*
            for (int i = 0; i < studentList.size(); i++) {
                System.out.print((i + 1) + " : ");
                Student student = studentList.get(i);
                System.out.print(student.name + " : ");
                System.out.print(student.id);
                System.out.println();                
                
            }
            */
            //improved for loop
            /*
            i = 0;       
            System.out.println("------------------------------");
            for (Student student: studentList) {
                System.out.print((i + 1) + " : ");
                System.out.print(student.name + " : ");
                System.out.print(student.id);
                System.out.println();
            }
            */
        }
    }
    
    class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student std1, Student std2) {
            if (std1.id < std2.id)
                return 1;
            else
                return -1;
        }
    }
    
    /**
     * Method to sort students list
     */
    private void sortStudentList(ArrayList<Student> list) {
        int n = list.size();
        for (int i = 0; i < n-1; i++) {
            for (int j=0; j <n-i-1; j++) {
                Student std_i = list.get(j);
                Student std_j = list.get(j+1);
                if (std_j.name.compareTo(std_i.name) < 0) {
                    list.set(j, std_j);
                    list.set(j+1, std_i);
                }
            }
        }
    }
    
    /**
     * Method to read and process students from file (array version)
     */
    private void ReadStudentList_Array() {
        String[] studentNames = null;
        int[] studentIDs = null;
        File studentFile;
        byte index = 0;
        String line = null;
        try {
            studentNames = new String[5];           
            studentIDs = new int[5];                       
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
            String Sreen = "Select a menu option [1,2,3]:\n1. " +
                "Do calculation\n2. Print student list\n3.Quit";
            System.out.println(Sreen);    
            try {
                key = System.in.read();
                //key = inScanner.nextLine();
            } catch (Exception e) {
            }
            switch (key) {
                case 49:  
                    ReadOpearator();
                    ReadArguments();
                    Calculate();  
                    PrintResult();
                case 50:
                    //ReadStudentList_Array();
                    ReadStudentList();
                    break;
                case 51:
                    quit = true;
                    break;
                default:
                    System.out.println("The selected option does not exist!");
            }
        }
    }
   
    public static void main(String[] arg) {
        CalDemo calc = new CalDemo ();
        System.out.print("\f");
        calc.ShowMenu();
    }
}
