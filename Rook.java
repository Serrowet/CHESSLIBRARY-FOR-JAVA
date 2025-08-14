package Chess;

public class Rook extends ChessPiece {
    public Rook(PieceColor color, int value, BoardPosition boardPosition, ChessPieces KindOfChessPiece) {
        super(color, 5, boardPosition, ChessPieces.ROOK);
    }

   public boolean movementCheck(int rowDiff, int colDiff) {
        return (rowDiff == 0 && colDiff !=0 ) || (rowDiff != 0 && colDiff ==0);
   }

   public boolean isWayFree (int diffRow, int diffCol, int currentRow,
                            int currentCol, int targetRow, int targetCol,
                            ChessBoard chessBoard) {
       int stepRow = (diffRow>0) ? 1 :-1 ;
       int stepCol = (diffCol>0) ? 1 :-1 ;
  if (currentRow == targetRow && currentCol != targetCol) {
      int c =currentCol+stepCol;
      while ( c!=targetCol) {
          if(chessBoard.isFull(new BoardPosition(currentRow,c))) {
              return false;
          }
          c=c+stepCol;
      }
  }
  else if (currentRow != targetRow && currentCol == targetCol) {
      int r =currentRow+stepRow;
      while ( r!=targetRow) {
          if(chessBoard.isFull(new BoardPosition(r,currentCol))) {
              return false;
          }
          r+=stepRow;
      }

  }



   return true;
   }


    @Override
    public boolean canMove(BoardPosition target, ChessBoard chessBoard) {
        int currentRow = boardPosition.getRow();
        int currentCol = boardPosition.getCol();
        int rowDiff = target.getRow() - currentRow;
        int colDiff = target.getCol() - currentCol;
        if (
                (movementCheck(rowDiff,colDiff) && !chessBoard.isFull(target)&&isWayFree(rowDiff,colDiff,currentRow,currentCol
                                ,target.getRow(),target.getCol(),chessBoard) ||
                                (movementCheck(rowDiff,colDiff)
                                        && chessBoard.isEnemy(target,getColor())
                                        &&  chessBoard.isFull(target) &&
                                isWayFree(rowDiff,colDiff,currentRow,currentCol
                                ,target.getRow(),target.getCol(),chessBoard)))
        )
        {
            return true;
        }
        else
            return false;
    }
}
