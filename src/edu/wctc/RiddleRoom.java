package edu.wctc;

public class RiddleRoom extends Room implements Interactable {
    public RiddleRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                You are standing in a small windowless room. The door to the foyer is to your west.
                A table has been roughly shoved into the corner. The surface is marked by deep scratches.
                """;
    }

    /*  
    I am proud of this riddle, Copilot didn't write it for me.
    I came up with it when I was looking at the 6 chars the player was allowed to move.
    I wanted the path to be a word spelled with n s e w u d but had trouble since I couldn't use opposite directions.
    You would just go back to the last room. Thats when I realized that the rooms didn't have to connect logically.
    The doors to other rooms worked just fine if they were one way. So I picked a word that I was able to make a riddle with,
    and I came up with "unseen" maybe I will make more riddles with "sweeden" "unused" and "seeded".
    */
    @Override
    public String interact(Player player , Room room) {
        if (!room.isInteracted()) {
            player.addToScore(5);
            room.setInteracted(true);
        }
        return """
                The marks compose a hastily scrawled message...

                To freedom from here,
                Six rooms in between,
                Don't trust your eyes,
                The route is _______
                
                You can't make out the last word.
                """;
    }
}
