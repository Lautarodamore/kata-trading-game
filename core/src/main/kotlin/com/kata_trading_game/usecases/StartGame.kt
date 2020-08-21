package com.kata_trading_game.usecases

import com.kata_trading_game.domain.PlayerFactory

class StartGame(private val playerFactory: PlayerFactory) {
    fun execute(): Response {
        val humanUser = playerFactory.create()
        val computerUser = playerFactory.create()

        return Response(
            humanUser.health,
            humanUser.mana.available,
            humanUser.mana.slots,
            humanUser.takeCards(3),
            humanUser.remainingCards(),
            computerUser.health,
            computerUser.mana.available,
            computerUser.mana.slots,
            computerUser.takeCards(4),
            computerUser.remainingCards()
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