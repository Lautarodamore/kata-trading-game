package com.kata_trading_game

import com.kata_trading_game.domain.CurrentGame
import com.kata_trading_game.infrastructure.SystemShuffler
import com.kata_trading_game.infrastructure.SystemTurnMachine
import com.kata_trading_game.usecases.StartGame

fun main() {
    val game = Game(SystemDisplay(), StartGame(CurrentGame(), SystemShuffler(), SystemTurnMachine()))
    game.start()
}
