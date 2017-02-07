package no.hib.dat102;
import no.hib.dat102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {

	private int antall;
	private LinearNode<CD> start;
	
	public CDarkiv2(int antall) {
		start = new LinearNode<CD>();
		antall = 0;
	}
	
	@Override
	public CD[] hentCdTabell() {
		LinearNode<CD> fremst = start;
		CD[] cdTabell = new CD[antall + 5];
		for (int i=0;i<antall;i++) {
			cdTabell[i] = start.getElement();
			start = start.getNeste();
		}
		start = fremst;
		return cdTabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		// TODO Auto-generated method stub
		LinearNode<CD> nyNode = new LinearNode<CD>(nyCd);
		nyNode.setNeste(start.getNeste());
		start.setNeste(nyNode);
		antall++;
	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean funnet = false;
		for (int i=1;i<=antall;i++) {
			CD nesteCD = start.getNeste().getElement();
			if (nesteCD.getNummer() == cdNr) {
				funnet = true;
				antall--;
				start.setNeste(start.getNeste().getNeste());
			}
		}
		return funnet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		LinearNode<CD> fremst = start;
		CD[] cdTabell = new CD[antall];
		int antallTreff = 0;
		for (int i=0;i<antall;i++) {
			CD cden = start.getNeste().getElement();
			if (cden.getAlbum().contains(delstreng)) {
				cdTabell[antallTreff] = cden;
				antallTreff++;
			}
			start = start.getNeste();
		}
		start = fremst;
		return trimTab(cdTabell, antallTreff);
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		LinearNode<CD> fremst = start;
		CD[] cdTabell = new CD[antall];
		int antallTreff = 0;
		for (int i=0;i<antall;i++) {
			CD cden = start.getNeste().getElement();
			if (cden.getArtist().contains(delstreng)) {
				cdTabell[antallTreff] = cden;
				antallTreff++;
			}
			start = start.getNeste();
		}
		start = fremst;
		return trimTab(cdTabell, antallTreff);
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		LinearNode<CD> fremst = start;
		int antallTreff = 0;
		for (int i=0;i<antall;i++) {
			CD cden = start.getNeste().getElement();
			if (cden.getSjanger() == sjanger) {
				antallTreff++;
			}
			start = start.getNeste();
		}
		start = fremst;
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
