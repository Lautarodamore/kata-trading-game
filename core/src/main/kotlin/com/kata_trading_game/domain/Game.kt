package com.kata_trading_game.domain

class Game(shuffler: Shuffler) {
    val humanUser = User(Deck(shuffler))
    val computerUser = User(Deck(shuffler))

    init {
        humanUser.takeCards(3)
        computerUser.takeCards(4)
    }

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
}
