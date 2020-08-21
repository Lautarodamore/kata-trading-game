package com.kata_trading_game.infrastructure

import com.kata_trading_game.domain.TurnMachine

class SystemTurnMachine: TurnMachine {
    override fun next(): Int {
        return 0
    }
}
