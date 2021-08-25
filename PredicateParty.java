package EXERCISE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        List<String> namesRemDoubl = new ArrayList<>(names);
        String input = sc.nextLine();
        while (!input.equals("Party!")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Remove":
                    if(command[1].equals("StartsWith")){
                        String currentSymb = command[2];
                        for (String name : names) {
                           if (name.startsWith(currentSymb)){
                               namesRemDoubl.remove(name);
                           }
                        }
                    } else if(command[1].equals("EndsWith")){
                        String currentSymb = command[2];
                        for (String name : names) {
                            if(name.endsWith(currentSymb)){
                                namesRemDoubl.remove(name);
                            }
                        }
                    } else if(command[1].equals("Length")){
                        int currentSize = Integer.parseInt(command[2]);
                        for (String name : names) {
                            if(name.length() == currentSize){
                                namesRemDoubl.remove(name);
                            }
                        }
                    }
                    names = new ArrayList<>(namesRemDoubl);
                    break;
                case "Double":
                    if(command[1].equals("StartsWith")){
                        String currentSymb = command[2];
                        for (String name : names) {
                            if (name.startsWith(currentSymb)){
                                namesRemDoubl.add(name);
                            }
                        }
                    } else if(command[1].equals("EndsWith")){
                        String currentSymb = command[2];
                        for (String name : names) {
                            if(name.endsWith(currentSymb)){
                                namesRemDoubl.add(name);
                            }
                        }
                    } else if(command[1].equals("Length")){
                        int currentSize = Integer.parseInt(command[2]);
                        for (String name : names) {
                            if(name.length() == currentSize){
                                namesRemDoubl.add(name);
                            }
                        }
                    }
                    names = new ArrayList<>(namesRemDoubl);
                    break;
            }
            input = sc.nextLine();
        }
        if(!namesRemDoubl.isEmpty()){
            namesRemDoubl = namesRemDoubl.stream().sorted().collect(Collectors.toList());
            String joinedString = namesRemDoubl.stream()
                    .collect(Collectors.joining(", "));
            System.out.println(joinedString + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }

    }
}
