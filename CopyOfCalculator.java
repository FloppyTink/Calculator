import java.lang.System;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This is a course project of a simple calculator which proform 
 * basic calculation
 * 
 * @Author (Qiang Wang )
 * @Version (1.3 / 27-07-2021)
 */
public class CopyOfCalculator{
    private String screen;
    private double first_number;
    private double second_number;  
    private char operator;
    private int menu;
    class Student{
        String name;
        int id;
    }
    /**
     * Constructor for objects of class CopyOfCalculator
     */

    public CopyOfCalculator()
    {
         
    }
    
    
    /*
     * implement array in for-loop and while-loop. 
     * 
     */public void readStudentList(){
        String [] studentName =null;
        int[] studentIDs = null;
        File studentFile;
        byte index =0;
        String line = null;
        try{
            studentName = new String[25];
            studentIDs =new int[25];
            studentFile = new File("students.txt");
            Scanner inScanner = new Scanner(studentFile);
            index=0;
            for (int i = 0; i<25;i++){
                if(inScanner.hasNextLine()){
                    line = inScanner.nextLine();
                    //System.out.println(line);
                    Scanner lineScanner = new Scanner(line).useDelimiter(","); //readin the lines
                    //System.out.println(lineScanner);
                    studentName[i]=inScanner.next();
                    //System.out.println(studentName[i]);
                    studentIDs[i]=inScanner.nextInt();
                    //System.out.println(studentIDs[i]);
                    index++;
                }
            }
        }catch (IOException ex){
            System.out.println("Errors during the filereading process");
        }finally{ 
            System.out.println("-----------------------------------------");
            for (int i = 0; i <index; i++){
                System.out.print((i+1)+":");
                System.out.print(studentName[i]+":");
                //System.out.print(studentIDs[i]);
                System.out.println();
            }
        }
    }
    
    
    /*Implement ArrayList in for-loop and while-loop
     * 
     */

    public void readArrayList(){
        ArrayList<Student> studentList = null;
        File studentFile;
        String line =null;
        try{
            studentList =new ArrayList<Student>();
            studentFile = new File("students.txt");
            Scanner inScan = new Scanner(studentFile);
            while (inScan.hasNextLine()){
                try{
                    line = inScan.nextLine();
                    Scanner scanLine = new Scanner(line).useDelimiter(",");
                    Student student = new Student();
                    student.name = scanLine.next();
                    student.id = scanLine.nextInt();
                    studentList.add(student);
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
            for (int i = 0; i <studentList.size(); i++){
                System.out.print((i+1)+":");
                Student student = studentList.get(i);
                System.out.print(student.name+":");
                System.out.print(student.id);
                System.out.println();
            }
        }
    }

    
    public static void main (String[] args){
        CopyOfCalculator calc = new CopyOfCalculator();
        
        calc.readStudentList();
        calc.readArrayList();
    
    }
}

        
    
