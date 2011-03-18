package fr.arpinum.kata.garros;

import static fr.arpinum.kata.garros.Joueurs.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestsPartie {

	@Test
	public void leScoreEstA0PartoutAuDébut() {
		testScore("0 partout");
	}

	@Test
	public void leJoueurUnMarqueLePremier() {
		testScore("15 - 0", J1);
	}

	@Test
	public void leJoueurUnMarqueLesDeuxPremiersPoints() {
		testScore("30 - 0", J1, J1);
	}

	@Test
	public void leJoueurUnMarqueLesTroisPremiersPoints() {
		testScore("40 - 0", J1, J1, J1);
	}

	@Test
	public void leJoueurUnRemporteLeJeu() {
		testScore("0 partout", J1, J1, J1, J1);
	}

	@Test
	public void leJoueurUnRemporteLeJeuEtMarqueUnPoint() {
		testScore("15 - 0", J1, J1, J1, J1, J1);
	}

	@Test
	public void leJoueurDeuxMarqueLePremierPoint() {
		testScore("0 - 15", J2);
	}

	@Test
	public void leJoueurDeuxMarqueDesPoints() {
		testScore("0 - 15", J2);
		testScore("0 - 30", J2, J2);
		testScore("0 - 40", J2, J2, J2);
		testScore("0 partout", J2, J2, J2, J2);
	}

	@Test
	public void leJoueurUnEtDeuxMarquent() {
		testScore("15 - 15", J2, J1);
		testScore("15 - 15", J1, J2);
	}

	@Test
	public void lesJoueursSontEnEgalité() {
		testScore("Egalité", J2, J2, J2, J1, J1, J1);
	}

	@Test
	public void leJoueurUnPrendLAvantage() {
		testScore("Avantage joueur 1", J2, J2, J2, J1, J1, J1, J1);
	}

	@Test
	public void leJoueurUnRemporteLeJeuAprèsAvantage() {
		testScore("0 partout", J2, J2, J2, J1, J1, J1, J1, J1);
	}

	@Test
	public void leJoueurDeuxRecolleAuScore() {
		testScore("Egalité", J2, J2, J2, J1, J1, J1, J1, J2);
	}

	@Test
	public void leJoueurUnReprendLAvantage() {
		testScore("Avantage joueur 1", J2, J2, J2, J1, J1, J1, J1, J2, J1);
	}

	@Test
	public void leJoueurDeuxPrendLAvantage() {
		testScore("Avantage joueur 2", J2, J2, J2, J1, J1, J1, J2);
	}

	@Test
	public void leJoueurUnRecolleAuScore() {
		testScore("Egalité", J2, J2, J2, J1, J1, J1, J2, J1);
	}

	@Test
	public void leJoueurDeuxRemporteLeJeuAprèsAvantage() {
		testScore("0 partout", J2, J2, J2, J1, J1, J1, J2, J2);
	}

	private void testScore(final String attendu, final Joueurs... séquence) {
		final Partie partie = new Partie();
		final Score score = partie.score(séquence);
		assertThat(score, notNullValue());
		assertThat(score.toString(), is(attendu));
	}

}
