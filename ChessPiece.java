package Chess;

public abstract class ChessPiece {
    protected BoardPosition boardPosition;
    private  PieceColor color;
    protected int value;
    ChessPieces KindOfChessPiece;

    public ChessPiece(PieceColor color, int value, BoardPosition boardPosition , ChessPieces KindOfChessPiece) {
        this.color = color;
        this.value = value;
        this.boardPosition = boardPosition;
        this.KindOfChessPiece = KindOfChessPiece;
    }
    public abstract boolean canMove(BoardPosition target, ChessBoard chessBoard);

    public BoardPosition getBoardPosition() {
        return boardPosition;
    }
    public PieceColor getColor() {
        return color;
    }
    public int getValue() {
        return value;
    }

}
