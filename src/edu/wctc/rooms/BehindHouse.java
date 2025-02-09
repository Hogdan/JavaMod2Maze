package edu.wctc.rooms;

public class BehindHouse extends Room implements Interactable {
    public BehindHouse(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                You are facing the east side of the boarded-up house, one of the windows is slightly ajar.
                Further east, across the unkempt yard sits a small shed.
                A dirt path curves around the southern side of the house.
                .""";
    }

    // The window isn't exactly locked in the traditional sense but it's functionally the same.
    @Override
    public String interact(Player player, Room room) {
        if (room.isInteracted()) return "The window opens freely now.";      
        if (player.getInventory().contains("crowbar")) {
            room.setInteracted(true);
            room.getAdjoiningRoom('w').setLocked(false);
            player.removeFromInventory("crowbar");
            player.addToScore(10);
            return "You manage to get the window free but the rusty crowbar breaks in the process.";
        }
        return "You will need more than your hands to get the window to budge.";
    }

}
