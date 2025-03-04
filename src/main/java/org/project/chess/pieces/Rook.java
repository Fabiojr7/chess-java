package org.project.chess.pieces;

import org.project.boardgame.Board;
import org.project.boardgame.Position;
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

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position position = new Position(0,0);

        position.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() - 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn() - 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn() + 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        position.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() + 1);
        }

        if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        return mat;
    }
}
