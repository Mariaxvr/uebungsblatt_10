package h1;

public class H1_Main {
    public static void main(String[] args) {
        Cell[] start = {
                new Cell(0, 4),
                new Cell(1, 1),
                new Cell(2, 2),
                new Cell(2, 3),
                new Cell(3, 1),
                new Cell(3, 2)
        };

        Grid grid = new Grid(start, 4, 5);
        grid.computeGeneration(2);

        Cell[][] g = grid.getGridArray();
        for (Cell[] row : g) {
            for (Cell c : row) {
                System.out.print(c.isAlive() ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}
