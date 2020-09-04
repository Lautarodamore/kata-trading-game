package com.kata_trading_game.domain

class Game(shuffler: Shuffler, turnMachine: TurnMachine) {
    val humanUser = User("Human", Deck(shuffler))
    val computerUser = User("Computer", Deck(shuffler))
    private val activePlayer = turnMachine.next()

    val humanHealth: Int
        get() = humanUser.health
    val humanAvailableMana: Int
        get() = humanUser.mana.available
    val humanManaSlot: Int
        get() = humanUser.mana.slots
    val humanHand: List<Int>
        get() = humanUser.hand
    val humanRemainingCards: Int
        get() = humanUser.remainingCards()
    val computerHealth: Int
        get() = computerUser.health
    val computerAvailableMana: Int
        get() = computerUser.mana.available
    val computerManaSlot: Int
        get() = computerUser.mana.slots
    val computerHand: List<Int>
        get() = computerUser.hand
    val computerRemainingCards: Int
        get() = computerUser.remainingCards()

    fun activePlayer() = if (this.activePlayer == 0) humanUser else computerUser
    fun awaitingPlayer() = if (this.activePlayer == 0) computerUser else humanUser
}
