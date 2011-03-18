package fr.arpinum.kata.garros;

public class ScoreAvantageJoueurUn extends Score {

	public ScoreAvantageJoueurUn() {
		super(0, 0);
	}

	@Override
	public String toString() {
		return "Avantage joueur 1";
	}

	@Override
	public Score joueurUnMarque() {
		return new ScoreInitial();
	}

	@Override
	public Score joueurDeuxMarque() {
		return new ScoreEgalité();
	}
}
