package org.example;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calc(reader.readLine()));
        reader.close();
    }

    public static String calc(String input) throws Exception {
        List<String> ints = List.of("1","2","3","4","5","6","7","8","9","10");
        List<String> rim = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

        String[] array = input.split(" ");
        if(array.length != 3) throw new Exception("Wrong input");

        if(ints.contains(array[0]) && ints.contains(array[2])){
            return doCalc(array);
        }
        else if (rim.contains(array[0]) && rim.contains(array[2])) {
            array[0] = Integer.toString(romanToNumber(array[0]));
            array[2] = Integer.toString(romanToNumber(array[2]));;
            int result = Integer.parseInt(doCalc(array));
            if(result >= 0){
                return convertNumToRoman(result);
            }
            else throw new Exception("Roman result cant be negative");
        }
        else {
            throw new Exception("Wrong input");
        }
    }
    static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }

    static int romanToNumber (String roman) throws Exception {
        switch (roman){
            case ("I"): return 1;
            case ("II"): return 2;
            case ("III"): return 3;
            case ("IV"): return 4;
            case ("V"): return 5;
            case ("VI"): return 6;
            case ("VII"): return 7;
            case ("VIII"): return 8;
            case ("IX"): return 9;
            case ("X"): return 10;
            default: throw new Exception("Wrong Input");
        }
    }

    static String doCalc(String[] array) throws Exception {
        switch (array[1]){
            case ("+"): return Integer.toString(Integer.parseInt(array[0]) + Integer.parseInt(array[2]));
            case ("-"): return Integer.toString(Integer.parseInt(array[0]) - Integer.parseInt(array[2]));
            case ("*"): return Integer.toString(Integer.parseInt(array[0]) * Integer.parseInt(array[2]));
            case ("/"): return Integer.toString(Integer.parseInt(array[0]) / Integer.parseInt(array[2]));
            default: throw new Exception("Wrong input");
        }
    }
}