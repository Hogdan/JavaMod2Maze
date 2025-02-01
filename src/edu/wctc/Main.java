package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Maze maze = new Maze();
        try (Scanner keyboard = new Scanner(System.in)) {
            String input;
            System.out.println("You wake up in a labyrinth.");
            while (!maze.isFinished()) {
                System.out.println("You are in the %s.".formatted(maze.getCurrentRoomName()));
                System.out.println(maze.getCurrentRoomDescription());
                System.out.println("You can move " + maze.getCurrentRoomExits());
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
                    case "p" -> System.out.println(maze.getPlayerLives() + " lives remaining.");}
            }
            System.out.println("You escaped with %s lives!".formatted(maze.getPlayerLives()));
        }
    }
}
