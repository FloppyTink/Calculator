import java.lang.System;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This is a course project of a simple calculator which proform 
 * basic calculation
 * 
 * @Author (Qiang Wang )
 * @Version (1.3 / 27-07-2021)
 */
public class SortStudent{
    private String screen;
    private double first_number;
    private double second_number;  
    private char operator;
    private int menu;
    class Student{
        String name;
        int id;
    }
    
    /**Method to sort students list
     * 
     * 
     */
    private void sortStduentList(ArrayList<Student> studentList){
        int n = studentList.size();
        for (int i=0; i<n; i++){
              for(int j = 0; j < n-1; j++){
                  Student std_i = studentList.get(i);
                  Student std_j = studentList.get(j);
                  if (std_j.id > std_i.id){
                      studentList.set(i,std_j);
                      studentList.set(j,std_i);
                  }
              }
        }
    }
    

       
    private int binarySearch(ArrayList<Student> list, String n){
            int l = 0, r= list.size()-1;
            while(l<=r){
                int m = l+(r-1)/2;
                Student std = list.get(m);
                if (std.name.compareTo(n) == 0)
                    return m;
                    
                if (std.name.compareTo(n) < 0)
                    l = m +1;
                else 
                    r = m-1;
        }
        return -1;
    }
    
    private void sortStudentName(ArrayList<Student> studentList){
        int n = studentList.size();
        for (int i = 0; i<n; i++){
            for (int j = 0; j< n-1; j++){
                Student std_i = studentList.get(i);
                Student std_j = studentList.get(j);
                    if (std_j.name.compareTo(std_i.name)>0){
                        studentList.set(j,std_i);
                        studentList.set(i,std_j);
                    }
            }
        }

                
    }
        /*
    class StudentComparator implements Comparator<Student>{
        @Override
        public int compare(Student std1,Student std2){
            if(std1.id<std2.id)
                return 1;
            else
                return -1;
        }
        
    }
    */
    
    
   
    /*
     * implement array in for-loop and while-loop. 
     * 
     */
    private void readStudentList(){
        String [] studentName =null;
        int[] studentIDs = null;
        File studentFile;
        byte index =0;
        String line = null;
        try{
            studentName = new String[25];
            studentIDs =new int[25];
            studentFile = new File("students.txt");
            //Scanner inScanner = new Scanner(studentFile);
            for (int i=0; i<25; i++){
                    //line = inScanner.nextLine();
                    //System.out.println(line);
                    //Scanner lineScanner = new Scanner(line).useDelimiter(","); //readin the lines
                    Scanner inScanner = new Scanner(studentFile).useDelimiter(",");
                    studentName[i]=inScanner.next();
                    studentIDs[i]=inScanner.nextInt();
            }
        }catch (IOException ex){
            System.out.println("Errors during the filereading process");
        }finally{ 
            
            System.out.println("-----------------------------------------");
            for (int i = 0; i <25; i++){
                System.out.print((i+1)+":");
                System.out.print(studentName[i]+":");
                System.out.print(studentIDs[i]);
                System.out.println();
            }
        }
    }
    
    
    /*Implement ArrayList in for-loop and while-loop
     * 
     */

    private void readArrayList(){
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

            System.out.println("-------------unsorted--------------------");
            for (int i = 0; i <studentList.size(); i++){
                System.out.print((i+1)+":");
                Student student = studentList.get(i);
                System.out.print(student.name+":");
                System.out.print(student.id);
                System.out.println();
            }
            //Sort list 
            
            sortStudentName(studentList);
            
            System.out.println("-------------sorted--------------------");
            for (int i = 0; i <studentList.size(); i++){
                System.out.print((i+1)+":");
                Student student = studentList.get(i);
                System.out.print(student.name+":");
                System.out.print(student.id);
                System.out.println();
            }
            
            Scanner scan = new Scanner (System.in);
            String name= scan.nextLine();
            System.out.println(name);
            
            int result = binarySearch(studentList, name);
        
            if (result == -1)
                System.out.println("Element not Present");
            else 
                System.out.println("The Element " + name + " is found at "
                               + "index " + (result+1)); 
        }
    }
    
    /*
    private void inName(){
    Scanner scan = new Scanner (System.in);
    String name= scan.nextLine();
    System.out.println(name);
    }   
    */

    
    
    
    public static void main (String[] args){
        SortStudent calc = new SortStudent();
        calc.readArrayList();
    
        
    }
}

        
    
