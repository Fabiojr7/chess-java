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
        Position movePosition = new Position(0,0);

        movePosition.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setRow(movePosition.getRow() - 1);
        }

        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        movePosition.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setColumn(movePosition.getColumn() - 1);
        }

        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        movePosition.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setColumn(movePosition.getColumn() + 1);
        }

        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        movePosition.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
            movePosition.setRow(movePosition.getRow() + 1);
        }

        if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        return mat;
    }
}
