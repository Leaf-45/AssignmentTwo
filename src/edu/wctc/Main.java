package edu.wctc;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Maze maze = new Maze();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You found yourself alone in an office building\n" +
                "It would be best to find your way out of here");
        System.out.println("---------------------------------------------------------");
        System.out.println("All inputs must be lower case and they can be the first letter or or word of the " +
                "direction you want to move in or action you want to preform.");
        System.out.println("Actions are: loot, interact and exit is an exception where you must input only x");
        System.out.println("---------------------------------------------------------");
        while (!maze.isFinished())
        {
            System.out.println("You are in " + maze.getCurrentRoomName());
            System.out.println(maze.getCurrentRoomDescription());
            System.out.println("The exits are: " + maze.getCurrentRoomExits());
            String tempInput = scanner.nextLine();
            while (!validation(tempInput.charAt(0)))
            {
                System.out.println("The input is invalid\nPlease try again");
                tempInput = scanner.nextLine();
            }
            char input = tempInput.charAt(0);
            switch (input)
            {
                case 'n', 's', 'e', 'w', 'u', 'd' ->
                        {
                            if (!maze.move(input))
                            {
                                System.out.println("You couldn't go that way!");
                            }
                            else maze.move(input);
                        }
                case 'i' -> System.out.println(maze.interactWithCurrentRoom());
                case 'l' -> System.out.println(maze.lootCurrentRoom());
                case 'x' -> System.out.println(maze.exitCurrentRoom());
                case 'v' -> System.out.println(maze.getPlayerInventory());
            }
        }
        System.out.println("Congratulations for completing the maze!");
        System.out.println("Your final inventory was: " + maze.getPlayerInventory());
        System.out.println("Your total points was: " + maze.getPlayerScore());

    }
    static boolean validation(char input)
    {
        boolean valid = false;
        char[] validInputs = {'n', 's', 'e', 'w', 'u', 'd', 'i','l','x','v'};
        for (char tempInput : validInputs)
        {
            if (input == tempInput) {
                valid = true;
                break;
            }
        }
        return valid;
    }
}
