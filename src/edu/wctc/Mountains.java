package edu.wctc;

public class Mountains extends Room implements Bounceable {
    public Mountains(String name) {
        super(name);
    }

    // There were going to be more of these boundary rooms but I only bothered making this one.
    @Override
    public String getDescription() {
        return """
                The soft earth under your feet gives way to sharp rocks and loose gravel as a steep mountain looms ahead.
                There is no path forward. You return the way you came.
                """;
    }
    
}
