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

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Rik Schaaf aka CC007 (http://coolcat007.nl/)
 */
public class Player implements Serializable {

    private Game game;
    private boolean ready;
    private Grid ownGrid;
    private Grid opponentGrid;
    private Set<ShipPlacement> shipPlacements;
    private boolean myTurn;
    private int hitCounter;
    private boolean won;

    public Player(Game game) {
        this.game = game;
        this.ready = false;
        this.ownGrid = new Grid();
        this.opponentGrid = new Grid();
        this.shipPlacements = new HashSet<>();
        this.myTurn = false;
        this.hitCounter = 0;
        this.won = false;
    }

    /**
     * 
     * @return true if this player has won
     */
    public boolean hasWon() {
        return won;
    }
    
    /**
     * Give the turn to this player
     */
    public void myTurn() {
        myTurn = true;
    }

    /**
     *
     * @return true if it is this player's turn
     */
    public boolean isMyTurn() {
        return myTurn;
    }

    /**
     * set that you don't want to change your ship's positions anymore
     *
     * @return true if all ships are placed
     */
    public boolean ready() {
        boolean condition = shipPlacements.size() == 5;
        this.ready = condition;
        return condition;
    }

    /**
     *
     * @return true if the player has successfully readied (readied when all
     * ships were placed)
     */
    public boolean isReady() {
        return ready;
    }

    /**
     *
     * @param kind ship type
     * @return true if this kind of ship is already placed
     */
    public boolean hasShip(ShipKind kind) {
        for (ShipPlacement shipPlacement : shipPlacements) {
            if (kind.equals(shipPlacement.kind)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Move a ship to another location. This can only be done before readying
     * and only if the ship is already placed. Also impossible if one of the
     * specified fields is occupied.
     *
     * @param kind ship type
     * @param colPos start column of new placement
     * @param rowPos start row of new placement
     * @param direction horizontal or vertical direction of the new placement
     * @return if the move was successful (the conditions specified above are
     * met)
     */
    public boolean moveShip(ShipKind kind, char colPos, int rowPos, ShipDirection direction) {
        if (ready) {
            return false;
        }
        if (!hasShip(kind)) {
            return false;
        }
        boolean result = false;

        //find the old placement
        ShipPlacement oldPlacement = null;
        for (ShipPlacement shipPlacement : shipPlacements) {
            if (kind.equals(shipPlacement.kind)) {
                oldPlacement = shipPlacement;
            }
        }
        if (oldPlacement != null) {
            //remove the old placement
            for (int i = 0; i < oldPlacement.kind.getLength(); i++) {
                if (oldPlacement.direction.equals(ShipDirection.HORIZONTAL)) {
                    emptyField((char) (oldPlacement.colPos + i), oldPlacement.rowPos);
                } else {
                    emptyField(oldPlacement.colPos, oldPlacement.rowPos + i);
                }
            }
            shipPlacements.remove(oldPlacement);

            //try to place the new ship
            result = setShip(kind, colPos, rowPos, direction);
            if (result) {
                shipPlacements.add(new ShipPlacement(kind, colPos, rowPos, direction));
            } else {
                //if placing failed, put the old ship back
                for (int i = 0; i < oldPlacement.kind.getLength(); i++) {
                    if (oldPlacement.direction.equals(ShipDirection.HORIZONTAL)) {
                        occupyField((char) (oldPlacement.colPos + i), oldPlacement.rowPos);
                    } else {
                        occupyField(oldPlacement.colPos, oldPlacement.rowPos + i);
                    }
                }
                shipPlacements.add(oldPlacement);
            }
        }
        return result;
    }

    /**
     * Place a ship on a specified location. This can only be done before
     * readying and only if the ship was not already placed. Also impossible if
     * one of the specified fields is occupied.
     *
     * @param kind ship type
     * @param colPos start column of placement
     * @param rowPos start row of placement
     * @param direction horizontal or vertical direction of the placement
     * @return if the placement was successful (the conditions specified above
     * are met)
     */
    public boolean placeShip(ShipKind kind, char colPos, int rowPos, ShipDirection direction) {
        if (ready) {
            return false;
        }
        if (hasShip(kind)) {
            return false;
        }
        boolean result = setShip(kind, colPos, rowPos, direction);
        if (result) {
            shipPlacements.add(new ShipPlacement(kind, colPos, rowPos, direction));
        }
        return result;
    }

    /**
     * Set the specified fields to occupied. This can only be done of the fields
     * weren't already occupied.
     *
     * @param kind ship type
     * @param colPos start column of placement
     * @param rowPos start row of placement
     * @param direction horizontal or vertical direction of the placement
     * @return if the fields have successfully been set to occupied (the
     * conditions specified above were met) are met)
     */
    private boolean setShip(ShipKind kind, char colPos, int rowPos, ShipDirection direction) {
        if (direction.equals(ShipDirection.HORIZONTAL)) {
            for (int i = 0; i < kind.getLength(); i++) {
                if (!checkPosition((char) (colPos + i), rowPos)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < kind.getLength(); i++) {
                if (!checkPosition(colPos, rowPos + i)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < kind.getLength(); i++) {
            if (direction.equals(ShipDirection.HORIZONTAL)) {
                occupyField((char) (colPos + i), rowPos);
            } else {
                occupyField(colPos, rowPos + i);
            }
        }
        return true;
    }

    /**
     * Check if a position in own grid is empty
     *
     * @param colPos
     * @param rowPos
     * @return true if the position is empty
     */
    private boolean checkPosition(char colPos, int rowPos) {
        if (Character.toUpperCase(colPos) > 'J' || rowPos > 10) {
            return false;
        }
        return ownGrid.get(colPos).get(rowPos).getState().equals(FieldState.EMPTY);
    }

    /**
     * set a field in own grid to occupied
     *
     * @param colPos
     * @param rowPos
     */
    private void occupyField(char colPos, int rowPos) {
        ownGrid.get(colPos).get(rowPos).setState(FieldState.OCCUPIED);
    }

    /**
     * set a field in own grid to empty
     *
     * @param colPos
     * @param rowPos
     */
    private void emptyField(char colPos, int rowPos) {
        ownGrid.get(colPos).get(rowPos).setState(FieldState.EMPTY);
    }

    /**
     *
     * @param colPos
     * @param rowPos
     * @return false if you weren't able or allowed to shoot
     */
    public boolean shootOpponent(char colPos, int rowPos) {
        if (!game.isReady() || game.isGameOver() || !myTurn) {
            return false;
        }
        if (!opponentGrid.get(colPos).get(rowPos).getState().equals(FieldState.EMPTY)) {
            return false;
        }
        if (game.getOpponent(this).getShot(colPos, rowPos)) {
            opponentGrid.get(colPos).get(rowPos).setState(FieldState.HIT);
            if(game.isGameOver()){
                won = true;
            }
        } else {
            opponentGrid.get(colPos).get(rowPos).setState(FieldState.MISS);
        }
        myTurn = false;
        return true;
    }

    /**
     *
     * @param colPos
     * @param rowPos
     * @return true if you got hit, false if you didn't
     */
    public boolean getShot(char colPos, int rowPos) {
        Field targetField = ownGrid.get(colPos).get(rowPos);
        myTurn();
        if (targetField.getState().equals(FieldState.OCCUPIED)) {
            targetField.setState(FieldState.HIT);
            hitCounter++;
            if (hitCounter == 17) {
                game.gameOver();
                won = false;
            }
            return true;
        } else {
            targetField.setState(FieldState.MISS);
            return false;
        }
    }

    public Grid getOwnGrid() {
        return ownGrid;
    }

    public Grid getOpponentGrid() {
        return opponentGrid;
    }

}
