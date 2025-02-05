package edu.wctc;

public class Glade extends Room {
    public Glade(String name) {
        super(name);
    }

    // I wouldn't mind making a more fleshed out and proper text adventure game someday.
    // They are something of a lost art.
    // But maybe I just like to write flavor text.
    @Override
    public String getDescription() {
        return """
                The sun shines through the trees and you can hear birds singing.
                The dense forest give way to a peaceful glade.
                To the north you see the terrain turn sharply mountainous.
                The forest becomes impenetrable to the west but there is a path through the trees to the east.
                    """;
    }

}
