package com.kata_trading_game

class SystemShuffler: Shuffler {
    override fun shuffle(cards: List<Int>): List<Int> {
        return cards.shuffled()
    }
}
