package laba3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner= new Scanner(System.in);

        //input first string
        System.out.print("Input a string: ");
        String s= scanner.nextLine();

        //output results (1st-4th methods)
        System.out.println("The string ends by \"ed\": " + ifHasEdInEnd(s));
        System.out.println("Sum of digits in the string: " + sumDigitsInString(s));
        System.out.println("Biggest block of symbols in the string: " + countLongestBlockLength(s));
        System.out.println("Words in the string: ");
        outputWords(s);

        //input also 2 strings
        System.out.print("Input a first string: ");
        String s1= scanner.nextLine();
        System.out.print("Input a second string: ");
        String s2= scanner.nextLine();

        //output results (5th method)
        System.out.println("Mixed string: " + mixedUpStrings(s1,s2));
    }


    //checks if the string has "ed" in its end
    static boolean ifHasEdInEnd(String s) {
        return s.endsWith("ed");
    }

    //counts summa of digits in the string
    static int sumDigitsInString(String s) {
        int sum=0;
        for (int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                sum+=s.charAt(i)-'0';   //if character is a number, it converts in a number
            }
        }
        return sum;
    }

    //count the longest block of identical symbols in the string
    static int countLongestBlockLength(String s) {
        if (s.length()==0) return 0;

        int maxLength=1;    //length of the longest block
        int k=1;    //temp counter of blocks' length
        for (int i=0; i<s.length()-1; i++) {

            if(s.charAt(i)==s.charAt(i+1)) {    //if next symbol is the same to this, counter increased
                    k++;
            }
            else {
                if (maxLength<k) {  //if there is a block end, k is word's length; is it more than maxLength?
                    maxLength=k;
                }
                k=1;
            }
        }
        if (maxLength<k) {
            maxLength=k;
        }

        return maxLength;
    }

    //outputs separated words in the string
    static void outputWords(String s) {
        if (s.length()==0) {
            return;
        }

        int firstSymbol=0;  //first symbol of word
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)==' ') {
                if (i!=0 && s.charAt(i-1)!=' ') //if there is word end, output the word
                {
                    System.out.println(s.substring(firstSymbol,i));
                }
                firstSymbol=i+1;
            }
        }
        if (s.charAt(s.length()-1)!=' ') {  //output last word
            System.out.println(s.substring(firstSymbol));
        }
    }

    //creates mixed string from 2 other strings
    static String mixedUpStrings(String s1, String s2) {
        String s;  //result string
        StringBuilder sb = new StringBuilder();   //string type for cycles and many operations
        for (int i=0; i<s1.length() && i <s2.length(); i++) {
            sb.append(s1.charAt(i));
            sb.append(s2.charAt(i));
        }

        s=sb.toString();

        //if there is end of one of the strings
        if (s1.length() > s2.length()) {
            s+=s1.substring(s2.length());
        }
        else if (s1.length() < s2.length()) {
            s+=s2.substring(s1.length());
        }

        return s;
    }
}