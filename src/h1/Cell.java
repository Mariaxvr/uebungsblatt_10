package h1;

public class Cell {
    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol) {
        this(indexRow, indexCol, false);
    }

    public void countLivingNeighbors(Cell[][] gridArray) {
        int count = 0;

        for (int i = indexRow - 1; i <= indexRow + 1; i++) {
            for (int j = indexCol - 1; j <= indexCol + 1; j++) {
                if (i == indexRow && j == indexCol) continue;
                if (i >= 0 && i < gridArray.length &&
                        j >= 0 && j < gridArray[0].length) {
                    if (gridArray[i][j].isAlive()) {
                        count++;
                    }
                }
            }
        }

        this.numLivingNeighbors = count;
        decideNextStatus();
    }

    private void decideNextStatus() {
        if (alive) {
            isAliveNextGen = (numLivingNeighbors == 2 || numLivingNeighbors == 3);
        } else {
            isAliveNextGen = (numLivingNeighbors == 3);
        }
    }

    // Getter & Setter
    public int getIndexRow() { return indexRow; }
    public int getIndexCol() { return indexCol; }
    public boolean isAlive() { return alive; }
    public void setAlive(boolean alive) { this.alive = alive; }
    public int getNumLivingNeighbors() { return numLivingNeighbors; }
    public boolean isAliveNextGen() { return isAliveNextGen; }
}
