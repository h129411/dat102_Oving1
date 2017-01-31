package no.hib.dat102.adt;
import no.hib.dat102.*;

public interface CDarkivADT {
	// Bruk gjerne javadoc her i 
	// stedet for vanlige
    // kommentarlinjer som her
	//Returnere en tabell av CD-er
	CD[] hentCdTabell();
	//Legger til en ny CD
	void leggTilCd(CD nyCd);
	// Sletter en CD hvis den fins
	boolean slettCd(int cdNr);
	//Søker og henter CD-er med en gitt delstreng 
	CD[] sokTittel(String delstreng);
	//Søker og henter artister med en gitt delstreng 
	CD[] sokArtist(String delstreng);
	// Henter antall CD-er
	int hentAntall();//
	//Henter antall CD-er for en gitt sjanger 
	int hentAntall(Sjanger sjanger);
}
