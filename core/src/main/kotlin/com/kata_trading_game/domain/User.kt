package com.kata_trading_game.domain

class User(private val deck: Deck) {
    val health = 30
    val mana = Mana.empty()

    fun takeCards(count: Int) = deck.take(count)

    fun remainingCards() = deck.count()
}
