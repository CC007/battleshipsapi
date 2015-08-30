/*
 * The MIT License
 *
 * Copyright 2015 Rik Schaaf aka CC007 (http://coolcat007.nl/).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.cc007.battleshipsapi;

/**
 *
 * @author Rik Schaaf aka CC007 (http://coolcat007.nl/)
 */
public class BattleShipsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        boolean shipPlaced;
        System.out.println("Game ready: " + game.isReady());
        System.out.println("Player 1 shot: " + player1.shootOpponent('a', 2));
        System.out.println("Player 2 shot: " + player2.shootOpponent('b', 2));
        System.out.println("\nPlayer 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.CARRIER, 'a', 1, ShipDirection.VERTICAL);
        System.out.println("\nCarrier placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.BATTLESHIP, 'b', 2, ShipDirection.VERTICAL);
        System.out.println("\nbattleship placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.moveShip(ShipKind.CRUISER, 'b', 2, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.moveShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.moveShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.DESTROYER, 'd', 4, ShipDirection.VERTICAL);
        System.out.println("\nDestroyer placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.SUBMARINE, 'd', 4, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.SUBMARINE, 'e', 5, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.moveShip(ShipKind.SUBMARINE, 'g', 5, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine moved: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        System.out.println("\nGame ready: " + game.isReady());
        System.out.println("\n\nPlayer 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.CARRIER, 'a', 1, ShipDirection.VERTICAL);
        System.out.println("\nCarrier placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.BATTLESHIP, 'b', 2, ShipDirection.VERTICAL);
        System.out.println("\nbattleship placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.moveShip(ShipKind.CRUISER, 'b', 2, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.moveShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.moveShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.DESTROYER, 'd', 4, ShipDirection.VERTICAL);
        System.out.println("\nDestroyer placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.SUBMARINE, 'd', 4, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.SUBMARINE, 'e', 5, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine placed: " + shipPlaced);
        System.out.println("\nGame ready: " + game.isReady());
        System.out.println("Player 2 ready: " + player2.ready());
        System.out.println("Game ready: " + game.isReady());
        shipPlaced = player2.moveShip(ShipKind.SUBMARINE, 'g', 5, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine moved: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        System.out.println("\nGame ready: " + game.isReady());
        System.out.println("\n-------------");
        System.out.println("Ok lets play!");
        System.out.println("-------------");
        System.out.println("Player 2 shot: " + player2.shootOpponent('b', 2));
        System.out.println("Player 1 shot: " + player1.shootOpponent('a', 2));
        System.out.println(" Player 1 hit: " + player1.getOpponentGrid().get('a').get(2).getState().equals(FieldState.HIT));
        System.out.println(" Player 1 missed: " + player1.getOpponentGrid().get('a').get(2).getState().equals(FieldState.MISS));
        System.out.println("Player 1 shot: " + player1.shootOpponent('b', 2));
        System.out.println("Player 2 shot: " + player2.shootOpponent('b', 1));
        System.out.println(" Player 1 hit: " + player2.getOpponentGrid().get('b').get(1).getState().equals(FieldState.HIT));
        System.out.println(" Player 1 missed: " + player2.getOpponentGrid().get('b').get(1).getState().equals(FieldState.MISS));
        System.out.println("Player 2 shot: " + player2.shootOpponent('b', 2));
        System.out.println("Player 1 shot: " + player1.shootOpponent('b', 2));
        System.out.println("Player 2 shot: " + player2.shootOpponent('b', 2));
        System.out.println("Player 1 shot: " + player1.shootOpponent('b', 2));
        System.out.println("\n-----------------------");
        System.out.println("Time for a full game...");
        System.out.println("-----------------------");
        for (int i = 1; i <= 10; i++) {
            for (int j = 'a'; j <= 'j'; j++) {
                System.out.println("Player 1 shot (" + (char) j + i + "): " + player1.shootOpponent((char) j, i));
                System.out.println(" Player 1 hit: " + player1.getOpponentGrid().get((char) j).get(i).getState().equals(FieldState.HIT));
                System.out.println(" Player 1 missed: " + player1.getOpponentGrid().get((char) j).get(i).getState().equals(FieldState.MISS));
                if (game.isGameOver()) {
                    break;
                }
                System.out.println("Player 2 shot (" + (char) j + i + "): " + player2.shootOpponent((char) j, i));
                System.out.println(" Player 2 hit: " + player2.getOpponentGrid().get((char) j).get(i).getState().equals(FieldState.HIT));
                System.out.println(" Player 2 missed: " + player2.getOpponentGrid().get((char) j).get(i).getState().equals(FieldState.MISS));
                if (game.isGameOver()) {
                    break;
                }
            }
            if (game.isGameOver()) {
                break;
            }
        }
        System.out.println("\n-----------------");
        System.out.println("The game is over.");
        System.out.println("-----------------");
        System.out.println("\nCan players still shoot?");
        System.out.println(" Player 2 shot: " + player2.shootOpponent('f', 8));
        System.out.println(" Player 1 shot: " + player1.shootOpponent('f', 8));
        System.out.println("I guess not...");
        System.out.println("\nWho won?");
        System.out.println(" Player 1: " + player1.hasWon());
        System.out.println(" Player 2: " + player2.hasWon());
        
        System.out.println("\ncan you move ships after the game ended?");
        shipPlaced = player1.moveShip(ShipKind.DESTROYER, 'i', 3, ShipDirection.VERTICAL);
        System.out.println(" Destroyer moved: " + shipPlaced);
        shipPlaced = player2.moveShip(ShipKind.DESTROYER, 'i', 3, ShipDirection.VERTICAL);
        System.out.println(" Destroyer moved: " + shipPlaced);
        
        System.out.println("\n----------------");
        System.out.println("Restart the game");
        System.out.println("----------------");
        game.reset();
        player1 = game.getPlayer1();
        player2 = game.getPlayer2();
        System.out.println("\nGame ready: " + game.isReady());
        System.out.println("Player 1 shot: " + player1.shootOpponent('a', 2));
        System.out.println("Player 2 shot: " + player2.shootOpponent('b', 2));
        System.out.println("\nPlayer 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.CARRIER, 'a', 1, ShipDirection.VERTICAL);
        System.out.println("\nCarrier placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.BATTLESHIP, 'b', 2, ShipDirection.VERTICAL);
        System.out.println("\nbattleship placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.moveShip(ShipKind.CRUISER, 'b', 2, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.moveShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.moveShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.DESTROYER, 'd', 4, ShipDirection.VERTICAL);
        System.out.println("\nDestroyer placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.SUBMARINE, 'd', 4, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.placeShip(ShipKind.SUBMARINE, 'e', 5, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine placed: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        shipPlaced = player1.moveShip(ShipKind.SUBMARINE, 'g', 5, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine moved: " + shipPlaced);
        System.out.println("Player 1 ready: " + player1.ready());
        System.out.println("\nGame ready: " + game.isReady());
        System.out.println("\n\nPlayer 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.CARRIER, 'a', 1, ShipDirection.VERTICAL);
        System.out.println("\nCarrier placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.BATTLESHIP, 'b', 2, ShipDirection.VERTICAL);
        System.out.println("\nbattleship placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.moveShip(ShipKind.CRUISER, 'b', 2, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.moveShip(ShipKind.CRUISER, 'c', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.moveShip(ShipKind.CRUISER, 'f', 3, ShipDirection.VERTICAL);
        System.out.println("\nCruiser moved: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.DESTROYER, 'd', 4, ShipDirection.VERTICAL);
        System.out.println("\nDestroyer placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.SUBMARINE, 'd', 4, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine placed: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        shipPlaced = player2.placeShip(ShipKind.SUBMARINE, 'e', 5, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine placed: " + shipPlaced);
        System.out.println("\nGame ready: " + game.isReady());
        System.out.println("Player 2 ready: " + player2.ready());
        System.out.println("Game ready: " + game.isReady());
        shipPlaced = player2.moveShip(ShipKind.SUBMARINE, 'g', 5, ShipDirection.VERTICAL);
        System.out.println("\nSubmarine moved: " + shipPlaced);
        System.out.println("Player 2 ready: " + player2.ready());
        System.out.println("\nGame ready: " + game.isReady());
        System.out.println("\n-------------");
        System.out.println("Ok lets play!");
        System.out.println("-------------");
        System.out.println("Player 2 shot: " + player2.shootOpponent('b', 2));
        System.out.println("Player 1 shot: " + player1.shootOpponent('a', 2));
        System.out.println(" Player 1 hit: " + player1.getOpponentGrid().get('a').get(2).getState().equals(FieldState.HIT));
        System.out.println(" Player 1 missed: " + player1.getOpponentGrid().get('a').get(2).getState().equals(FieldState.MISS));
        System.out.println("Player 1 shot: " + player1.shootOpponent('b', 2));
        System.out.println("Player 2 shot: " + player2.shootOpponent('b', 1));
        System.out.println(" Player 1 hit: " + player2.getOpponentGrid().get('b').get(1).getState().equals(FieldState.HIT));
        System.out.println(" Player 1 missed: " + player2.getOpponentGrid().get('b').get(1).getState().equals(FieldState.MISS));
        System.out.println("Player 2 shot: " + player2.shootOpponent('b', 2));
        System.out.println("Player 1 shot: " + player1.shootOpponent('b', 2));
        System.out.println("Player 2 shot: " + player2.shootOpponent('b', 2));
        System.out.println("Player 1 shot: " + player1.shootOpponent('b', 2));
        System.out.println("\n-----------------------");
        System.out.println("Time for a full game...");
        System.out.println("-----------------------");
        for (int i = 1; i <= 10; i++) {
            for (int j = 'a'; j <= 'j'; j++) {
                System.out.println("Player 1 shot (" + (char) j + i + "): " + player1.shootOpponent((char) j, i));
                System.out.println(" Player 1 hit: " + player1.getOpponentGrid().get((char) j).get(i).getState().equals(FieldState.HIT));
                System.out.println(" Player 1 missed: " + player1.getOpponentGrid().get((char) j).get(i).getState().equals(FieldState.MISS));
                if (game.isGameOver()) {
                    break;
                }
                System.out.println("Player 2 shot (" + (char) j + i + "): " + player2.shootOpponent((char) j, i));
                System.out.println(" Player 2 hit: " + player2.getOpponentGrid().get((char) j).get(i).getState().equals(FieldState.HIT));
                System.out.println(" Player 2 missed: " + player2.getOpponentGrid().get((char) j).get(i).getState().equals(FieldState.MISS));
                if (game.isGameOver()) {
                    break;
                }
            }
            if (game.isGameOver()) {
                break;
            }
        }
        System.out.println("\n-----------------");
        System.out.println("The game is over.");
        System.out.println("-----------------");
        System.out.println("\nCan players still shoot?");
        System.out.println(" Player 2 shot: " + player2.shootOpponent('f', 8));
        System.out.println(" Player 1 shot: " + player1.shootOpponent('f', 8));
        System.out.println("I guess not...");
        System.out.println("\nWho won?");
        System.out.println(" Player 1: " + player1.hasWon());
        System.out.println(" Player 2: " + player2.hasWon());
        
        System.out.println("\ncan you move ships after the game ended?");
        shipPlaced = player1.moveShip(ShipKind.DESTROYER, 'i', 3, ShipDirection.VERTICAL);
        System.out.println(" Destroyer moved: " + shipPlaced);
        shipPlaced = player2.moveShip(ShipKind.DESTROYER, 'i', 3, ShipDirection.VERTICAL);
        System.out.println(" Destroyer moved: " + shipPlaced);
    }

}
