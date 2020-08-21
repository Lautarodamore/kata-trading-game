package com.kata_trading_game

import com.kata_trading_game.usecases.StartGame

class Game(private val display: Display, private val startGame: StartGame) {
    fun start() {
        display.writeLn("Welcome")
        display.writeLn("It's your turn...")
        val stats = startGame.execute()
        display.writeLn("(Cards: ${stats.humanTakenCards.joinToString(", ")} (${stats.humanRemainingCards} left) - Health: ${stats.humanHealth} - Mana: ${stats.humanMana}/${stats.humanManaSlots})")
    }
}
