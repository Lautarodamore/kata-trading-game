package com.kata_trading_game.usecases

import com.kata_trading_game.domain.CurrentGame
import com.kata_trading_game.domain.Game
import com.kata_trading_game.domain.Shuffler
import com.kata_trading_game.domain.TurnMachine
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StartTurnShould {
    @Test fun `increment the mana slots of the active player`() {
        every { shuffler.shuffle(any()) } returns someShuffledCards
        every { turnMachine.next() } returns computerTurn
        val game = Game(shuffler, turnMachine)
        currentGame.value = game
        val activePlayer = game.activePlayer
        val activePlayerManaSlot = activePlayer.mana.slots

        val response = startTurn().execute()

        assertThat(response.activePlayerManaSlots).isEqualTo(activePlayerManaSlot + 1)
    }

    @Test fun `fill the mana slots of the active player `() {
        every { shuffler.shuffle(any()) } returns someShuffledCards
        every { turnMachine.next() } returns computerTurn
        val game = Game(shuffler, turnMachine)
        currentGame.value = game

        val response = startTurn().execute()

        assertThat(response.activePlayerAvailableMana).isEqualTo(response.activePlayerManaSlots)
    }

    private fun startTurn() = StartTurn(currentGame)

    private val shuffler = mockk<Shuffler>()
    private val turnMachine = mockk<TurnMachine>()
    private val currentGame = CurrentGame()
    private val someShuffledCards = mutableListOf(0, 1, 5, 0, 1, 2, 2, 3, 2, 3, 3, 4, 3, 4, 5, 4, 6, 7, 6, 8)
    private val computerTurn = 1
}
