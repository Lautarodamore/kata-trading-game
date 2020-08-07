package com.kata_trading_game

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StartGameShould {
    @Test fun `return 30 as the initial health of the user`() {
        val response = StartGame(deck).execute()

        assertThat(response.health).isEqualTo(30)
    }

    @Test fun `return 0 as the initial mana of the user`() {
        val response = StartGame(deck).execute()

        assertThat(response.mana).isEqualTo(0)
    }

    @Test fun `return 0 as the initial mana slots of the user`() {
        val response = StartGame(deck).execute()

        assertThat(response.manaSlots).isEqualTo(0)
    }

    @Test fun `extract and return 3 random cards from the deck as the initial draw of the user`() {
        val response = StartGame(deck).execute()

        assertThat(response.cards).containsExactly(0, 1, 5)
        assertThat(deck.count()).isEqualTo(17)
    }

    @BeforeEach fun setup() {
        every { shuffler.shuffle(any()) } returns mutableListOf(0, 1, 5, 0, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 6, 6, 7, 8)
        deck = Deck(shuffler)
    }

    private val shuffler = mockk<Shuffler>()
    private lateinit var deck: Deck
}
