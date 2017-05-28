val KING = Card.Value(12)
val QUEEN = Card.Value(11)
val JACK = Card.Value(10)
val TEN = Card.Value(9)
val NINE = Card.Value(8)
val EIGHT = Card.Value(7)
val SEVEN = Card.Value(6)
val SIX = Card.Value(5)
val FIVE = Card.Value(4)
val FOUR = Card.Value(3)
val THREE = Card.Value(2)
val TWO = Card.Value(1)
val ACE = Card.Value(0)

val CLUBS = "Clubs"
val HEARTS = "Hearts"
val SPADES = "Spades"
val DIAMONDS = "Diamonds"

/**
 * A model of a Solitaire card
 */
data class Card(val value: Value, val suit: String, var faceUp: Boolean = false) {

    fun isRed() = this.suit == HEARTS || this.suit == DIAMONDS

    fun isBlack() = this.suit == CLUBS || this.suit == SPADES

    infix fun faceUp(boolean: Boolean): Card = this.apply { faceUp = boolean }

    override fun toString() = if (faceUp) "$value".padEnd(2) + getSuitCharacter(suit) else "xxx"

    private fun getSuitCharacter(suit: String) = when (suit) {
        DIAMONDS -> "\u2666"
        CLUBS -> "\u2663"
        HEARTS -> "\u2665"
        SPADES -> "\u2660"
        else -> throw IllegalArgumentException("No such a suit")
    }

    data class Value(val value: Int) {
        val valueNames = arrayOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")

        infix fun of(suit: String) = Card(this, suit)
        operator fun plus(integer: Int) = value + integer
        operator fun minus(integer: Int) = Value(value - integer)
        override fun toString() = valueNames[value]

    }
}