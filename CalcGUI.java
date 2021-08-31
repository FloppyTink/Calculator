import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class CalcGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CalcGUI extends JFrame   
{
    // instance variables - replace the example below with your own
    JPanel calcPanel;
    JPanel calcDia;
    
    JTextField textField;
    
    JButton numOne,numTwo,numThree,numFour,numFive,numSix,numSeven,numEight,numNigh,numZero;
    
    /**
     * Constructor for objects of class CalcGUI
     */
    public CalcGUI()
    {
        super ("My PROG5001 - Calculator (1.0)");
        setLayout(null);

        //set Container
        calcPanel = new JPanel();
        calcPanel.setLayout(null);
        calcPanel.setSize(500,600);
        calcPanel.setBackground(Color.gray);
        calcPanel.setLocation(0,0);
        add(calcPanel);
        
        //Number dialog
        calcDia = new JPanel ();
        calcDia.setLayout(null);
        calcDia.setSize(250,350);
        calcDia.setBackground(Color.white);
        calcDia.setLocation(5,60);
        calcPanel.add(calcDia);

        //add TextField
        textField = new JTextField();
        textField.setSize(450,30);
        textField.setLocation(10,20);
        textField.setBackground(Color.gray);
        textField.setBorder(BorderFactory.createLineBorder(Color.black));
        add(textField);
        
        //Set Buttons
        numOne = new JButton("1");
        numOne.setBackground(Color.gray);
        numOne.setSize(50,50);
        numOne.setLocation(10,10);
        
        calcDia.add(numOne);
        
        
        //initialise instance variables
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,600));
        pack();
    }
    
    public static void main (String[] args){
        CalcGUI panel = new CalcGUI();
        panel.setVisible(true);
    }

    }

