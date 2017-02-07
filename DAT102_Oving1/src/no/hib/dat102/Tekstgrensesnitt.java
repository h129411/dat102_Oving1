package no.hib.dat102;
import no.hib.dat102.adt.*;
import easyIO.*;

public class Tekstgrensesnitt {
	Out skjerm = new Out();
	In tastatur = new In();
	
	public CD lesCD() {
		skjerm.outln("Skriv cd nummer:");
		int nummer= Integer.parseInt(tastatur.inWord());
		skjerm.outln("Skriv artistnavn:");
		String artist = tastatur.inLine();
		skjerm.outln("Skriv navn på album:");
		String album = tastatur.inLine();
		skjerm.outln("Skriv utgivelsesår:");
		int aar = Integer.parseInt(tastatur.inWord());
		skjerm.outln("Skriv sjanger:");
		Sjanger sjanger = Sjanger.valueOf(tastatur.inWord());
		skjerm.outln("Skriv plateselskap:");
		String label = tastatur.inLine();
		
		CD cd = new CD(nummer, artist, album, aar, sjanger, label);
		return cd;	
	}
	
	public void slettCD(CDarkivADT cda, int cdNummer) {
		if (cda.slettCd(cdNummer)) {
			skjerm.outln("Slettet cd nr. \"" + cdNummer + "\".");
		} else {
			skjerm.outln("Ingen cd med nummer \"" + cdNummer + "\" funnet.");
		}
	}
	
	public void visCD(CD cd) {
		int marg = 15;
		int nummer = cd.getNummer();
		String artist = cd.getArtist();
		String album = cd.getAlbum();
		int aar = cd.getAar();
		String sjanger = cd.getSjanger().toString();
		String label = cd.getLabel();

		skjerm.outln("----------------------------");
		skjerm.out("CD nummer:", marg);skjerm.outln(nummer);
		skjerm.out("Artist:", marg);skjerm.outln(artist);
		skjerm.out("Album:", marg);skjerm.outln(album);
		skjerm.out("Utgivelsesår:", marg);skjerm.outln(aar);
		skjerm.out("Sjanger:", marg);skjerm.outln(sjanger);
		skjerm.out("Plateselskab:", marg);skjerm.outln(label);
		skjerm.outln("----------------------------");
		skjerm.outln("                            ");
	}
	
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {
		CD[] cdListe = cda.sokTittel(delstreng);
		skjerm.outln(cdListe.length + " treff i albumtittel for \"" + delstreng + "\"");
		for (CD cd : cdListe) {
			visCD(cd);
		}
	}
	
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		CD[] cdListe = cda.sokArtist(delstreng);
		skjerm.outln(cdListe.length + " treff i artist for \"" + delstreng + "\"");
		for (CD cd : cdListe) {
			visCD(cd);
		}
	}
	
	public void skrivUtStatistikk(CDarkivADT cda) {
		skjerm.outln("Totalt antall CDer: " + cda.hentAntall());
		skjerm.outln("Størrelse på tabell (Feilsøk): " + cda.hentCdTabell().length);
		skjerm.outln("Antall CDer i sjanger:");
		for (Sjanger sj : Sjanger.values()) {
			skjerm.outln("    " + sj.toString() + ": " + cda.hentAntall(sj));
		}		
	}
}