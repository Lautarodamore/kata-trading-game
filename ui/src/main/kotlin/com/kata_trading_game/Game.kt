package com.kata_trading_game

import com.kata_trading_game.usecases.StartGame


class Game(private val display: Display, private val startGame: StartGame) {
    fun start() {
        display.writeLn("Welcome")
        val stats = startGame.execute()
        display.writeLn("Computer status: Health: ${stats.computerHealth} - Mana: ${stats.computerMana}/${stats.computerManaSlots}")
        display.writeLn("Your status: Cards: ${stats.humanTakenCards.joinToString(", ")} (${stats.humanRemainingCards} left) - Health: ${stats.humanHealth} - Mana: ${stats.humanMana}/${stats.humanManaSlots}")
        display.writeLn("Press space to pick a card from your deck to start the turn...")
    }

    fun startTurn() {
        System.`in`.read()
    }
}
