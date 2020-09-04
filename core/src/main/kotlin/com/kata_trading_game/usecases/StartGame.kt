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
        game.activePlayer().takeCards(3)
        game.activePlayer().increaseMana()
        game.activePlayer().fillMana()
        game.awaitingPlayer().takeCards(4)

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
        val humanHealth: Int,
        val humanMana: Int,
        val humanManaSlots: Int,
        val humanTakenCards: List<Int>,
        val humanRemainingCards: Int,
        val computerHealth: Int,
        val computerMana: Int,
        val computerManaSlots: Int,
        val computerRemainingCards: Int
    )
}
