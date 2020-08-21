package com.kata_trading_game.infrastructure

import com.kata_trading_game.domain.Deck
import com.kata_trading_game.domain.Shuffler
import com.kata_trading_game.domain.User

class PlayerFactory(private val shuffler: Shuffler) {
     fun create() = User(Deck(shuffler))
}
