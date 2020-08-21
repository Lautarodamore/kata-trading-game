package com.kata_trading_game.usecases

import com.kata_trading_game.domain.CurrentGame
import com.kata_trading_game.domain.Game
import com.kata_trading_game.domain.Shuffler
import com.kata_trading_game.domain.TurnMachine

class StartGame(
    private val currentGame: CurrentGame,
    private val shuffler: Shuffler,
    private val turnMachine: TurnMachine
) {
    fun execute(): Response {
        val game = Game(shuffler, turnMachine)
        currentGame.value = game

        return Response(
            game.humanHealth,
            game.humanAvailableMana,
            game.humanManaSlot,
            game.humanHand,
            game.humanRemainingCards,
            game.computerHealth,
            game.computerAvailableMana,
            game.computerManaSlot,
            game.computerHand,
            game.computerRemainingCards
        )
    }

    data class Response(
        val humanHealth: Int,
        val humanMana: Int,
        val humanManaSlots: Int,
        val humanTakenCards: List<Int>,
        val humanRemainingCards: Int,
        val computerHealth: Int,
        val computerMana: Int,
        val computerManaSlots: Int,
        val computerTakenCards: List<Int>,
        val computerRemainingCards: Int
    )
}
