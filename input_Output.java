import java.lang.System;
import java.io.IOException;
/**
 * this is a input and output practice  
 *
 * @Qiang Wang
 * @1.0 21/07/2021
 */
public class input_Output
{
    public static void main (String[] args){
        boolean quit = false;
        try {
            while (quit == false){
                System.out.println("Please input your choise");
                int key = System.in.read();
            
                switch (key) {
                    case 49:
                        System.out.println("User Type 1");
                        break;
                    case 50:
                        System.out.println("User Type 2");
                        break;
                    case 51:    
                        System.out.println("User Type 3");
                        break;
                    case 52:
                        System.out.println("User Type 4");
                        break;  
                    case 81:
                        quit = true;
                    case 113:
                        quit = true;
                    default:
                        System.out.println("Seclection Error Type :"+key);
                        break;
            }
        }
            /*
            if (key == 49){
               System.out.println("User Type 1");
            }
            
            if (key == 50){
                System.out.println("User Type 2");
            }
            
            if (key == 51){
                System.out.println("User Type 3");
            }
            else{
                System.out.println("User Type:" + key);
            }
            */
            
        } catch (Exception e) {
            System.out.print("Input Error:" + e.getMessage());
        }
        }
}


