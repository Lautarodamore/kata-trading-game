package com.kata_trading_game.domain

import kotlin.math.min

class Mana(val available: Int, val slots: Int) {
    fun increase() = Mana(this.available, min(this.slots + 1, 10))

    fun fill() = Mana(this.slots, this.slots)

    companion object {
        fun empty() = Mana(0, 0)
    }
}
