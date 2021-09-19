
/**
 * Write a description of class Infix2Postfix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Infix2Postfix
{
    // instance variables - replace the example below with your ow

    /**
     * Constructor for objects of class Infix2Postfix
     */
    public Infix2Postfix()
    {
        // initialise instance variables
    }
    
    private boolean isOperator(char c){
        switch (c){
            case'+':
            case'-':
            case'*':
            case'/':
                return true;
                break;
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String convert(String infix){
        Stack<Character> stack = new Stack();
        String postfix = "";
        for (int i =0; i<infix.length();i++){
        char c = infix.charAt(i);
        if (isOperator(c)){
            //operator
        } else
        if (c == '('){
            //left parenthesis
            stack.push(c);
        }else
        if (c == ')'){
            //right parenthesis
            while (!stack.isEmpty()&&stack.peek()!='('){
                postfix=postfix+stack.pop();
            }
            stack.pop();//take out the left parathesis from the stack
        }else {
            //operand
            postfix = postfix + c;
        }
    }
    return postfix;
}
/**
public static void main(String [] args){
    Infix2Postfix i2p = new Infix2Postfix();
    String expression = "1+(2-3)";
    String postfix = i2p.convert(expression);
    System.out.println(postfix);
}
}
*//