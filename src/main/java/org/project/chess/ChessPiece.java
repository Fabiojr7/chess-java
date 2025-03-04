package org.project.chess;

import org.project.boardgame.Board;
import org.project.boardgame.Piece;
import org.project.boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece != null && piece.getColor() != color;
    }
}
