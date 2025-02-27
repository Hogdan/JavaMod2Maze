# Phase 3
I really spent a lot of time on this phase. After I made the riddle and maze it became clearer to me that this was just a text adventure game. I thought it would be fun to make homage to the original Zork so that's what I did. I added Boolean fields to the room class so I could keep track of whether a room had been visited, looted, interacted with or locked. Implementing the traditional lock and key game structure was simple enough I just needed to build the rooms to make up the maze. A lot of time was spent polishing the UI and making it feel like a proper text adventure. I spent way too much time working on this assignment, but it was a fun exercise. The next thing I had planned was to create objects for the inventory items and attempt to parse a two-argument input from the player. This would allow the game to accept commands like “use crowbar” when solving puzzles. The way I built the program allows for easy modification and addition of rooms and items. I hope you manage to beat the game!


# Phase 2
I didn’t quite know which direction to take this project in Phase 2 because I was stuck with the movie Cube in my head. So originally, I was going to have mostly indistinguishable rooms in a large cube, many filled with hidden death traps that could be sprung by throwing a shoe. This is why the rooms are named by color and shoes are the only loot. Lives were originally survivors, like the movie some rooms would have other people who would join you and soak up traps if you were out of shoes.
I couldn’t make it very fun to play though and I didn’t want to bother making 25+ rooms and setting all the connections to other rooms. Instead, I experimented with other features such as the implementation of a go back command (which was removed) and a lock on the exit which is opened by an interaction in a different room. I feel most proud of the riddle maze section the player must traverse to unlock the exit. I got a big eureka-moment once I realized the rooms could break the laws of Euclidean geometry and didn’t have to have logical connections.


# Phase 1
Copilot was unable to write me a working program on its own so phase 1 is not entirely AI generated this time. It took a little while to get used to all the separate files and general structure of the program, but I got a simple working prototype that met most of the requirements in the readme.

## Assignment 2: Maze
You will create a game in which a Player explores a Maze. The Maze is composed of different types of Room objects, some of which are Lootable and/or Interactable. One Room is also Exitable, from which the Player can leave the Maze and end the game.

Rooms are connected to each other in a grid shape. The Player moves between Rooms along the cardinal compass directions: north, south, east, and west. Rooms may also be above or below each other.

The Player may earn points by interacting with certain Rooms or looting others. The game continues until the Player exits the Maze, at which time they are given their final score.

You have complete creative control over the theme of your maze. It could be a classic dungeon crawler, a rabbit warren, or an office building.

### Requirements

Accept and clone the assignment from GitHub Classroom using the following link:

Create the following interfaces.

- **Lootable**: Contains one method named `loot` that takes a Player object as an argument and returns a String. The String will be displayed to the Player after they loot the Room.
- **Interactable**: Contains one method named `interact` that takes a Player object as an argument and returns a String. The String will be displayed to the Player after they interact with the Room.
- **Exitable**: Contains one method named `exit` that takes a Player object as an argument and returns a String. The String will be displayed to the Player after they exit the Room.

Create the following classes.

- **Room**: An abstract class that contains a String field called `name` and six Room fields called `north`, `south`, `east`, `west`, `up`, and `down`. The Room class contains the following methods.
  - A constructor that accepts a String for the name of the Room.
  - An abstract method named `getDescription` that returns a String. The String will be displayed to the Player when they enter the Room and should contain a description of what they see.
  - A method named `getAdjoiningRoom` that accepts a char argument for the direction. If this Room is connected to another Room in the given direction, that Room is returned. Otherwise, return null.
  - A method named `getExits` that returns a String. The String should be a list of all of the directions the Player could move from this Room to another Room.
  - A method named `getName` that returns the name of the Room.
  - A method named `isValidDirection` that accepts a char argument for the direction. If this Room is connected to another Room in the given direction, return true. Otherwise, return false.
  - Six setter methods -- one for each direction -- that accept a Room object and assign it to the appropriate field.

- **Player**: A concrete class that contains an int field called `score`. It also contains either an array or ArrayList of Strings called `inventory`. The Player class contains the following methods.
  - A method named `addToInventory` that accepts a String argument and adds it to the Player's inventory list.
  - A method named `addToScore` that accepts an int argument and adds it to the Player's score.
  - A method named `getInventory` that returns a String. The String should contain the contents of the Player's inventory list. If the inventory is empty, return a message that says so.
  - A method named `getScore` that returns the Player's `score` field (an int).

- **Maze**: A concrete class that contains a Room field called `currentRoom` and a Player field called `player`. It also contains a boolean field called `isFinished` that is initially false. The Maze class contains the following methods.
  - A constructor that creates a Player object and assigns it to the field. The Maze constructor creates all of the Room objects in the game and connects them using the Rooms' setter methods. The Room in which the Player begins the game is assigned to the `currentRoom` field. (See below for instructions on creating concrete Room classes.)
  - A method named `exitCurrentRoom` that returns a String. If the `currentRoom` is Exitable, it returns the result of calling `exit()` on the Room. If not, it returns a message that the current room is not exitable.
  - A method named `interactWithCurrentRoom` that returns a String. If the `currentRoom` is Interactable, it returns the result of calling `interact` on the Room. If not, it returns a message that no interactions are possible.
  - A method named `lootCurrentRoom` that returns a String. If the `currentRoom` is Lootable, it returns the result of calling `loot` on the Room. If not, it returns a message that the current room is not lootable.
  - A method named `move` that accepts a char argument for the direction and returns a boolean. If the direction is valid to move from within the `currentRoom`, the adjoining Room becomes the new `currentRoom` and the method returns true. If not, the method returns false.
  - Methods named `getPlayerScore` and `getPlayerInventory` that return the result of calling the Player's `getScore` and `getInventory` methods.
  - Methods named `getCurrentRoomDescription` and `getCurrentRoomExits` that return the result of calling the `getDescription` and `getExits` method of the `currentRoom`.
  - A method named `isFinished` that returns the Maze's `isFinished` field (a boolean).

- **Main**: This class is the driver and contains the `main` method. Implement the following logic within `main`.
  - Create the Maze, and a Scanner to read keyboard input.
  - Begin a loop that will run until the Maze is finished. Within the loop:
    - Print the current room description.
    - Print the current room exits.
    - Ask the player for a command and read the input as a char.
    - The commands 'n', 's', 'e', 'w', 'u', and 'd' will attempt to move the player in that direction. If the movement is not valid, print a message that says so.
    - The command 'i' will attempt to interact with the current room.
    - The command 'l' (lower case L) will attempt to loot the current room.
    - The command 'x' will attempt to exit the current room. A successful exit means that the maze is finished.
    - The command 'v' prints the player's inventory.
  - When the maze is finished, print the player's score.

In addition to the above classes, create at least three concrete Room classes so that you have one for each interface: Lootable, Interactable, Exitable. You may create more than one Room of each type, and a Room may implement more than one type (for example, a Room may be both Interactable and Exitable).

Only the driver class should perform input or output. Do not create Scanners or use System.out anywhere but in the `main` method.