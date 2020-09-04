package com.kata_trading_game.usecases

import com.kata_trading_game.domain.CurrentGame
import com.kata_trading_game.domain.Shuffler
import com.kata_trading_game.domain.TurnMachine
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StartTurnShould {
    @Test fun `return the status of the active player`() {
        val response = startTurn().execute()

        assertThat(response.activePlayerHealth).isEqualTo(30)
        assertThat(response.activePlayerManaSlots).isEqualTo(1)
        assertThat(response.activePlayerMana).isEqualTo(1)
        assertThat(response.activePlayerHand).containsExactlyElementsOf(anotherShuffledDeck.subList(0, 4))
        assertThat(response.activePlayerRemainingCards).isEqualTo(16)
    }

    @Test fun `return the status of the awaiting player`() {
        val response = startTurn().execute()

        assertThat(response.awaitingPlayerHealth).isEqualTo(30)
        assertThat(response.awaitingPlayerManaSlots).isEqualTo(0)
        assertThat(response.awaitingPlayerMana).isEqualTo(0)
        assertThat(response.awaitingPlayerRemainingCards).isEqualTo(16)
    }

    @BeforeEach fun setup() {
        every { turnMachine.next() } returns computerTurn
        simulateRandomCards(mutableListOf())
    }

    private fun startTurn() = StartTurn(currentGame)

    private fun simulateRandomCards(cards: MutableList<Int>) {
        every { shuffler.shuffle(any()) } returns cards
    }

    private val shuffler = mockk<Shuffler>()
    private val turnMachine = mockk<TurnMachine>()
    private val currentGame = CurrentGame()
    private val aShuffledDeck = mutableListOf(0, 1, 5, 0, 1, 2, 2, 3, 2, 3, 3, 4, 3, 4, 5, 4, 6, 7, 6, 8)
    private val anotherShuffledDeck = mutableListOf(3, 4, 3, 4, 5, 4, 6, 7, 6, 8, 0, 1, 5, 0, 1, 2, 2, 3, 2, 3)
    private val computerTurn = 1
}
