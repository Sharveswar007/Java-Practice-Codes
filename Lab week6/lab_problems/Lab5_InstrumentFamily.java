// LAB PROBLEM 5: Musical Instrument Family
class Instrument {
    protected String name;
    protected String material;
    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }
    public void play() {
        System.out.println("Playing instrument: " + name);
    }
}

class Piano extends Instrument {
    protected int keys;
    public Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
    }
    @Override
    public void play() {
        System.out.println("Playing piano with " + keys + " keys");
    }
}

class Guitar extends Instrument {
    protected int strings;
    public Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
    }
    @Override
    public void play() {
        System.out.println("Playing guitar with " + strings + " strings");
    }
}

class Drum extends Instrument {
    protected String type;
    public Drum(String name, String material, String type) {
        super(name, material);
        this.type = type;
    }
    @Override
    public void play() {
        System.out.println("Playing " + type + " drum");
    }
}

class InstrumentTest {
    public static void main(String[] args) {
        Instrument[] instruments = {
            new Piano("Piano", "Wood", 88),
            new Guitar("Guitar", "Wood", 6),
            new Drum("Drum", "Metal", "Snare")
        };
        for (Instrument i : instruments) {
            i.play();
        }
    }
}
