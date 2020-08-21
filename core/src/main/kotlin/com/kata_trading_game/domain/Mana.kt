package com.kata_trading_game.domain

class Mana(val available: Int, val slots: Int) {
    fun slotUp(): Mana {
        return Mana(this.available, recalculateSlots())
    }

    private fun recalculateSlots(): Int {
        if (this.slots > 10) return 10
        return this.slots + 1
    }

    companion object {
        fun empty() = Mana(0, 0)
    }
}
