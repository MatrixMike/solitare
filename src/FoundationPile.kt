class FoundationPile(val suit: Card.Suit) {

    val cards: MutableList<Card> = mutableListOf()

    fun reset() = cards.clear()

    fun removeCard(card: Card) = cards.remove(card)

    fun addCard(card: Card): Boolean {

        val nextValue = if (cards.isNotEmpty()) cards.last().value + 1 else 0

        if (card.suit == suit && card.value == Card.Value(nextValue)) return cards.add(card)

        return false
    }
}