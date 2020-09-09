package DataType;

public class Interesser {
    public String navn;
    private int id;
    private static int counter = 0;

    public int getId() {
        return this.id;
    }

    public Interesser(String navn) {
        this.navn = navn;
        this.id = counter;
        counter++;
    }
}
