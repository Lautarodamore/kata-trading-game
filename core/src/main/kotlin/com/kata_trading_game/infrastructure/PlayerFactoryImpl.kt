package com.kata_trading_game.infrastructure

import com.kata_trading_game.domain.Deck
import com.kata_trading_game.domain.PlayerFactory
import com.kata_trading_game.domain.Shuffler
import com.kata_trading_game.domain.User

class PlayerFactoryImpl(private val shuffler: Shuffler): PlayerFactory {
    override fun create() = User(Deck(shuffler))
}
