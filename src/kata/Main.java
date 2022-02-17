package kata;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean active = true;
        System.out.println("EIGER TERMINAL 2-15-2022");

        while(active) {
            Scanner EIGER = new Scanner(System.in);
            String command = EIGER.nextLine();
            EIGER(command);
        }
    }

    static HashMap<String, Integer> storage = new HashMap<>();

    public static void EIGER(String command) {
        try {
            String[] commandSplit = command.split(" ");
            char[] charArr = commandSplit[2].toCharArray();
            if (commandSplit[0].equals("define") && isCompatibleValue(Integer.parseInt(commandSplit[1])) && isEIGERCompatible(charArr)) {
                storage.put(commandSplit[2], Integer.parseInt(commandSplit[1]));
            }
            if (commandSplit[0].equals("eval")) {
                Object value = eval(commandSplit);
                if (value == null) {
                    System.out.println("undefined");
                } else {
                    System.out.println(value);
                }
            }
        }
        catch (Exception e){
            System.out.println("Invalid");
        }
    }

    public static Object eval(String[] commandSplit) {
        try {
            int leftHandValue = storage.get(commandSplit[1]);
            int rightHandValue = storage.get(commandSplit[3]);
            String operator = commandSplit[2];

            if (Objects.equals(operator, "<")) {
                if (leftHandValue < rightHandValue) return true;
            }
            if (Objects.equals(operator, ">")) {
                if (leftHandValue > rightHandValue) return true;
            }
            if (Objects.equals(operator, "=")) {
                return leftHandValue == rightHandValue;
            }
            return false;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static boolean isEIGERCompatible(char[] charArr) {
        if (charArr.length > 20) return false;
        for (char c : charArr) {
            if(Character.isUpperCase(c)){
                System.out.println("Invalid");
                return false;
            }
        }
        return true;
    }

    public static boolean isCompatibleValue(int commandValue) {
        if (commandValue > 10000) {
            System.out.println("Invalid");
            return false;
        }
        if (commandValue < -10000) {
            System.out.println("Invalid");
            return false;
        }
        return true;
    }
}
