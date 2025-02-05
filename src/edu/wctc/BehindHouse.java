package edu.wctc;

public class BehindHouse extends Room implements Interactable {
    public BehindHouse(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                You are facing the west side of the house.
                One of the boarded up windows looks looser than the others.
                To the east a narrow path winds through the trees.""";
    }

    // The window isn't exactly locked in the traditional sense but it's functionally the same.
    @Override
    public String interact(Player player, Room room) {
        if (player.getInventory().contains("crowbar")) {
            room.getAdjoiningRoom('w').setLocked(false);
            player.removeFromInventory("crowbar");
            player.addToScore(10);
            return "With some effort the you manage to pry the window open however, you break the crowbar in the process.";
        } else {
            return "You will need more than your hands to get the window to budge.";
        }
    }

}
