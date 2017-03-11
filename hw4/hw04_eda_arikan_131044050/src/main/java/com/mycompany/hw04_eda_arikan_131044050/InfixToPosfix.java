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
public class InfixToPosfix {

    private Stack<Character> operatorStack;
    private static final String OPERATORS = "+-*/=";
    private static final int[] PRECEDENCE = {1, 1, 2, 2, 0};
    private StringBuilder postfix;

    /**
     * infix ifademiz postfixe cevriliyor
     *
     * @param infix gelen string ifademiz
     * @return String
     * @throws SyntaxException
     */
    public String convert(String infix) throws SyntaxException {
        operatorStack = new Stack<>();
        postfix = new StringBuilder();

        String[] tokens = infix.split("\\s+");

        try {
            for (String nextToken : tokens) {

                char firstChar = nextToken.charAt(0);

                if (Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar)) {
                    postfix.append(nextToken);
                    postfix.append(' ');
                } else if (isOperator(firstChar)) {
                    processOperator(firstChar);

                } else {
                    throw new SyntaxException("unexpected char encountered: " + firstChar);
                }
            }

            while (!operatorStack.empty()) {

                char op = operatorStack.pop();
                postfix.append(op);
                postfix.append(' ');

            }

            return postfix.toString();

        } catch (EmptyStackException ex) {
            throw new SyntaxException("stack is empty ");
        }

    }

    /**
     * islem onceligine gore operatorler duzenleniyor
     *
     * @param op char tipinde operator
     */
    private void processOperator(char op) {
        if (operatorStack.empty()) {
            operatorStack.push(op);
        } else {

            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push(op);

            } else {
                while (!operatorStack.empty() && precedence(op) <= precedence(topOp)) {
                    operatorStack.pop();
                    postfix.append(topOp);
                    postfix.append(' ');
                    if (!operatorStack.empty()) {
                        topOp = operatorStack.peek();
                    }

                }
                operatorStack.push(op);
            }

        }

    }

    /**
     * girilen char operator mu
     *
     * @param ch char tipinde operator
     * @return
     */
    private boolean isOperator(char ch) {

        return OPERATORS.indexOf(ch) != -1;

    }

    /**
     * islem onceligi kontrol ediliyor
     *
     * @param op
     * @return int
     */
    private int precedence(char op) {

        return PRECEDENCE[OPERATORS.indexOf(op)];

    }

}
