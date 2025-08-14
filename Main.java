package Chess;

public class Main {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();


        board.addChessPiece(new Queen(PieceColor.WHITE, 10, new BoardPosition(0, 3), ChessPieces.QUEEN));
        board.addChessPiece(new Bishop(PieceColor.WHITE, 3, new BoardPosition(1, 2), ChessPieces.BISHOP));
        board.addChessPiece(new Rook(PieceColor.BLACK, 5, new BoardPosition(7, 3), ChessPieces.ROOK));
        board.addChessPiece(new Knight(PieceColor.BLACK, 3, new BoardPosition(5, 2), ChessPieces.KNIGHT));


        int advantage = board.materialAdvantage(PieceColor.WHITE);
        System.out.println("Material Advantage (White): " + advantage);


        BoardPosition testPos = new BoardPosition(0, 3);
        int attackers = board.attackedBy(testPos, PieceColor.BLACK);
        System.out.println("Black attacking (" + testPos.toChessNotation() + "): " + attackers);


        ChessPiece queen = board.getChessPiece(testPos);
        int safety = board.safety(queen);
        System.out.println("Safety of White Queen: " + safety);


        int whiteCentralControl = board.centralControl(PieceColor.WHITE);
        int blackCentralControl = board.centralControl(PieceColor.BLACK);
        System.out.println("White Central Control: " + whiteCentralControl);
        System.out.println("Black Central Control: " + blackCentralControl);
    }
}