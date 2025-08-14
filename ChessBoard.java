package Chess;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    final int row = 8;
    final int col = 8;

    private List<ChessPiece> chessPieces;
    private List<ChessPiece> whiteChessPieces;
    private List<ChessPiece> blackChessPieces;
    public ChessBoard() {
        chessPieces = new ArrayList<>();
        whiteChessPieces = new ArrayList<>();
        blackChessPieces = new ArrayList<>();

    }
    public  void addChessPiece(ChessPiece chessPiece) {
        chessPieces.add(chessPiece);
        if (chessPiece.getColor() == PieceColor.WHITE) {
            whiteChessPieces.add(chessPiece);
        } else if (chessPiece.getColor() == PieceColor.BLACK) {
            blackChessPieces.add(chessPiece);
        }
    }
    public void removeChessPiece(ChessPiece chessPiece) {
        chessPieces.remove(chessPiece);
        if (chessPiece.getColor() == PieceColor.WHITE) {
            whiteChessPieces.remove(chessPiece);
        }
        else if (chessPiece.getColor() == PieceColor.BLACK) {
            blackChessPieces.remove(chessPiece);
        }
    }

    public boolean isFull (BoardPosition Position) {
        for (ChessPiece chessPiece : chessPieces) {
            if (chessPiece.getBoardPosition().equals(Position)) {
                return true;
            }
        }
        return false;
    }

    public ChessPiece getChessPiece(BoardPosition position) {
        for (ChessPiece piece : chessPieces) {
            if (piece.getBoardPosition().isEqual(position)) {
                return piece;
            }
        }
        return null;
    }
    public boolean isEnemy (BoardPosition Position ,PieceColor color) {

      if (isFull(Position)) {
          ChessPiece chessPiece = getChessPiece(Position);
          if ( chessPiece.getColor() == color){
              return false;
          }
    }
      return false;
}

   int  materialAdvantage(PieceColor color) {
        int ourValue =0;
        int enemyValue=0;

        for (ChessPiece chessPiece : chessPieces) {
            if (chessPiece.getColor() == color) {
                ourValue+=chessPiece.getValue();
            }
            else if (chessPiece.getColor() != color) {
                enemyValue+=chessPiece.getValue();
            }
        }
        return ourValue-enemyValue;
   }

   int attackedBy(BoardPosition p, PieceColor c) {
        List<ChessPiece>pieces = (c==PieceColor.WHITE)?  whiteChessPieces:blackChessPieces;
        int count = 0;
        for (ChessPiece piece : pieces) {
            if (piece.canMove(p,this)) {
                count++;
            }
        }
        return count;
   }
     int  safety(ChessPiece piece){
       List<ChessPiece>attackerPieces = new ArrayList<>();
       List<ChessPiece> defenderPieces =new ArrayList<>();
       PieceColor pieceColor = piece.getColor();
       int attackedBy = 0;
       int defendedBy = 0;
        for (ChessPiece p : chessPieces) {
            if (p.getColor() == pieceColor && p.canMove(piece.getBoardPosition(),this)){
                defenderPieces.add(p);
            }
            else if (p.getColor() != pieceColor && p.canMove(piece.getBoardPosition(),this)){
                attackerPieces.add(p);
            }

        }

       for(ChessPiece s : attackerPieces){
           attackedBy+=s.getValue();
       }
       for(ChessPiece s : defenderPieces){
           defendedBy+=s.getValue();
       }
         return attackedBy-defendedBy;

   }

   int centralControl(PieceColor color) {
        int count = 0;
        BoardPosition [] centralPoints = {

                new BoardPosition(3,3), new BoardPosition(4,3),
                new BoardPosition(3,4),new BoardPosition(4,4)};


        if (color == PieceColor.WHITE) {
            for (ChessPiece wp : whiteChessPieces ) {
                for ( BoardPosition b   : centralPoints) {
                    if (wp.canMove(b,this)) {
                        count++;
                        break;
                    }
                }
            }
        }
        else if (color == PieceColor.BLACK) {
            for (ChessPiece wp : blackChessPieces ) {
                for ( BoardPosition b   : centralPoints) {
                    if (wp.canMove(b,this)) {
                        count++;
                        break;
                    }
                }
            }
        }
    return count;
    }
   }








