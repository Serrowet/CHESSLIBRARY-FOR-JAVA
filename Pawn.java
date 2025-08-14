package Chess;

public class Pawn extends ChessPiece {
    public Pawn(PieceColor color, int value, BoardPosition boardPosition) {
        super(color, 1, boardPosition,ChessPieces.PAWN);
    }



    public boolean canMove(BoardPosition target, ChessBoard chessBoard) {
        int currentRow = boardPosition.getRow();
        int curentCol = boardPosition.getCol();
        int rowDiff = target.getRow() - currentRow;
        int colDiff = target.getCol() - curentCol;
        int direction = (getColor() == PieceColor.WHITE ? -1 : 1);

 if (colDiff == 0 && rowDiff == direction && !chessBoard.isFull(target)) {
     return true;
 }

 if (Math.abs(colDiff) == 1 &&  rowDiff == direction && chessBoard.isFull(target) && chessBoard.isEnemy(target,getColor())) {
     return true;
 }
else
        return false;
    }


}
