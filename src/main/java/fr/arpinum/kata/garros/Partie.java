package fr.arpinum.kata.garros;

import java.util.Arrays;
import java.util.List;

public class Partie {

	private Score score = new ScoreInitial();

	public Score score(final Joueurs... séquence) {
		final List<Joueurs> points = Arrays.asList(séquence);
		for (final Joueurs joueur : points) {
			if (joueur == Joueurs.J1) {
				joueurUnMarque();
			} else {
				joueurDeuxMarque();
			}
		}
		return score;
	}

	public void joueurUnMarque() {
		score = score.joueurUnMarque();
	}

	private void joueurDeuxMarque() {
		score = score.joueurDeuxMarque();
	}

}
