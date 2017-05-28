fun main(args: Array<String>) {
    GameModel.resetGame()
    GamePresenter.setGameView(object : GameView{
        override fun update(model: GameModel) {

        }
    })
    GamePresenter.onDeckTap()
    GameModel.printGamePlay()
}