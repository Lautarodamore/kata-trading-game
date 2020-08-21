package com.kata_trading_game.domain

class Mana(val available: Int, val slots: Int) {
    companion object {
        fun empty() = Mana(0, 0)
    }
}