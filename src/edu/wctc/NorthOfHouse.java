package edu.wctc;

public class NorthOfHouse extends Room {
    public NorthOfHouse(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                You are facing the north side of a white house. There is no door here, and all the windows are boarded up.
                To the north a narrow path winds through the trees.""";
    }
 
}
