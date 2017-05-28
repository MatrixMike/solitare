import java.util.*

/**
 * A deck of [Card]s
 */
class Deck {

    val cards = Array(52, { Card(getValue(it), getSuit(it)) })
    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    fun drawCard(setFaceUp: Boolean = false) = cardsInDeck.removeAt(0) faceUp setFaceUp

    fun reset() {
        cardsInDeck = cards.toMutableList()
        cardsInDeck.forEach { it faceUp false }
        Collections.shuffle(cardsInDeck)
    }

    private fun getSuit(index: Int) = when (index / 13) {
        0 -> CLUBS
        1 -> DIAMONDS
        2 -> HEARTS
        3 -> SPADES
        else -> throw IllegalArgumentException("I don't know that suit")
    }

    private fun getValue(value: Int) = when (value % 13) {
        0 -> ACE
        1 -> TWO
        2 -> THREE
        3 -> FOUR
        4 -> FIVE
        5 -> SIX
        6 -> SEVEN
        7 -> EIGHT
        8 -> NINE
        9 -> TEN
        10 -> JACK
        11 -> QUEEN
        12 -> KING
        else -> throw IllegalArgumentException("Just to satisfy kotlin")
    }
}