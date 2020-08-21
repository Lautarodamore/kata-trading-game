package com.kata_trading_game.domain

class Deck(shuffler: Shuffler) {
    private var cards = shuffler.shuffle(listOf(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8))

    fun take(numberOfCards: Int): List<Int> {
        val cards = cards.take(numberOfCards)
        this.cards = this.cards.drop(numberOfCards)
        return cards
    }

    fun count(): Int {
        return cards.size
    }
}
