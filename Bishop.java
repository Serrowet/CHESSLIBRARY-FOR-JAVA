package Chess;

public class Bishop extends ChessPiece {

    public Bishop(PieceColor color, int value, BoardPosition boardPosition, ChessPieces KindOfChessPiece) {
        super(color, 3, boardPosition, ChessPieces.BISHOP);
    }
    boolean isAbsEquals(int row, int col) {

        return  (Math.abs(row)-Math.abs(col) == 0 && Math.abs(row)!=0 ) ;
    }





    boolean isWayFree(int diffRow, int diffCol, int currentRow,
                      int currentCol, int targetRow, int targetCol,
                      ChessBoard chessBoard) {
if (isAbsEquals(diffRow, diffCol)==false) {
    return false;
}
int stepRow = (diffRow>0) ? 1 :-1 ;
int stepCol = (diffCol>0) ? 1 :-1 ;
int r =currentRow + stepRow;
int c =currentCol+stepCol;

  while (r!=targetRow && c!=targetCol) {
      if(chessBoard.isFull(new BoardPosition(r,c))) {
          return false;
      }
      r=r+stepRow;
      c=c+stepCol;
  }
  return true;
    }





    @Override
    public boolean canMove(BoardPosition target, ChessBoard chessBoard) {
        int currentRow = boardPosition.getRow() ;
        int currentCol = boardPosition.getCol();
        int rowDiff = target.getRow() - currentRow;
        int colDiff = target.getCol() - currentCol;
        if (
                                (isAbsEquals(rowDiff,colDiff) && !chessBoard.isFull(target) &&
                                 isWayFree(rowDiff,colDiff,currentRow,currentCol
                                , target.getRow(), target.getCol(), chessBoard)) ||
                                 (isAbsEquals(rowDiff,colDiff) && chessBoard.isEnemy(target,getColor())
                                         &&chessBoard.isFull(target)
                                  && isWayFree(rowDiff,colDiff,currentRow,currentCol,
                            target.getRow(), target.getCol(), chessBoard))
        )
        {
            return true;
        }
else
    return false;
        }




    }



