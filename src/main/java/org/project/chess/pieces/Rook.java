package org.project.chess.pieces;

import org.project.boardgame.Board;
import org.project.chess.ChessPiece;
import org.project.chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }
}
