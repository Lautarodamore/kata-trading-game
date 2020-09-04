package com.kata_trading_game

import com.kata_trading_game.usecases.StartGame


class Game(private val display: Display, private val startGame: StartGame) {
    fun start() {
        display.writeLn("Welcome")
        val stats = startGame.execute()
        display.writeLn("Computer status: Health: ${stats.awaitingPlayerHealth} - Mana: ${stats.awaitingPlayerMana}/${stats.awaitingPlayerManaSlots}")
        display.writeLn("Your status: Cards: ${stats.activePlayerTakenCards.joinToString(", ")} (${stats.activePlayerRemainingCards} left) - Health: ${stats.activePlayerHealth} - Mana: ${stats.activePlayerMana}/${stats.activePlayerManaSlots}")
        display.writeLn("Press space to pick a card from your deck to start the turn...")
    }

    fun startTurn() {
        System.`in`.read()
    }
}
