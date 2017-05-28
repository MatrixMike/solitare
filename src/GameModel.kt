/**
 * The model layer of the game
 */
class GameModel {
    val deck = Deck()
    val wastePile: MutableList<Card> = mutableListOf()
    val foundationPiles = arrayOf(
            FoundationPile(CLUBS),
            FoundationPile(DIAMONDS),
            FoundationPile(HEARTS),
            FoundationPile(SPADES)
    )
}