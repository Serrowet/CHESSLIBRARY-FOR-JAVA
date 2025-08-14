package Chess;

public class Queen extends ChessPiece{
    public Queen(PieceColor color, int value, BoardPosition boardPosition, ChessPieces KindOfChessPiece) {
        super(color, 10, boardPosition,ChessPieces.QUEEN);
    }
    boolean isAbsEquals(int row, int col) {

        return  (Math.abs(row)-Math.abs(col) == 0 && Math.abs(row)!=0 ) ;
    }




    boolean isWayFreeCross(int diffRow, int diffCol, int currentRow,
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








    public boolean movementCheckStraight(int rowDiff, int colDiff) {
        return (rowDiff == 0 && colDiff !=0 ) || (rowDiff != 0 && colDiff ==0);
    }











    public boolean isWayFreeStraight (int diffRow, int diffCol, int currentRow,
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




    public boolean isStraight (int diffRow, int diffCol) {
        return  ((diffRow == 0 && diffCol !=0) || (diffRow != 0 && diffCol ==0));
    }



    @Override
    public boolean canMove(BoardPosition target, ChessBoard chessBoard) {
        int currentRow = boardPosition.getRow();
        int currentCol = boardPosition.getCol();
        int rowDiff = target.getRow() - currentRow;
        int colDiff = target.getCol() - currentCol;
        String Direction = (isStraight(rowDiff, colDiff)) ? "Straight" : "Cross";

        if (Direction.equals("Straight") && movementCheckStraight(rowDiff, colDiff)
                && !chessBoard.isFull(target) && isWayFreeStraight(rowDiff, colDiff, currentRow, currentCol
                , target.getRow(), target.getCol(), chessBoard) ||
                Direction.equals("Straight") &&
                        (movementCheckStraight(rowDiff, colDiff)
                                && chessBoard.isEnemy(target, getColor())
                                && chessBoard.isFull(target) &&
                                isWayFreeStraight(rowDiff, colDiff, currentRow, currentCol
                                        , target.getRow(), target.getCol(), chessBoard))) {
            return true;
        } else if (Direction.equals("Cross") && (isAbsEquals(rowDiff, colDiff) && !chessBoard.isFull(target)
                && isWayFreeCross(rowDiff, colDiff, currentRow, currentCol,
                target.getRow(), target.getCol(), chessBoard)) || (Direction.equals("Cross") &&
                (isAbsEquals(rowDiff, colDiff) && chessBoard.isEnemy(target, getColor())
                        && chessBoard.isFull(target)
                        && isWayFreeCross(rowDiff, colDiff, currentRow, currentCol,
                        target.getRow(), target.getCol(), chessBoard)))) {

            return true;
        }
        return false;

    }
}
