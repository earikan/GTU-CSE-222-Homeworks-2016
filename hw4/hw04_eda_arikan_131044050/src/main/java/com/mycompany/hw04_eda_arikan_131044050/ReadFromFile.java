package com.mycompany.hw04_eda_arikan_131044050;

import com.mycompany.hw04_eda_arikan_131044050.PostfixEvaluater;
import com.mycompany.hw04_eda_arikan_131044050.Variable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author eda
 */
public class ReadFromFile {

    private File inpfileName;
    private File outfileName;
    private PostfixEvaluater calculate = new PostfixEvaluater();
    StringBuilder myBuilder = new StringBuilder();

    public ReadFromFile(String inp, String out) {

        inpfileName = new File(inp);
        outfileName = new File(out);

    }

    /**
     * dosyadan her seferinde tek satir alinarak assemblye convert ediliyor
     */
    public void readAndEvaluate() {

        int answer = 0;

        String mystring = inpfileName.getAbsolutePath();

        String line = null;
        String temp = "";

        try {
            File file = new File(mystring);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {

                if (line.trim().length() != 0 && !line.equals("\n") && !line.trim().isEmpty()) {
                    calculate.setExpression(line);
                    if (!line.contains("print")) {

                        calculate.deleteDigitRegisters();
                        calculate.eval();

                    } else {
                        String[] tokens = line.split("\\s+");

                        temp = calculate.getVariableRegister(tokens[1]);

                    }
                }
            }
            myBuilder = calculate.getSb();

            myBuilder.append("move $a0,").append(temp).append("\n" + "li $v0,1" + "\n" + "syscall" + "\n");
           // System.out.println(myBuilder);

            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * string builderda tutulan assembly kodu dosyaya yazdiriliyor
     *
     * @throws IOException
     */
    public void writeToFile() throws IOException {

        BufferedWriter output = null;
        try {

            output = new BufferedWriter(new FileWriter(outfileName));
            output.write(myBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (myBuilder.toString() != null) {
                output.close();
            }
        }

    }

}
