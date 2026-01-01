package h2;

public class H2_Main {
    public static void main(String[] args) {
        Spielbrett b = new Spielbrett(3);

        b.getBrett()[0][0] = new Feld(false, 'L');
        b.getBrett()[0][1] = new Feld(true, 'R');
        b.getBrett()[0][2] = new Feld(false, 'L');

        b.getBrett()[1][0] = new Feld(false, 'L');
        b.getBrett()[1][1] = new Feld(true, 'R');
        b.getBrett()[1][2] = new Feld(false, 'U');

        b.getBrett()[2][0] = new Feld(false, 'L');
        b.getBrett()[2][1] = new Feld(false, 'U');
        b.getBrett()[2][2] = new Feld(false, 'U');

        Spielstein s = new Spielstein(b, 2, 2);
        s.go(7);

        System.out.println(s.getCurrentRow() + ", " + s.getCurrentCol());
    }
}
