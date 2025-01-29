package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze();
        try (Scanner keyboard = new Scanner(System.in)) {
            String input;

            System.out.println("Welcome to the maze!");
            while (!maze.isFinished()) {
                System.out.println(maze.getCurrentRoomDescription());
                System.out.println("You can move: " + maze.getCurrentRoomExits());
                System.out.println("What would you like to do?");
                input = keyboard.nextLine();
                switch (input) {
                    case "n" -> maze.move('n');
                    case "s" -> maze.move('s');
                    case "e" -> maze.move('e');
                    case "w" -> maze.move('w');
                    case "u" -> maze.move('u');
                    case "d" -> maze.move('d');
                    case "i" -> System.out.println(maze.interactWithCurrentRoom());
                    case "l" -> System.out.println(maze.lootCurrentRoom());
                    case "x" -> System.out.println(maze.exitCurrentRoom());
                    case "v" -> System.out.println(maze.getPlayerInventory());
                }
            }
            System.out.println(maze.getPlayerScore() + " points!");
        }
    }

}
