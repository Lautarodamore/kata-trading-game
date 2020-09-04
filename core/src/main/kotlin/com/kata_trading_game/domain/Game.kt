package com.kata_trading_game.domain

class Game(shuffler: Shuffler, turnMachine: TurnMachine) {
    val humanUser = User("Human", Deck(shuffler))
    val computerUser = User("Computer", Deck(shuffler))
    private val turn = turnMachine.next()

    val activePlayer get() = if (turn == 0) humanUser else computerUser
    val awaitingPlayer get() = if (turn == 0) computerUser else humanUser
}
