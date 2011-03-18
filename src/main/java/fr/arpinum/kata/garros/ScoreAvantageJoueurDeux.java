package fr.arpinum.kata.garros;

public class ScoreAvantageJoueurDeux extends Score {

	public ScoreAvantageJoueurDeux() {
		super(0, 0);
	}

	@Override
	public String toString() {
		return "Avantage joueur 2";
	}

	@Override
	public Score joueurUnMarque() {
		return new ScoreEgalité();
	}

	@Override
	public Score joueurDeuxMarque() {
		return new ScoreInitial();
	}
}
