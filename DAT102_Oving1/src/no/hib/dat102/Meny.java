package no.hib.dat102;
import java.io.File;

import easyIO.*;
import no.hib.dat102.adt.CDarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	private String filnavn;
	Out skjerm = new Out();
	In tastatur = new In();
	
	public Meny(CDarkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}
	
	public void start() {	
		oppstartMeny();
		hovedMeny();
	}
	
	private void oppstartMeny() {
		skjerm.out("  1:", 7);skjerm.outln("Nytt arkiv", 20);
		skjerm.out("  2:", 7);skjerm.outln("Last inn arkiv", 20);
		skjerm.out("  3:", 7);skjerm.outln("Avslutt", 20);
		oppstartInput();
		
	}
	
	private void hovedMeny() {
		skjerm.outln("****************************");
		skjerm.out("*", 13);skjerm.out("MENY", 14);skjerm.outln("*");
		skjerm.outln("****************************");
		skjerm.out("*  1:", 7);skjerm.out("Les inn ny CD", 20);skjerm.outln("*");
		skjerm.out("*  2:", 7);skjerm.out("Finn CD", 20);skjerm.outln("*");
		skjerm.out("*  3:", 7);skjerm.out("Slett CD", 20);skjerm.outln("*");
		skjerm.out("*  4:", 7);skjerm.out("Skriv statistikk", 20);skjerm.outln("*");
		skjerm.out("*  5:", 7);skjerm.out("Avslutt", 20);skjerm.outln("*");
		skjerm.outln("****************************");
		hovedInput();
		hovedMeny();
	}
	
	private void hovedInput() {
		
		switch (tastatur.next()) {
		case "1":
			skjerm.outln("Legg til CD:");
			CD nyCd = tekstgr.lesCD();
			cda.leggTilCd(nyCd);
			break;
		case "2":
			skjerm.outln("Søk etter:");
			skjerm.out("1", 5);skjerm.outln("Artist");
			skjerm.out("2", 5);skjerm.outln("Albumtittel");
			switch (tastatur.next()) {
			case "1":
				skjerm.outln("Skriv artistnavn:");
				String artist = tastatur.next();
				tekstgr.skrivUtCdArtist(cda, artist);
				break;
			case "2":
				skjerm.outln("Skriv albumtittel:");
				String album = tastatur.next();
				tekstgr.skrivUtCdDelstrengITittel(cda, album);
				break;
			default:
				break;
			}
			break;
		case "3":
			skjerm.outln("Skriv nummeret til CD som skal slettes");
			int cdNummer = Integer.parseInt(tastatur.inWord());
			tekstgr.slettCD(cda, cdNummer);
			break;
		case "4":
			tekstgr.skrivUtStatistikk(cda);
			break;
		case "5":
			Fil.skrivTilFil(cda, filnavn);
			avslutt();
		default:
			start();
			break;
		}
	}
	
	private void oppstartInput() {
		switch (tastatur.next()) {
		case "1":
			System.out.println("Navn på fil: ");
			filnavn = tastatur.inWord() + ".txt";
			if (!Fil.lagNyttArkiv(filnavn)) {
				oppstartMeny();
			}
			break;
		case "2":
			System.out.println("Hvilken av de her vil du ha?: ");
			Fil.printFileList();
			filnavn = tastatur.inWord() + ".txt";
			Fil.lesFraFil(cda, filnavn);
			break;
		case "3":
			avslutt();
		default:
			oppstartMeny();
		}
	}
	
	private void avslutt() {
		System.exit(0);
	}
}

