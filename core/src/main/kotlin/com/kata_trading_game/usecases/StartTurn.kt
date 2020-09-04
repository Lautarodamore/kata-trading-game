package com.kata_trading_game.usecases

import com.kata_trading_game.domain.CurrentGame
import com.kata_trading_game.domain.Game
import com.kata_trading_game.domain.Shuffler
import com.kata_trading_game.domain.TurnMachine

class StartTurn(
    private val currentGame: CurrentGame
) {
    fun execute(): Response {
        val game = currentGame.value!!
        game.activePlayer().increaseMana()
        game.activePlayer().fillMana()

        return Response(
            game.humanHealth,
            game.humanAvailableMana,
            game.humanManaSlot,
            game.humanHand,
            game.humanRemainingCards,
            game.computerHealth,
            game.computerAvailableMana,
            game.computerManaSlot,
            game.computerRemainingCards
        )
    }

    data class Response(
        val activePlayerHealth: Int,
        val activePlayerMana: Int,
        val activePlayerManaSlots: Int,
        val activePlayerHand: List<Int>,
        val activePlayerRemainingCards: Int,
        val awaitingPlayerHealth: Int,
        val awaitingPlayerMana: Int,
        val awaitingPlayerManaSlots: Int,
        val awaitingPlayerRemainingCards: Int
    )
}
