package com.kata_trading_game

fun main() {
    val deck = Deck(SystemShuffler())
    val game = Game(SystemDisplay(), StartGame(deck))
    game.start()
}
