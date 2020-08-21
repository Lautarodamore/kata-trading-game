package com.kata_trading_game.infrastructure

import com.kata_trading_game.domain.Shuffler

class SystemShuffler: Shuffler {
    override fun shuffle(items: List<Int>): List<Int> {
        return items.shuffled()
    }
}
