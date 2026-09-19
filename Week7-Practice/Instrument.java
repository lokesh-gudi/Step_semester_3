public abstract class Instrument {

    public Instrument() {
        super();
    }

    public abstract String play();

    public static void main(String[] args) {

        StringInstrument s =
            new StringInstrument();

        Violin v =
            new Violin();

        System.out.println(s.play());
        System.out.println(v.play());
    }
}

class StringInstrument extends Instrument {

    public StringInstrument() {
        super();
    }

    @Override
    public String play() {
        return "Strumming the strings";
    }
}

class Violin extends StringInstrument {

    public Violin() {
        super();
    }

    @Override
    public String play() {

        return super.play()
             + ", with a bow drawn across four strings";
    }
}