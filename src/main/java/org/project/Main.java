package org.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.project.chess.ChessException;
import org.project.chess.ChessMatch;
import org.project.chess.ChessPiece;
import org.project.chess.ChessPosition;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ChessMatch chessMatch = new ChessMatch();
    List<ChessPiece> captured = new ArrayList<>();

    while (!chessMatch.getCheckMate()) {
      try {
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
        System.out.println();
        System.out.print("Source: ");
        ChessPosition sourcePosition = UI.readChessPosition(sc);

        boolean[][] possibleMoves = chessMatch.possibleMoves(sourcePosition);
        UI.clearScreen();
        UI.printBoard(chessMatch.getPieces(), possibleMoves);

        System.out.println();
        System.out.print("Target: ");
        ChessPosition targetPosition = UI.readChessPosition(sc);

        ChessPiece capturePiece = chessMatch.performChessMove(sourcePosition, targetPosition);

        if (capturePiece != null) {
          captured.add(capturePiece);
        }
      } catch (ChessException e) {
        System.out.println(e.getMessage());
        sc.nextLine();
      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());
        sc.nextLine();
      }
    }
    UI.clearScreen();
    UI.printMatch(chessMatch, captured);
  }
}