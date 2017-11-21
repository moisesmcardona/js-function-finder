/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionCheck;

import java.util.*;
import java.text.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author cardona_76937
 */
public class codeAnalyzer {

    String FileDirectory = "C:\\files\\";

    public String codeAnalyze(String name, String code) {
        String CodeOk = "0";
        int HistoryNumber = 0;
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy - hh-mm-ss");
        String DateNow = ft.format(dNow);
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FileDirectory + name + "_history1", true)))) {
            out.println(DateNow);
            out.close();

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
            CodeOk = String.valueOf(e);
        }
        try {
            BufferedReader in = new BufferedReader(new FileReader(FileDirectory + name + "_history2"));
            String str;
            while ((str = in.readLine()) != null) {
                HistoryNumber = Integer.parseInt(str);
            }
            HistoryNumber++;
            File historyfile2 = new File(FileDirectory + name + "_history2");
            OutputStream outputStream = new FileOutputStream(historyfile2);
            Writer out = new OutputStreamWriter(outputStream);
            out.write(String.valueOf(HistoryNumber));
            out.close();
            File codefile = new File(FileDirectory + name + "_code_" + DateNow);
            OutputStream outputStream2 = new FileOutputStream(codefile);
            Writer out2 = new OutputStreamWriter(outputStream2);
            out2.write(code);
            out2.close();
            //File to write results
            PrintWriter out3 = new PrintWriter(new BufferedWriter(new FileWriter(FileDirectory + name + "_results_" + DateNow, true)));
            //Regular Expression Matching Code
            Pattern regex = Pattern.compile("\\s*function\\s\\w+\\(.*\\)(.*)", Pattern.DOTALL);
            // Pattern regex = Pattern.compile("\\s*function\\s+(.*)", Pattern.DOTALL);
            BufferedReader codein = new BufferedReader(new FileReader(FileDirectory + name + "_code_" + DateNow));
            String codeinstr;
            int line = 1;
            int found = 0;
            while ((codeinstr = codein.readLine()) != null) {
                Matcher regexMatcher = regex.matcher(codeinstr);
                if (regexMatcher.find()) {
                    out3.println("Function found at line " + String.valueOf(line) + ": " + regexMatcher.group(0));
                    found = 1;
                }
                line++;
            }
            if (found == 0) {
                out3.println("No matches found for the inserted code");
            }
            out3.close();
        } catch (IOException e) {
            CodeOk = String.valueOf(e);
        }
        CodeOk = DateNow;
        return CodeOk;
    }

}
