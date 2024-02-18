package com.sgic.java.util.Task2.entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.sgic.java.util.Task2.Task2Application;
import org.springframework.boot.SpringApplication;


public class email {
    public static String valEmail(String input) {
        String emailRegex = "^[a-zA-Z0-9_+.-]+@[a-zA-Z0-9.-]+\\.com";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(input);

        if (matcher.matches()) {
            return "Email is Valid";
        } else {
            return "Email is Invalid";
        }
    }
    public static void checkString(String name) {
            if (name != null && !name.isEmpty()) {
                System.out.println("The name entered is: " + name);
            } else {
                System.out.println("Name is null or empty");
            }

    }

    public static Date convertStringToDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("date format error");
            throw new RuntimeException(e);
        }
    }
    public static <T extends Number> double add(T num1, T num2) {
        double result = num1.doubleValue() + num2.doubleValue();
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String email = "abi@yahoo.com";
        System.out.println(valEmail(email));

        checkString("h");
            System.out.println("Enter a Valid String Date:");
            String dateInput = input.nextLine();
            Date convertDateFormat = convertStringToDate(dateInput);
            if (convertDateFormat != null) {
                System.out.println("Converted Date: " + convertDateFormat);
            } else {
                System.out.println("Error converting the date.");
            }
        int intResult = (int) add(5, 10);
        double doubleResult = add(3.5, 2.5);

        System.out.println("Integer Result: " + intResult);
        System.out.println("Double Result: " + doubleResult);
    }
}

