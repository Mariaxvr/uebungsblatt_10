package h1;

public class Grid {
    private Cell[][] gridArray;

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        gridArray = new Cell[gridRows][gridCols];

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                gridArray[i][j] = new Cell(i, j);
            }
        }

        for (Cell c : cells) {
            int r = c.getIndexRow();
            int col = c.getIndexCol();
            if (r >= 0 && r < gridRows && col >= 0 && col < gridCols) {
                gridArray[r][col].setAlive(true);
            }
        }

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                gridArray[i][j].countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeNextGen() {
        for (Cell[] row : gridArray) {
            for (Cell c : row) {
                c.countLivingNeighbors(gridArray);
            }
        }

        for (Cell[] row : gridArray) {
            for (Cell c : row) {
                c.setAlive(c.isAliveNextGen());
            }
        }
    }

    public void computeGeneration(int n) {
        for (int i = 0; i < n; i++) {
            computeNextGen();
        }
    }

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }
}
