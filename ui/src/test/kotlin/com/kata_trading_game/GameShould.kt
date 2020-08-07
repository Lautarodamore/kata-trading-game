package com.kata_trading_game

import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameShould {
    @Test fun `show welcome message on start`() {
        game.start()

        verify { display.writeLn("Welcome") }
    }

    @Test fun `show user turn after welcome message`() {
        every { startGame.execute() } returns StartGame.Response(cards = listOf(0, 1, 5), health = 30, mana = 0, manaSlots = 0)

        game.start()

        verifySequence {
            display.writeLn("Welcome")
            display.writeLn("It's your turn...")
            display.writeLn("(Cards: 0, 1, 5 - Health: 30 - Mana: 0/0)")
        }
    }

    @BeforeEach fun setup() {
        every { startGame.execute() } returns StartGame.Response(listOf(0, 1, 5), 30, 0, 0)
    }

    private val startGame = mockk<StartGame>()
    private val display = mockk<Display>(relaxed = true)
    private val game = Game(display, startGame)
}