package org.Unterricht.Uebung.Wordprocessor;

import java.util.Scanner;

public class Wordprocessor {
    /**
     * _xx => XX
     * XX_ => xx
     * _xX_ => xx
     *
     * xY => xY
     * x_y => x_y
     *
     */

    public static String process(String startWord) {
        String[] parts = startWord.split(" ");
        String endString = "";
        for (String part: parts) {
            if (part.startsWith("_") && part.endsWith("_")) {
                endString += part.substring(1, part.length() -1 ).toLowerCase();
            } else if (part.endsWith("_")) {
                endString += part.substring(0, part.length() - 1).toLowerCase();
            } else if (part.startsWith("_")) {
                endString += part.substring(1).toUpperCase();
            } else {
                endString += part;
            }
            endString += " ";
        }

        return endString;
    }

    public static void simulate() {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        //s.close();

        System.out.println(process(input));
    }
}
