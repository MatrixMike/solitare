/**
 * The model layer of the game
 */
object GameModel {
    val deck = Deck()
    val wastePile: MutableList<Card> = mutableListOf()
    val tableauPiles = Array(7, { TableauPile() })
    val foundationPiles = arrayOf(FoundationPile(CLUBS), FoundationPile(DIAMONDS),
            FoundationPile(HEARTS), FoundationPile(SPADES))

    fun resetGame() {
        wastePile.clear()
        foundationPiles.forEach { it.reset() }
        deck.reset()
        tableauPiles.forEachIndexed { i, _ ->
            tableauPiles[i] = TableauPile(Array(i + 1, { deck.drawCard() }).toMutableList())
        }
    }

    fun onDeckTap() {
        if (deck.cardsInDeck.isNotEmpty()) {
            val card = deck.drawCard()
            card.faceUp = true
            wastePile.add(card)
        } else {
            deck.cardsInDeck = wastePile.toMutableList()
            wastePile.clear()
        }
    }

    fun onWasteTap() {
        if (wastePile.isNotEmpty()) {
            val card = wastePile.last()
            if (playCard(card)) wastePile.remove(card)
        }
    }

    fun onFoundationTap(foundationIndex: Int) {
        val foundationPile = foundationPiles[foundationIndex]
        if (foundationPile.isNotEmpty()) {
            val card = foundationPile.last()
            if (playCard(card)) foundationPile.removeCard(card)
        }
    }

    fun onTableauTap(tableauIndex: Int, cardIndex: Int) {
        val tableauPile = tableauPiles[tableauIndex]
        if (tableauPile.isNotEmpty()) {
            val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex + 1)
            if (playCards(cards)) tableauPile.removeCards(cardIndex)
        }
    }

    private fun playCards(cards: MutableList<Card>): Boolean {
        if (cards.size == 1) return playCard(cards.first())
        else tableauPiles.forEach { if (it.addCards(cards)) return true }
        return false
    }

    private fun playCard(card: Card): Boolean {
        foundationPiles.forEach { if (it.addCard(card)) return true }
        tableauPiles.forEach { if (it.addCards(mutableListOf(card))) return true }
        return false
    }

    fun printGamePlay() {
        val pad = "   "
        val blank = "___"
        var firstLine = (if (wastePile.isNotEmpty()) "${wastePile.last()}" else blank).padEnd(18)
        foundationPiles.forEach { firstLine += (if (it.isNotEmpty()) "${it.last()}" else blank) + pad }
        println(firstLine)
        println()
        for (i in 0..12) {
            var row = ""
            tableauPiles.forEach { row += (if (it.cards.size > i) "${it.cards[i]}" else pad) + pad }
            println(row)
        }
    }
}