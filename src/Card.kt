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

val HEARTS = Card.Suit("hearts")
val DIAMONDS = Card.Suit("diamonds")
val SPADES = Card.Suit("spades")
val CLUBS = Card.Suit("clubs")

/**
 * A model of a Solitaire card
 */
data class Card(val value: Value, val suit: Suit, var faceUp: Boolean = false) {

    val reds = arrayOf(HEARTS, DIAMONDS)
    val blacks = arrayOf(CLUBS, SPADES)

    fun isRed() = reds.contains(suit)

    fun isBlack() = blacks.contains(suit)

    infix fun faceUp(boolean: Boolean) :Card {
        this.faceUp = boolean
        return this
    }

    class Suit(val suit: String) {

        override operator fun equals(other: Any?) = if (other is Suit)
            other.suit == suit else false

        override fun hashCode() = suit.hashCode()
    }

    class Value(val value: Int) {

        infix fun of(suit: Suit) = Card(this, suit)

        operator fun plus(integer: Int) = value + integer

        operator fun minus(integer: Int) = Value(value - integer)

        override operator fun equals(other: Any?) = if (other is Value)
            other.value == value else false

        override fun hashCode() = value.hashCode()

    }
}