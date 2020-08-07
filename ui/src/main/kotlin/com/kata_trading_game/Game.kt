package com.kata_trading_game

class Game(private val display: Display, private val startGame: StartGame) {
    fun start() {
        display.writeLn("Welcome")
        display.writeLn("It's your turn...")
        val stats = startGame.execute()
        display.writeLn("(Cards: ${stats.cards.joinToString(", ")} - Health: ${stats.health} - Mana: ${stats.mana}/${stats.manaSlots})")
    }
}
