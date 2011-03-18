package fr.arpinum.kata.garros;

public class ScoreEgalité extends Score {

	public ScoreEgalité() {
		super(0, 0);
	}

	@Override
	public String toString() {
		return "Egalité";
	}

	@Override
	public Score joueurUnMarque() {
		return new ScoreAvantageJoueurUn();
	}

	@Override
	public Score joueurDeuxMarque() {
		return new ScoreAvantageJoueurDeux();
	}
}
