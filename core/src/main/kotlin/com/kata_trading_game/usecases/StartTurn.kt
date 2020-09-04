package com.kata_trading_game.usecases

import com.kata_trading_game.domain.CurrentGame
import com.kata_trading_game.domain.Game
import com.kata_trading_game.domain.Shuffler
import com.kata_trading_game.domain.TurnMachine

class StartTurn(private val currentGame: CurrentGame) {
    fun execute(): Response {
        val game = currentGame.value!!
        val activePlayer = game.activePlayer
        activePlayer.increaseMana()
        activePlayer.fillMana()

        return Response(activePlayer.mana.slots, activePlayer.mana.available)
    }

    data class Response(val activePlayerManaSlots: Int, val activePlayerAvailableMana: Int)
}
