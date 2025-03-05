package org.project;

import org.project.boardgame.Board;
import org.project.boardgame.Position;
import org.project.chess.ChessException;
import org.project.chess.ChessMatch;
import org.project.chess.ChessPiece;
import org.project.chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while(true) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch);
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
            }catch(ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

    }
}