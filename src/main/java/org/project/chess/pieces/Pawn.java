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

    Position movePosition = new Position(0,0);

    if (getColor() == Color.WHITE) {
      movePosition.setValues(position.getRow() - 1, position.getColumn());
      if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
        mat[movePosition.getRow()][movePosition.getColumn()] = true;
      }
      movePosition.setValues(position.getRow() - 2, position.getColumn());
      Position movePosition1 = new Position(position.getRow() - 1, position.getColumn());
      if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition) && getBoard().positionExists(movePosition1) && !getBoard().thereIsAPiece(movePosition1) && getMoveCount() == 0) {
        mat[movePosition.getRow()][movePosition.getColumn()] = true;
      }
      movePosition.setValues(position.getRow() - 1, position.getColumn() - 1);
      if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) {
        mat[movePosition.getRow()][movePosition.getColumn()] = true;
      }
      movePosition.setValues(position.getRow() - 1, position.getColumn() + 1);
      if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) {
        mat[movePosition.getRow()][movePosition.getColumn()] = true;
      }
    } else {
      movePosition.setValues(position.getRow() + 1, position.getColumn());
      if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition)) {
        mat[movePosition.getRow()][movePosition.getColumn()] = true;
      }
      movePosition.setValues(position.getRow() + 2, position.getColumn());
      Position movePosition1 = new Position(position.getRow() + 1, position.getColumn());
      if (getBoard().positionExists(movePosition) && !getBoard().thereIsAPiece(movePosition) && getBoard().positionExists(movePosition1) && !getBoard().thereIsAPiece(movePosition1) && getMoveCount() == 0) {
        mat[movePosition.getRow()][movePosition.getColumn()] = true;
      }
      movePosition.setValues(position.getRow() + 1, position.getColumn() - 1);
      if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) {
        mat[movePosition.getRow()][movePosition.getColumn()] = true;
      }
      movePosition.setValues(position.getRow() + 1, position.getColumn() + 1);
      if (getBoard().positionExists(movePosition) && isThereOpponentPiece(movePosition)) {
        mat[movePosition.getRow()][movePosition.getColumn()] = true;
      }
    }

    return mat;
  }

  @Override
  public String toString() {
    return "P";
  }
}
