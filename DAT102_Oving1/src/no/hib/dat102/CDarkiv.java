package no.hib.dat102;
import no.hib.dat102.adt.*;

public class CDarkiv implements CDarkivADT {

	private CD[] cdTabell;
    private int antall;
	
	public CDarkiv(int antall) {
		cdTabell = new CD[antall];
		this.antall = 0;
	}
	
	public CDarkiv() {
		cdTabell = new CD[10];
		antall = 0;
	}

	@Override
	public CD[] hentCdTabell() {
		return cdTabell;
	}

	@Override
	public void leggTilCd(CD element) {
		if (antall == cdTabell.length) {
			utvidKapasitet();
		}
		cdTabell[antall] = element;
		antall++;
	}
	
	private void utvidKapasitet() {
		CD[] hjelpetabell = new CD[(int) Math.ceil(cdTabell.length*1.1)];
		for (int i = 0; i < cdTabell.length; i++) {
			hjelpetabell[i] = cdTabell[i];
		}
		cdTabell = hjelpetabell;
	}

	@Override
	public boolean slettCd(int cdNr) {
		// Peiser gjennom hele tabellen i tilfelle det er 2 av samme cd.
		boolean funnet = false;
		for (int i=0; i<antall; i++) {
			if (cdTabell[i].getNummer() == cdNr) {
				cdTabell[i] = cdTabell[antall - 1];
				antall--;
				trimTab(cdTabell, antall);
				funnet = true;
			}
		}
		return funnet;
	}

	private CD[] trimTab(CD[] cdtab, int n) {
		CD[] cdtab2 = new CD[n];
		int i = 0;
		while (i < n) {
			cdtab2[i] = cdtab[i];
			i++;
		}
		return cdtab2;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		int antallMatch = 0;
		CD[] matcherSokestreng = new CD[antall];
		for (int i=0; i<antall; i++) {
			if (cdTabell[i].getAlbum().indexOf(delstreng) >= 0) {
				matcherSokestreng[antallMatch] = cdTabell[i];
				antallMatch++;
			}
		}
		return trimTab(matcherSokestreng, antallMatch);
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		int antallMatch = 0;
		CD[] matcherSokestreng = new CD[antall];
		for (int i=0; i<antall; i++) {
			if (cdTabell[i].getArtist().contains(delstreng)) {
				matcherSokestreng[antallMatch] = cdTabell[i];
				antallMatch++;
			}
		}
		return trimTab(matcherSokestreng, antallMatch);
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		int antallMatch = 0;
		for (int i=0; i<antall; i++) {
			if (cdTabell[i].getSjanger() == sjanger) {
				antallMatch++;
			}
		}
		return antallMatch;
	}
}