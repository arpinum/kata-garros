package fr.arpinum.kata.garros;

import java.util.Map;

import com.google.common.collect.Maps;

public class Score {

	private final int pointsJoueur1;
	private final int pointsJoueur2;
	private static final Map<Integer, String> scores = Maps.newHashMap();
	static {
		scores.put(0, "0");
		scores.put(1, "15");
		scores.put(2, "30");
		scores.put(3, "40");
	}

	public Score(final int pointsJoueur1, final int pointsJoueur2) {
		this.pointsJoueur1 = pointsJoueur1;
		this.pointsJoueur2 = pointsJoueur2;
	}

	@Override
	public String toString() {
		return scoreJoueurUn() + " - " + scoreJoueurDeux();
	}

	private String scoreJoueurDeux() {
		return scores.get(pointsJoueur2);
	}

	private String scoreJoueurUn() {
		return scores.get(pointsJoueur1);
	}

	public Score joueurUnMarque() {
		return scoreSuivant(pointsJoueur1 + 1, pointsJoueur2);
	}

	public Score joueurDeuxMarque() {
		return scoreSuivant(pointsJoueur1, pointsJoueur2 + 1);
	}

	private Score scoreSuivant(final int pointsSuivantsJoueurUn,
			final int pointsSuivantsJoueurDeux) {
		if (joueurRemporteLeJeu(pointsSuivantsJoueurUn)
				|| joueurRemporteLeJeu(pointsSuivantsJoueurDeux)) {
			return new ScoreInitial();
		}
		if (estEnEgalité(pointsSuivantsJoueurUn, pointsSuivantsJoueurDeux)) {
			return new ScoreEgalité();
		}
		return new Score(pointsSuivantsJoueurUn, pointsSuivantsJoueurDeux);
	}

	private boolean estEnEgalité(final int pointsSuivantsJoueurUn,
			final int pointsSuivantsJoueurDeux) {
		return pointsSuivantsJoueurUn == pointsSuivantsJoueurDeux
				&& pointsSuivantsJoueurDeux == 3;
	}

	private boolean joueurRemporteLeJeu(final int pointsSuivantsJoueurUn) {
		return pointsSuivantsJoueurUn == 4;
	}
}
