/**
 * TableauPile model
 */
class TableauPile(var cards: MutableList<Card> = mutableListOf()) {

    init {
        if (cards.isNotEmpty()) cards.last().faceUp = true
    }

    fun addCards(newCards: MutableList<Card>): Boolean {

        if (newCards.isEmpty()) return false

        val first = newCards.first()

        if (cards.isNotEmpty()) {
            val last = cards.last()
            if (first.value == last.value - 1 && suitCheck(first, last))
                return cards.addAll(newCards)
        } else if (first.value == Card.Value(12)) return cards.addAll(newCards)

        return false
    }

    fun removeCard(tappedIndex: Int) {
        for (i in tappedIndex .. cards.lastIndex) cards.removeAt(tappedIndex)
        if (cards.isNotEmpty()) cards.last().faceUp = true
    }

    private fun suitCheck(first: Card, last: Card): Boolean =
            first.isRed() && last.isBlack() || first.isBlack() && last.isRed()

}