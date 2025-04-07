package org.project.chess.pieces;

import org.project.boardgame.Board;
import org.project.boardgame.Position;
import org.project.chess.ChessPiece;
import org.project.chess.Color;

public class Pawn extends ChessPiece {

  public Pawn(Board board, Color color) {
    super(board, color);
  }

  @Override
  public boolean[][] possibleMoves() {
    boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

    Position position = new Position(0,0);

    if (getColor() == Color.WHITE) {
      position.setValues(position.getRow() - 1, position.getColumn());
      if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
        mat[position.getRow()][position.getColumn()] = true;
      }
      position.setValues(position.getRow() - 2, position.getColumn());
      Position position1 = new Position(position.getRow() - 1, position.getColumn());
      if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getBoard().positionExists(position1) && !getBoard().thereIsAPiece(position1) && getMoveCount() == 0) {
        mat[position.getRow()][position.getColumn()] = true;
      }
      position.setValues(position.getRow() - 1, position.getColumn() - 1);
      if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
        mat[position.getRow()][position.getColumn()] = true;
      }
      position.setValues(position.getRow() - 1, position.getColumn() + 1);
      if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
        mat[position.getRow()][position.getColumn()] = true;
      }
    } else {
      position.setValues(position.getRow() + 1, position.getColumn());
      if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
        mat[position.getRow()][position.getColumn()] = true;
      }
      position.setValues(position.getRow() + 2, position.getColumn());
      Position position1 = new Position(position.getRow() + 1, position.getColumn());
      if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position) && getBoard().positionExists(position1) && !getBoard().thereIsAPiece(position1) && getMoveCount() == 0) {
        mat[position.getRow()][position.getColumn()] = true;
      }
      position.setValues(position.getRow() + 1, position.getColumn() - 1);
      if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
        mat[position.getRow()][position.getColumn()] = true;
      }
      position.setValues(position.getRow() + 1, position.getColumn() + 1);
      if (getBoard().positionExists(position) && isThereOpponentPiece(position)) {
        mat[position.getRow()][position.getColumn()] = true;
      }
    }

    return mat;
  }

  @Override
  public String toString() {
    return "P";
  }
}
