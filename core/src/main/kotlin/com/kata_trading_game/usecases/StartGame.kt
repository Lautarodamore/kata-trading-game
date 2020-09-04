package com.kata_trading_game.usecases

import com.kata_trading_game.domain.*

class StartGame(
    private val currentGame: CurrentGame,
    private val shuffler: Shuffler,
    private val turnMachine: TurnMachine
) {
    fun execute(): Response {
        val game = Game(shuffler, turnMachine)
        currentGame.value = game
        val activePlayer = game.activePlayer
        val awaitingPlayer = game.awaitingPlayer
        initialSetup(activePlayer, awaitingPlayer)

        return Response(
            activePlayer.health,
            activePlayer.mana.available,
            activePlayer.mana.slots,
            activePlayer.hand,
            activePlayer.remainingCards(),
            awaitingPlayer.health,
            awaitingPlayer.mana.available,
            awaitingPlayer.mana.slots,
            awaitingPlayer.remainingCards()
        )
    }

    private fun initialSetup(activePlayer: User, awaitingPlayer: User) {
        activePlayer.takeCards(3)
        awaitingPlayer.takeCards(4)
    }

    data class Response(
        val activePlayerHealth: Int,
        val activePlayerMana: Int,
        val activePlayerManaSlots: Int,
        val activePlayerTakenCards: List<Int>,
        val activePlayerRemainingCards: Int,
        val awaitingPlayerHealth: Int,
        val awaitingPlayerMana: Int,
        val awaitingPlayerManaSlots: Int,
        val awaitingPlayerRemainingCards: Int
    )
}
