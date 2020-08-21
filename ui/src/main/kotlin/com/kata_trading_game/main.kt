package com.kata_trading_game

import com.kata_trading_game.infrastructure.PlayerFactoryImpl
import com.kata_trading_game.infrastructure.SystemShuffler
import com.kata_trading_game.usecases.StartGame

fun main() {
    val game = Game(SystemDisplay(), StartGame(PlayerFactoryImpl(SystemShuffler())))
    game.start()
}
