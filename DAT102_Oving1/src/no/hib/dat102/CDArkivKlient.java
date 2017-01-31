package no.hib.dat102;

import no.hib.dat102.adt.CDarkivADT;

public class CDArkivKlient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int antallCDer = Fil.antallCDerFraFil("fil.txt");
		CDarkivADT cda = new CDarkiv(antallCDer);
		Fil.lesFraFil(cda, "fil.txt");
		Meny meny = new Meny(cda);
		meny.start();
	}

}
