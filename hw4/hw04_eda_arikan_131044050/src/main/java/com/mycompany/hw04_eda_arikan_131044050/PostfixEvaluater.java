/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw04_eda_arikan_131044050;

import java.util.EmptyStackException;
import java.util.Stack;
import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

/**
 *
 * @author eda
 */
public class PostfixEvaluater extends Variable {

    private Stack<String> operatorStack;
    private String expression;
    private static final String OPERATORS = "+-*/=";
    private int i = 0;
    InfixToPosfix postfix = new InfixToPosfix();
    Variable variable = new Variable();
    StringBuilder sb = new StringBuilder();

    /**
     * PostfixEvaluater constuctor
     */
    public PostfixEvaluater() {
        expression = null;
        operatorStack = null;
    }

    /**
     * infix ifadeyi postfize ceviriyor
     *
     * @param infixExpression infix tipte bir string
     */
    public void setExpression(String infixExpression) {

        expression = postfix.convert(infixExpression);

    }

    /**
     * sonucu dosyaya basmak icin kullanilan string builder
     *
     * @return StringBuilder
     */
    public StringBuilder getSb() {
        
        return sb;
        
    }

    /**
     * Evaluate operator, assemblye cevirme islemi burada yapilip string
     * builderda tutuluyor
     *
     * @param op yapilan islem
     * @return String
     */
    private String evalOp(char op) {
        String rhs = operatorStack.pop();
        String lhs = operatorStack.pop();
        int result = 0;

        String rhsValue = "";
        String lhsValue = "";
        int control = 0;
        String var1;
        String var2;
        String myvar = "";
        String temp = "temp";
        String tempNumberFirst = "";
        String tempNUmberSecond = "";

        try {
            if (isVariable(lhs.charAt(0))) {
                if (getVariableRegister(lhs) == null) {
                    lhsValue = addVariable(lhs);
                    if (lhsValue == null) {
                        throw new AssignmentException("A lot of expression. You must use between $t0 and $t8 registers. ");
                    }
                    control = 1;
                } else {
                    lhsValue = getVariableRegister(lhs);
                }
            }

            if (control != 1) {
                if (isVariable(rhs.charAt(0))) {
                    if (getVariableRegister(rhs) == null) {
                        rhsValue = addVariable(rhs);
                        if (rhsValue == null) {
                            throw new AssignmentException("A lot of expression. You must use between $t0 and $t8 registers. ");
                        }
                    } else {
                        rhsValue = getVariableRegister(rhs);
                    }
                }
            }

        } catch (NullPointerException | StringIndexOutOfBoundsException | AssignmentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        try {
            if (Character.isDigit(lhs.charAt(0))) {
                control = 1;
                lhsValue = addVariable(lhs);
                if (lhsValue == null) {
                    throw new AssignmentException("A lot of expression. You must use between $t0 and $t8 registers. ");
                }
                sb.append("li ").append(lhsValue).append(",").append(lhs).append("\n");
            }

            if (control != 1) {
                if (Character.isDigit(rhs.charAt(0))) {
                    rhsValue = addVariable(rhs);
                    if (rhsValue == null) {
                        throw new AssignmentException("A lot of expression. You must use between $t0 and $t8 registers. ");
                    }
                    sb.append("li ").append(rhsValue).append(",").append(rhs).append("\n");
                }
            }

            if (rhs.charAt(0) == '$') {
                rhsValue = rhs;

            }

            if (lhs.charAt(0) == '$') {
                lhsValue = lhs;

            }

        } catch (NullPointerException | StringIndexOutOfBoundsException | AssignmentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        switch (op) {

            
            case '+':
                temp = addTemp("temp");
                sb.append("add ").append(temp).append(",").append(rhsValue).append(",").append(lhsValue).append("\n");
                break;

                
            case '-':
                temp = addTemp("temp");
                sb.append("sub ").append(temp).append(",").append(lhsValue).append(",").append(rhsValue).append("\n");
                break;

                
            case '/':
                try {

                    if (rhs.equals("0")) {
                        throw new DivisionByZeroException("A number can't divide by zero.");
                    }

                    sb.append("div ").append(lhsValue).append(",").append(rhsValue).append("\n" + "mflo ").append(rhsValue).append("\n");
                    temp = rhsValue;

                } catch (DivisionByZeroException e) {
                    System.out.println(e.getMessage());
                    System.exit(1);
                }
                break;

                
            case '*':
                sb.append("mult ").append(lhsValue).append(",").append(rhsValue).append("\n" + "mflo ").append(rhsValue).append("\n");
                temp = rhsValue;
                break;
                
                
            case '=':
                if (variableName.contains(lhs) && control == 1 && isNumeric(rhs)) {
                    myvar = getVariableRegister(lhs);

                    sb.append("li ").append(myvar).append(",").append(rhs).append("\n");

                } else if (!isNumeric(rhs)) {

                    sb.append("move ").append(lhsValue).append(",").append(rhsValue).append("\n");
                    deletebyTemp();
                }
                break;

        }
        control = 0;

        return temp;

    }

    /**
     * girilen string numeric mi kontrol ediliyor
     *
     * @param str
     * @return boolean
     */
    public boolean isNumeric(String str) {
        if (str != null) {
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * postfix cevirme - kitaptaki kodlardan yararlandim
     *
     * @return String
     * @throws SyntaxException
     */
    public String eval() throws SyntaxException {

        operatorStack = new Stack<String>();

        String[] tokens = expression.split("\\s+");

        try {
            for (String nextToken : tokens) {

                char firstChar = nextToken.charAt(0);

                if (Character.isDigit(firstChar) || isVariable(firstChar)) {
                    operatorStack.push(nextToken);

                } else if (isOperator(nextToken.charAt(0))) {
                    String result = evalOp(firstChar);
                    operatorStack.push(result);

                } else {
                    throw new SyntaxException("invalid character");

                }

            }

            String answer = operatorStack.pop();

            if (operatorStack.empty()) {
                return "";
            } else {
                throw new SyntaxException("stack must be empty");
            }
        } catch (EmptyStackException ex) {

            throw new SyntaxException("stack is empty");
        }

    }

    /**
     * girilen karakter operator mu
     *
     * @param ch
     * @return boolean
     */
    public boolean isOperator(char ch) {

        return OPERATORS.indexOf(ch) != -1;

    }

    /**
     * girilen karakter bir variable mi
     *
     * @param ch
     * @return
     */
    public boolean isVariable(char ch) {

        return OPERATORS.indexOf(ch) == -1 && (!Character.isDigit(ch)) && ch != '$';

    }

}
