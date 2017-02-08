package no.hib.dat102;
import no.hib.dat102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {

	private int antall;
	private LinearNode<CD> start;
	
	public CDarkiv2(int antall) {
		start = new LinearNode<CD>();
		antall = 0;
	}
	
	public CDarkiv2() {
		start = new LinearNode<CD>();
		antall = 0;
	}
	
	@Override
	public CD[] hentCdTabell() {
		LinearNode<CD> cur = start.getNeste();
		CD[] cdTabell = new CD[antall];
		for (int i=0;i<antall;i++) {
			cdTabell[i] = cur.getElement();
			cur = cur.getNeste();
		}
		return cdTabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> nyNode = new LinearNode<CD>(nyCd);
		nyNode.setNeste(start.getNeste());
		start.setNeste(nyNode);
		antall++;
	}

	@Override
	public boolean slettCd(int cdNr) {
		LinearNode<CD> prev = start;
		LinearNode<CD> cur = start.getNeste();
		boolean funnet = false;
		for (int i=0;i<antall;i++) {
			if (cur.getElement().getNummer() == cdNr) {
				prev.setNeste(cur.getNeste());
				funnet = true;
				antall--;
			}
			prev = cur;
			cur = cur.getNeste();
		}
		return funnet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		LinearNode<CD> cur = start;
		CD[] cdTabell = new CD[antall];
		int antallTreff = 0;
		for (int i=0;i<antall;i++) {
			CD cden = cur.getNeste().getElement();
			if (cden.getAlbum().toUpperCase().contains(delstreng.toUpperCase())) {
				cdTabell[antallTreff] = cden;
				antallTreff++;
			}
			cur = cur.getNeste();
		}
		return trimTab(cdTabell, antallTreff);
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		LinearNode<CD> cur = start;
		CD[] cdTabell = new CD[antall];
		int antallTreff = 0;
		for (int i=0;i<antall;i++) {
			CD cden = cur.getNeste().getElement();
			if (cden.getArtist().toUpperCase().contains(delstreng.toUpperCase())) {
				cdTabell[antallTreff] = cden;
				antallTreff++;
			}
			cur = cur.getNeste();
		}
		return trimTab(cdTabell, antallTreff);
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		LinearNode<CD> cur = start;
		int antallTreff = 0;
		for (int i=0;i<antall;i++) {
			CD cden = cur.getNeste().getElement();
			if (cden.getSjanger() == sjanger) {
				antallTreff++;
			}
			cur = cur.getNeste();
		}
		return antallTreff;
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
}