package edu.wctc;

import java.util.Scanner;

public class Main {
    private static Maze maze;

    public static void main(String[] args) {
        maze = new Maze();
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Welcome to Zerk.\nType 'h' for help.\n");
            // Main game loop
            while (!maze.isFinished()) {
                // Each step prints the name of the room the player is in.
                System.out.println("≡≡ %s ≡≡".formatted(maze.getCurrentRoomName()));
                // And executes the look command if it is the first time the room is visited.
                System.out.println(maze.isFirstVisit() ? maze.getCurrentRoomDescription() : "");
                // The player can then input a command which is passed to the processInput method.
                System.out.println(processInput(keyboard.nextLine()));
            }
            // maze.finishGame() sets maze.isFinished true to exit the loop when the player types quit or x while in the exit room.
            System.out.println("| Game Over | %s | %S |".formatted(maze.getPlayerScore(), maze.getPlayerActions()));
        }
    }

    // Process user input
    private static String processInput(String input) {
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
                    i - inventory
                    
                    quit - give up""";
            case "look" -> maze.getCurrentRoomDescription();
            case "use" -> maze.interactWithCurrentRoom();
            case "take" -> maze.lootCurrentRoom();
            case "x" -> maze.exitCurrentRoom();
            case "i" -> maze.getPlayerInventory();
            case "quit" -> maze.finishGame();
            default -> "Invalid input.";
        };
    }
}
