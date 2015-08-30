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
import java.util.Set;

/**
 *
 * @author Rik Schaaf aka CC007 (http://coolcat007.nl/)
 */
public class Game implements Serializable {

    private Player player1;
    private Player player2;
    private Set<Player> ready;
    private boolean gameOver;

    public Game() {
        this.player1 = new Player(this);
        this.player2 = new Player(this);
        this.gameOver = false;
        player1.myTurn();
    }

    public void reset() {
        this.player1 = new Player(this);
        this.player2 = new Player(this);
        this.gameOver = false;
        player1.myTurn();
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean isReady() {
        return player1.isReady() && player2.isReady();
    }

    public void gameOver() {
        gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Player getOpponent(Player player) {
        if (player.equals(player1)) {
            return player2;
        } else {
            return player1;
        }
    }
}
