package com.kata_trading_game

import com.kata_trading_game.usecases.StartGame
import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameShould {
    @Test fun `show welcome message on start`() {
        game.start()

        verify { display.writeLn("Welcome") }
    }

    @Test fun `show user turn after welcome message`() {
        every { startGame.execute() } returns StartGame.Response(
            humanHealth = 30,
            humanMana = 0,
            humanManaSlots = 0,
            humanTakenCards = listOf(0, 1, 5),
            humanRemainingCards = 17,
            computerHealth = 30,
            computerMana = 0,
            computerManaSlots = 0,
            computerTakenCards = listOf(2, 1, 0, 4),
            computerRemainingCards = 16
        )

        game.start()

        verifySequence {
            display.writeLn("Welcome")
            display.writeLn("It's your turn...")
            display.writeLn("(Cards: 0, 1, 5 (17 left) - Health: 30 - Mana: 0/0)")
        }
    }

    @BeforeEach fun setup() {
        every { startGame.execute() } returns StartGame.Response(
            humanHealth = 30,
            humanMana = 0,
            humanManaSlots = 0,
            humanTakenCards = listOf(0, 1, 5),
            humanRemainingCards = 17,
            computerHealth = 30,
            computerMana = 0,
            computerManaSlots = 0,
            computerTakenCards = listOf(2, 1, 0, 4),
            computerRemainingCards = 16
        )
    }

    private val startGame = mockk<StartGame>()
    private val display = mockk<Display>(relaxed = true)
    private val game = Game(display, startGame)
}