package com.kata_trading_game.usecases

import com.kata_trading_game.domain.CurrentGame
import com.kata_trading_game.domain.Shuffler
import com.kata_trading_game.domain.TurnMachine
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StartGameShould {
    @Test fun `create the game`() {
        startGame().execute()

        assertThat(currentGame.value).isNotNull()
    }

    @Test fun `determinate the starting player`() {
        every { turnMachine.next() } returns activePlayerTurn

        startGame().execute()

        assertThat(currentGame.value!!.activePlayer).isEqualTo(currentGame.value!!.computerUser)
    }

    @Test fun `return 30 as the initial health of each player`() {
        val response = startGame().execute()

        assertThat(response.activePlayerHealth).isEqualTo(30)
        assertThat(response.awaitingPlayerHealth).isEqualTo(30)
    }

    @Test fun `extract and return the 3 top cards from the deck as the initial draw of the starting player`() {
        every { turnMachine.next() } returns activePlayerTurn
        simulateRandomCards(aShuffledDeck)

        val response = startGame().execute()

        assertThat(response.activePlayerRemainingCards).isEqualTo(17)
    }

    @Test fun `extract and return the 4 top cards from the deck as the initial draw of the awaiting player`() {
        every { turnMachine.next() } returns activePlayerTurn
        simulateRandomCards(anotherShuffledDeck)

        val response = startGame().execute()

        assertThat(response.awaitingPlayerRemainingCards).isEqualTo(16)
    }

    @Test fun `extract 1 top card from the deck of the starting player`() {
        every { turnMachine.next() } returns activePlayerTurn
        simulateRandomCards(aShuffledDeck)

        val response = startGame().execute()

        assertThat(response.awaitingPlayerRemainingCards).isEqualTo(16)
    }

    @BeforeEach fun setup() {
        every { turnMachine.next() } returns activePlayerTurn
        simulateRandomCards(mutableListOf())
    }

    private fun startGame() = StartGame(currentGame, shuffler, turnMachine)

    private fun simulateRandomCards(cards: MutableList<Int>) {
        every { shuffler.shuffle(any()) } returns cards
    }

    private val shuffler = mockk<Shuffler>()
    private val turnMachine = mockk<TurnMachine>()
    private val currentGame = CurrentGame()
    private val aShuffledDeck = mutableListOf(0, 1, 5, 0, 1, 2, 2, 3, 2, 3, 3, 4, 3, 4, 5, 4, 6, 7, 6, 8)
    private val anotherShuffledDeck = mutableListOf(3, 4, 3, 4, 5, 4, 6, 7, 6, 8, 0, 1, 5, 0, 1, 2, 2, 3, 2, 3)
    private val activePlayerTurn = 1
}
