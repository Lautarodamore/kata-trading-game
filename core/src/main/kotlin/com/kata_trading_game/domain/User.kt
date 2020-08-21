package com.kata_trading_game.domain

class User(private val deck: Deck) {
    val health = 30
    var mana = Mana.empty()
    var hand = listOf<Int>()

    fun takeCards(count: Int) {
        hand = deck.take(count)
    }

    fun remainingCards() = deck.count()
}
