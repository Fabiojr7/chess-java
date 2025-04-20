package org.project.chess.pieces;

import org.project.boardgame.Board;
import org.project.boardgame.Position;
import org.project.chess.ChessPiece;
import org.project.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position movePosition = new Position(0,0);

        //above
        movePosition.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(movePosition) && canMove(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        // below
        movePosition.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().positionExists(movePosition) && canMove(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        // left
        movePosition.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionExists(movePosition) && canMove(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        // right
        movePosition.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExists(movePosition) && canMove(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        // nw
        movePosition.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionExists(movePosition) && canMove(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        // ne
        movePosition.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExists(movePosition) && canMove(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        // sw
        movePosition.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExists(movePosition) && canMove(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        // se
        movePosition.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExists(movePosition) && canMove(movePosition)) {
            mat[movePosition.getRow()][movePosition.getColumn()] = true;
        }

        return mat;
    }
}
