package com.kata_trading_game.infrastructure

import com.kata_trading_game.domain.TurnMachine
import kotlin.random.Random

class SystemTurnMachine: TurnMachine {
    private var currentTurn = Random.nextBoolean()

    override fun next(): Int {
        currentTurn = !currentTurn
        return toInt()
    }

    private fun toInt() = if (currentTurn) 0 else 1
}
