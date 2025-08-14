package Chess;

public class King extends ChessPiece {
    public King(PieceColor color, int value, BoardPosition boardPosition, ChessPieces KindOfChessPiece) {
        super(color, 100, boardPosition, ChessPieces.KING);
    }

    boolean movement(int row, int col) {

        return  (Math.abs(row)==1 && Math.abs(col) == 1 ||
                  Math.abs(row)==1 && Math.abs(col)==0 ||
                Math.abs(row)==0 && Math.abs(col)==1) ;
    }


    @Override
    public boolean canMove(BoardPosition target, ChessBoard chessBoard) {

        int currentRow = boardPosition.getRow() ;
        int currentCol = boardPosition.getCol();
        int rowDiff = target.getRow() - currentRow;
        int colDiff = target.getCol() - currentCol;

      if (movement(rowDiff,colDiff) && !chessBoard.isFull(target) ||
              movement(rowDiff,colDiff)&& chessBoard.isFull(target)&&chessBoard.isEnemy(target,getColor())) {
          return true;
      }

        return false;
    }
}
