package com.kata_trading_game

import com.kata_trading_game.usecases.StartGame
import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameShould {
    @Test fun `start the game and show user turn after welcome message on start`() {
        every { startGame.execute() } returns StartGame.Response(
            activePlayerHealth = 30,
            activePlayerMana = 0,
            activePlayerManaSlots = 0,
            activePlayerTakenCards = listOf(0, 1, 5),
            activePlayerRemainingCards = 17,
            awaitingPlayerHealth = 30,
            awaitingPlayerMana = 0,
            awaitingPlayerManaSlots = 0,
            awaitingPlayerRemainingCards = 16
        )

        game.start()

        verify { startGame.execute() }
        verifySequence {
            display.writeLn("Welcome")
            display.writeLn("Computer status: Health: 30 - Mana: 0/0")
            display.writeLn("Your status: Cards: 0, 1, 5 (17 left) - Health: 30 - Mana: 0/0")
            display.writeLn("Press space to pick a card from your deck to start the turn...")
        }
    }

    @Test fun `start computer turn on start if computer is the starting player`() {
        every { startGame.execute() } returns StartGame.Response(
            activePlayerHealth = 30,
            activePlayerMana = 0,
            activePlayerManaSlots = 0,
            activePlayerTakenCards = listOf(0, 1, 5),
            activePlayerRemainingCards = 17,
            awaitingPlayerHealth = 30,
            awaitingPlayerMana = 0,
            awaitingPlayerManaSlots = 0,
            awaitingPlayerRemainingCards = 16
        )
        game.start()

        game.startTurn()

        verifySequence {
            display.writeLn("Computer status: Health: 30 - Mana: 0/0")
            display.writeLn("Your status: Cards: 0, 1, 5 (17 left) - Health: 30 - Mana: 0/0")
            display.writeLn("Press space to pick a card from your deck to start the turn...")
        }
    }

    @BeforeEach fun setup() {
        every { startGame.execute() } returns StartGame.Response(
            activePlayerHealth = 30,
            activePlayerMana = 0,
            activePlayerManaSlots = 0,
            activePlayerTakenCards = listOf(0, 1, 5),
            activePlayerRemainingCards = 17,
            awaitingPlayerHealth = 30,
            awaitingPlayerMana = 0,
            awaitingPlayerManaSlots = 0,
            awaitingPlayerRemainingCards = 16
        )
    }

    private val startGame = mockk<StartGame>()
    private val display = mockk<Display>(relaxed = true)
    private val game = Game(display, startGame)
}