import org.junit.Before
import org.junit.Test

class GameTest {

    @Before
    fun setUpTest() {
        GamePresenter.setGameView(object : GameView {
            override fun update(model: GameModel) {}
        })
    }

    @Test
    fun kingInFirstFoundationPile() {
        val maxGames = 100_000
        var numGames = 0
        for (i in 1..maxGames) {
            GameModel.resetGame()
            numGames++
            for (j in 1..100) {
                GamePresenter.onDeckTap()
                GamePresenter.onWasteTap()
                GameModel.tableauPiles.forEachIndexed { index, tableauPile ->
                    GamePresenter.onTableauTap(index, tableauPile.cards.lastIndex)
                }
            }

            if (GameModel.foundationPiles[0].cards.size == 13) break
        }

        GameModel.printGamePlay()
        println("Games played: $numGames")
        assert(numGames < maxGames)
    }
}