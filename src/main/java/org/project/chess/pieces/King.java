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

        Position position = new Position(0,0);

        //above
        position.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        // below
        position.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        // left
        position.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        // right
        position.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        // nw
        position.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        // ne
        position.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        // sw
        position.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        // se
        position.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExists(position) && canMove(position)) {
            mat[position.getRow()][position.getColumn()] = true;
        }

        return mat;
    }
}
