package no.hib.dat102;

import no.hib.dat102.adt.CDarkivADT;

public class CDArkivKlient {

	public static void main(String[] args) {
		//int antallCDer = Fil.antallCDerFraFil("fil.txt");
		CDarkivADT cda = new CDarkiv(1);
		Fil.lesFraFil(cda, "fil.txt");
		Meny meny = new Meny(cda);
		meny.start();
	}

}
