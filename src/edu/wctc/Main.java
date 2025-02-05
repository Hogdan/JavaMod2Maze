package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze();
        try (Scanner keyboard = new Scanner(System.in)) {
            String input;
            System.out.println("Welcome to Zerk.\nType 'h' for help.\n");
            // Main game loop
            while (!maze.isFinished()) {
                System.out.println(maze.getCurrentRoomName());
                System.out.println(maze.isFirstVisit() ? maze.getCurrentRoomDescription() : "");
                input = keyboard.nextLine();
                System.out.println(processInput(maze, input));
            }
            System.out.println("Game Over " + maze.getPlayerScore());
        }
    }

    // Process user input
    private static String processInput(Maze maze, String input) {
        return switch (input.toLowerCase()) {
            case "n" -> maze.move('n');
            case "s" -> maze.move('s');
            case "e" -> maze.move('e');
            case "w" -> maze.move('w');
            case "u" -> maze.move('u');
            case "d" -> maze.move('d');
            case "h" -> """
                    Available commands:
                    look, use, take
                    n e s w u d - move
                    x - exit
                    i - inventory""";
            case "look" -> maze.getCurrentRoomDescription();
            case "use" -> maze.interactWithCurrentRoom();
            case "take" -> maze.lootCurrentRoom();
            case "x" -> maze.exitCurrentRoom();
            case "i" -> maze.getPlayerInventory();
            case "c" -> maze.getPlayerScore();
            default -> "Invalid input.";
        };
    }
}
