import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This is a Java calculater with GUI.
 *
 * @Qiang Wang
 * @1.0
 */
public class CalcGUI extends JFrame implements ActionListener{
    // instance variables
    
    JPanel panelTop,numPanel,panelCenter,funPanel,panelLeft;
    JTextField textField;
    
    
    JButton[] buttons;
    String[] buttonNames={"1","2","3","4","5","6","7","8","9","+/-","0","."};
    String[] buttonCommands = {"CMD_1","CMD_2","CMD_3","CMD_4","CMD_5",
                            "CMD_6","CMD_7","CMD_8","CMD_9","CMD_+/-","CMD_0","CMD_DOT"};
    JButton equalTo;
    
    JButton[] fButtons;
    String[] fButtonNames={"+","<<","-","CE","*","(","/",")","!","OFF",};
    String[] fButtonCommands ={"CMD_+","CMD_BSP","CMD_-","CMD_CE","CMD_*",
                                "CMD_(","CMD_/","CMD_)","CMD_!","CMD_OFF",};
    
    /**
     * Constructor for objects of class CalcGUI
     */
    public CalcGUI()
    {
        super ("My PROG5001 - Calculator (1.0)");
        setSize(400,400);
        CreateCalcGUI();
    }
    
    /**
     * Construction of GUI, add up, center and lower pannel. 
     */
    private void CreateCalcGUI(){
        //Set Panel top
        panelTop = new JPanel();
        GridLayout panelTopLayout = new GridLayout(0,1);
        panelTop.setLayout(panelTopLayout);
        
        
        //add TextField in the container (North)
        textField = new JTextField("");
        Font textFieldFont = new Font("SansSerif", Font.BOLD, 24);
        textField.setFont(textFieldFont);
        textField.setHorizontalAlignment(JTextField.RIGHT);        
        textField.setPreferredSize(new Dimension(100,35));
        panelTop.add(textField);
        
        
        panelCenter=new JPanel();
        GridLayout panelCenterLayout = new GridLayout();
        panelCenter.setLayout(panelCenterLayout);
        
        numPanel = new JPanel();
        numPanel.setBackground(Color.white);
        numPanel.setLayout(new GridLayout(4,3,10,10));//GridLayout(col,rol,ygap,xgay)
        
        buttons=new JButton[12];
        for (int i=0; i<buttons.length;i++){
            buttons[i]=new JButton();
            buttons[i].setText(buttonNames[i]);
            buttons[i].setActionCommand(buttonCommands[i]);
            buttons[i].addActionListener(this);
            numPanel.add(buttons[i]);
        }
        equalTo= new JButton("=");//for equalTo.
        equalTo.addActionListener(this);
        equalTo.setActionCommand("CMD_eq");
        equalTo.setSize(40,100);
        
        panelLeft = new JPanel();
        BorderLayout panelLeftLayout = new BorderLayout(10,10);
        panelLeft.setLayout(panelLeftLayout);
        panelLeft.setBackground(Color.white);
        panelLeft.add(numPanel,BorderLayout.CENTER);
        panelLeft.add(equalTo,BorderLayout.SOUTH);

        
        funPanel = new JPanel();
        funPanel.setBackground (Color.white);
        GridBagLayout funPanelLayout = new GridBagLayout();
        funPanel.setLayout(funPanelLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(6,6,6,6);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx=20;
        gbc.ipady=30;
        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton btnPlus= new JButton("+");
        btnPlus.addActionListener(this);
        btnPlus.setActionCommand("CMD_Plus");
        funPanel.add(btnPlus,gbc);
    
        gbc.gridx = 1;
        gbc.gridy = 0;
        JButton btnBSP = new JButton("<<");
        btnBSP.addActionListener(this);
        btnBSP.setActionCommand("CMD_BSP");
        funPanel.add(btnBSP,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        JButton btnMu = new JButton("-");
        btnMu.addActionListener(this);
        btnMu.setActionCommand("CMD_Mu");
        funPanel.add(btnMu,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        JButton btnCe = new JButton("CE");
        btnCe.addActionListener(this);
        btnCe.setActionCommand("CMD_CE");
        funPanel.add(btnCe,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton btnMult = new JButton("*");
        btnMult.addActionListener(this);
        btnMult.setActionCommand("CMD_Mult");
        funPanel.add(btnMult,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        JButton btnFb = new JButton("(");
        btnFb.addActionListener(this);
        btnFb.setActionCommand("CMD_Fb");
        funPanel.add(btnFb,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton btnDiv = new JButton("/");
        btnDiv.addActionListener(this);
        btnDiv.setActionCommand("CMD_Div");
        funPanel.add(btnDiv,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        JButton btnBf = new JButton(")");
        btnBf.addActionListener(this);
        btnBf.setActionCommand("CMD_Bf");
        funPanel.add(btnBf,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        JButton f= new JButton("!");
        f.addActionListener(this);
        f.setActionCommand("CMD_Fa");
        funPanel.add(f,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        JButton off= new JButton("OFF");
        off.addActionListener(this);
        off.setActionCommand("CMD_OFF");
        funPanel.add(off,gbc);
        
        panelCenter.add(panelLeft);
        panelCenter.add(funPanel);
        
        BorderLayout mainLayout = new BorderLayout(10,10);
        setLayout(mainLayout);
        
        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
    }
    
    /**
     * ActionListener to get button command and action the command. 
     */
    public void actionPerformed(ActionEvent e){
        String displayText;
        displayText = textField.getText();
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
        if (command.equals("CMD_+/-")) {
            displayText =  "-" + displayText;
        } else
        if (command.equals("CMD_0")) {
            displayText = displayText + "0";
        } else
        if (command.equals("CMD_DOT")) {
            displayText = displayText+".";
        } else 
        if (command.equals("CMD_Plus")){
            displayText = displayText+"+";
        } else 
        if (command.equals("CMD_BSP")){
            int len = displayText.length();
            displayText = displayText.substring(0,len-1);
        } else 
        if (command.equals("CMD_Mu")){
            displayText = displayText+"-";
        } else 
        if (command.equals("CMD_CE")){
            displayText = "";
        } else 
        if (command.equals("CMD_Mult")){
            displayText = displayText+"*";
        }else 
        if (command.equals("CMD_Fb")){
            displayText = displayText+"(";
        }else 
        if (command.equals("CMD_Div")){
            displayText = displayText+"/";
        }else 
        if (command.equals("CMD_Bf")){
            displayText = displayText+")";
        }else 
        if (command.equals("CMD_eq")){
            displayText.split(" ");
            //System.out.println(displayText);
            String outExpression = convert(displayText);
            double result = evaluate (outExpression);
            String stringResult = String.valueOf(result);
            displayText = stringResult;
        }else 
        if (command.equals("CMD_Fa")){
            displayText = displayText+"!";
        }else 
        if (command.equals("CMD_OFF")){
            System.exit(0);
        }
        textField.setText(displayText); 
    }
    
    /**
     * evaluate postfix expression, get result from calculations with*,/,! first and +,- last,
     * and return result.
     * @parameters: postfix
     * @return: result
     */
    public double evaluate (String postfix){
        double result = 0;
        Stack<Double> stack = new Stack ();
        for (int i = 0; i<postfix.length();i++){
            char c = postfix.charAt(i);
            if (isOperator (c) > 0){
                double operand2 = Double.parseDouble(""+ stack.pop());
                //if (c == ' '){
                    
                //} else
                if (c == '!'){
                    //double operand1 = Double.parseDouble(""+ stack.pop());
                    //System.out.println(operand1);
                    result = 1;
                    for (i = 1; i<=operand2; i++){
                        result = result *i;
                    }
                } else
                if(c =='+'){
                    double operand1 = Double.parseDouble(""+ stack.pop());
                    result = operand1 + operand2;
                }else 
                if (c == '-'){
                    double operand1 = Double.parseDouble(""+ stack.pop());
                    result = operand1 - operand2;
                }else 
                if (c == '*'){
                    double operand1 = Double.parseDouble(""+ stack.pop());
                    result = operand1 * operand2;
                }else 
                if (c == '/'){
                    double operand1 = Double.parseDouble(""+ stack.pop());
                    result = operand1 / operand2;
                }
                stack.push(result);
                
            } else {
                stack.push(Double.parseDouble(""+ c ));
            }
        }
        result = stack.pop();
        
        return result;
    }
    
    /**
     * Method to select operator, level the operator order.
     * make evaluation do *,/,! first and +,- last.
     */
    private int isOperator(char c){
        switch (c){
            case '+':
            case '-':
                    return 1;
            case '*':
            case '/':
            case '!':
                    return 2;
        }
        return -1;
    }
    
    /**
       * convert expression from infix format to postfix format
       * @param:infix
       * @output: postfix
       */
    public String convert(String infix){
        Stack<Character> stack = new Stack();
        String postfix = "";
        for (int i=0; i<infix.length();i++){
            char c =infix.charAt(i);
            if(isOperator(c)>0){
                //operator
                while (!stack.isEmpty() && (isOperator(c)<= isOperator(stack.peek()))){
                    postfix=postfix + stack.pop();
                    //System.out.println(postfix);
                }
                stack.push(c);
            }else
            if (c =='('){
                //left parenthesis
                stack.push(c); //push to stack
            }else
            if (c == ')'){
                //right parethesis
                while (!stack.isEmpty() && stack.peek() !='('){
                    postfix = postfix + stack.pop();
                }
                stack.pop();
            }else{
                //operand
                postfix = postfix + c;
            }
        }
        
        while (!stack.isEmpty()){
            postfix = postfix + stack.pop();
        }
        //System.out.println(postfix);
        return postfix;
    }
    
    public static void main (String[] args){
        CalcGUI calc = new CalcGUI();
        calc.setVisible(true);
        
        CalcGUI i2p = new CalcGUI ();
        //String postfix = i2p.convert();
        //System.out.println(postfix);
        
    }

    }

