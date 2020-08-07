package com.kata_trading_game

class StartGame(private val deck: Deck) {
    fun execute(): Response {
        val user = User()
        val cards = deck.take(3)
        return Response(cards, user.health, user.mana.available, user.mana.slots)
    }

    data class Response(val cards: List<Int>, val health: Int, val mana: Int, val manaSlots: Int)
}
