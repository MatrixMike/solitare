import junit.framework.TestCase.assertEquals
import org.junit.Test

class TableauPileTest {

    @Test
    fun addCards() {
        val tableauPile = TableauPile(mutableListOf(KING of HEARTS))
        val cards = mutableListOf(QUEEN of SPADES)
        tableauPile.addCards(cards)
        assertEquals(2, tableauPile.cards.size)
    }

    @Test
    fun removeCard() {
        val tableauPile = TableauPile(mutableListOf(FIVE of DIAMONDS, FOUR of CLUBS, THREE of HEARTS))
        tableauPile.removeCards(1)
        assertEquals(mutableListOf(FIVE of DIAMONDS faceUp true), tableauPile.cards)
    }

}