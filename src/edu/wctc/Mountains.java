package edu.wctc;

public class Mountains extends Room implements Returnable {
    public Mountains(String name) {
        super(name);
    }

    // There were going to be more of these boundary rooms but I only bothered making this one.
    @Override
    public String getDescription() {
        return "The terrain turns sharply mountainous and forces yout to turn back";
    }
    
}
