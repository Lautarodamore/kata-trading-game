package com.kata_trading_game.usecases

import com.kata_trading_game.domain.PlayerFactory
import com.kata_trading_game.domain.Shuffler
import com.kata_trading_game.infrastructure.PlayerFactoryImpl
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StartGameShould {
    @Test fun `return 30 as the initial health of the human player`() {
        val response = startGame().execute()

        assertThat(response.humanHealth).isEqualTo(30)
    }

    @Test fun `return 30 as the initial health of the computer player`() {
        val response = startGame().execute()

        assertThat(response.computerHealth).isEqualTo(30)
    }

    @Test fun `return 0 as the initial mana of the human player`() {
        val response = startGame().execute()

        assertThat(response.humanMana).isEqualTo(0)
    }

    @Test fun `return 0 as the initial mana of the computer player`() {
        val response = startGame().execute()

        assertThat(response.computerMana).isEqualTo(0)
    }

    @Test fun `return 0 as the initial mana slots of the human player`() {
        val response = startGame().execute()

        assertThat(response.humanManaSlots).isEqualTo(0)
    }

    @Test fun `return 0 as the initial mana slots of the computer player`() {
        val response = startGame().execute()

        assertThat(response.computerManaSlots).isEqualTo(0)
    }

    @Test fun `extract and return the 3 top cards from the deck as the initial draw of the human player`() {
        simulateRandomCards(humanPlayerCards)

        val response = startGame().execute()

        assertThat(response.humanTakenCards).containsExactlyElementsOf(humanPlayerCards.subList(0, 3))
        assertThat(response.humanRemainingCards).isEqualTo(17)
    }

    @Test fun `extract and return the 4 top cards from the deck as the initial draw of the computer player`() {
        simulateRandomCards(computerPlayerCards)

        val response = startGame().execute()

        assertThat(response.computerTakenCards).containsExactlyElementsOf(computerPlayerCards.subList(0, 4))
        assertThat(response.computerRemainingCards).isEqualTo(16)
    }

    @BeforeEach fun setup() {
        simulateRandomCards(mutableListOf())
    }

    private fun startGame() = StartGame(playerFactory)

    private fun simulateRandomCards(cards: MutableList<Int>) {
        every { shuffler.shuffle(any()) } returns cards
        playerFactory = PlayerFactoryImpl(shuffler)
    }

    private val shuffler = mockk<Shuffler>()
    private val humanPlayerCards = mutableListOf(0, 1, 5, 0, 1, 2, 2, 3, 2, 3, 3, 4, 3, 4, 5, 4, 6, 7, 6, 8)
    private val computerPlayerCards = mutableListOf(3, 4, 3, 4, 5, 4, 6, 7, 6, 8, 0, 1, 5, 0, 1, 2, 2, 3, 2, 3)
    private lateinit var playerFactory: PlayerFactory
}
