
/** 
 * Simple calculator class to perform basic calculation.
 *
 * @author :Vinh Bui
 * @version:1.0/13.07.21
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class SimpleCalc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SimpleCalc extends JFrame implements ActionListener {
    JTextField display; //calculator's display
    JButton[] buttons;
    JButton backSpace;
    String[] buttonNames = {"1","2","3","4","5","6","7","8","9","0",".","CE"};
    String[] buttonCommands = {"CMD_1","CMD_2","CMD_3","CMD_4","CMD_5",
        "CMD_6","CMD_7","CMD_8","CMD_9","CMD_0","CMD_DOT","CMD_CE"};
    /**
     * Constructor for objects of class SimpleCalc
     */
    public SimpleCalc(){
        // initialise instance variables
        super("My Simple Calculator");
        setSize(400, 400);
        CreateCalcGUI();
    }

    /**
     * A method to set up the GUI
    */
    private void CreateCalcGUI() {
        //
        JPanel panelTop = new JPanel();
        panelTop.setBackground(Color.gray);
        GridLayout panelTopLayout = new GridLayout(0,1);
        panelTop.setLayout(panelTopLayout);
        //
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(Color.blue);        
        GridLayout panelCenterLayout = new GridLayout(4,3);
        panelCenterLayout.setHgap(10);
        panelCenterLayout.setVgap(10);
        panelCenter.setLayout(panelCenterLayout);        
        //
        BorderLayout mainLayout = new BorderLayout();
        setLayout(mainLayout);
        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        //create display
        display = new JTextField("0");        
        Font displayFont = new Font("SansSerif", Font.BOLD, 24);
        display.setFont(displayFont);
        display.setHorizontalAlignment(JTextField.RIGHT);        
        display.setPreferredSize(new Dimension(100,35));
        panelTop.add(display);
        //create buttons
        buttons = new JButton[12];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(buttonNames[i]);
            buttons[i].setActionCommand(buttonCommands[i]);
            buttons[i].addActionListener(this);
            panelCenter.add(buttons[i]);
        }
        backSpace = new JButton("<<");
        backSpace.addActionListener(this);
        backSpace.setActionCommand("CMD_BSP");
        add(backSpace, BorderLayout.SOUTH);
    }
    
    public void actionPerformed(ActionEvent e) {
        String displayText;
        displayText = display.getText();
        String command = e.getActionCommand();
        if (command.equals("CMD_1")) {
            displayText = displayText + "1";
        } else
        if (command.equals("CMD_2")) {
            displayText = displayText + "2";
        } else
        if (command.equals("CMD_3")) {
            displayText = displayText + "3";
        } else
        if (command.equals("CMD_4")) {
            displayText = displayText + "4";
        } else
        if (command.equals("CMD_5")) {
            displayText = displayText + "5";
        } else
        if (command.equals("CMD_6")) {
            displayText = displayText + "6";
        } else
        if (command.equals("CMD_7")) {
            displayText = displayText + "7";
        } else
        if (command.equals("CMD_8")) {
            displayText = displayText + "8";
        } else
        if (command.equals("CMD_9")) {
            displayText = displayText + "9";
        } else
        if (command.equals("CMD_0")) {
            displayText = displayText + "0";
        } else
        if (command.equals("CMD_DOT")) {
            displayText = displayText + ".";
        } else
        if (command.equals("CMD_CE")) {
            displayText = "";
        } else
        if (command.equals("CMD_BSP")) {
            int len = displayText.length();
            displayText = displayText.substring(0, len-1);
        }        
        display.setText(displayText);
    }
    
    public static void main (String[] args) {
        SimpleCalc calc = new SimpleCalc();
        calc.setVisible(true);
    }
}