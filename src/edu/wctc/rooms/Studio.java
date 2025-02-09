package edu.wctc.rooms;

public class Studio extends Room {
    public Studio(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                The studio is a mess of canvases and artist debris. Every surface in the room is splattered with paint.
                The smell of turpentine is strong. There is a single door to the south. All the windows are boarded up.
                """;
    }
    
}
