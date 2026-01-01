package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    private boolean movesOut() {
        Feld f = brett.getBrett()[currentRow][currentCol];
        char d = f.getDirection();
        int dim = brett.getDim();

        if (d == 'U') return currentRow == 0;
        if (d == 'D') return currentRow == dim - 1;
        if (d == 'L') return currentCol == 0;
        if (d == 'R') return currentCol == dim - 1;

        return false;
    }

    public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld f = brett.getBrett()[currentRow][currentCol];

            if (f.isBoese()) {
                continue;
            }

            if (movesOut()) {
                continue;
            }

            switch (f.getDirection()) {
                case 'U': currentRow--; break;
                case 'D': currentRow++; break;
                case 'L': currentCol--; break;
                case 'R': currentCol++; break;
            }
        }
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }
}
