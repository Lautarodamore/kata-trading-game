package com.kata_trading_game.domain

class User(private val name: String, private val deck: Deck) {
    val health = 30
    var mana = Mana.empty()
    var hand = listOf<Int>()

    fun takeCards(count: Int) {
        hand = deck.take(count)
    }

    fun remainingCards() = deck.count()

    override fun toString() = "User($name)"

    fun increaseMana() {
        mana = mana.increase()
    }

    fun fillMana() {
        mana = mana.fill()
    }
}
