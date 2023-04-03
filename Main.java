package OOP.BoxingMatch;

public class Main {
    public static void main(String[] args) {
        Fighter marc = new Fighter("Marc", 100, 90, 20);
        Fighter alex = new Fighter("Alex", 100, 100, 30);
        Ring r = new Ring(marc, alex, 90, 100);
        r.run();
    }
}
