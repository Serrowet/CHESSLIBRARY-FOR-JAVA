package Chess;

public class BoardPosition {
   private int row;
    private int col;
   public BoardPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public String toChessNotation() {
        char file = (char) ('a' + col);
        int rank = 8 - row;

        return "" + file + rank;
    }

    public boolean isEqual(BoardPosition other) {
        return other.col == col && other.row == row;
    }
}
