package Chess;

public class Knight extends ChessPiece {
    public Knight(PieceColor color, int value, BoardPosition boardPosition, ChessPieces KindOfChessPiece) {
        super(color, 3, boardPosition, ChessPieces.KNIGHT);
    }
    public boolean canGo(int rowDiff, int colDiff) {
        return ((Math.abs(rowDiff) == 2 && Math.abs(colDiff) == 1)|| Math.abs(rowDiff) == 1 && Math.abs(colDiff) == 2);
    }

    @Override
    public boolean canMove(BoardPosition target, ChessBoard chessBoard) {
        int currentRow = boardPosition.getRow();
        int currentCol = boardPosition.getCol();
        int rowDiff = target.getRow() - currentRow;
        int colDiff = target.getCol() - currentCol;


        if (
                (canGo(rowDiff,colDiff) && !chessBoard.isFull(target)) ||
                        (canGo(rowDiff,colDiff) && chessBoard.isEnemy(target,getColor()))
        )
        {
            return true;
        }
        else
            return false;
    }


}
