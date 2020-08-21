package com.kata_trading_game.domain

interface Shuffler {
    fun shuffle(cards: List<Int>): List<Int>
}
