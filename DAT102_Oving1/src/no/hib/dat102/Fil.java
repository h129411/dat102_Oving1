package no.hib.dat102;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import no.hib.dat102.adt.CDarkivADT;

public class Fil {
	static final String SKILLE = "#";
	/*
	public static int antallCDerFraFil(String filnavn) {
		try {
			FileReader inn = new FileReader(filnavn);
			BufferedReader bufferedReader = new BufferedReader(inn);
			int antallCDer = Integer.parseInt(bufferedReader.readLine());
			bufferedReader.close();
			return antallCDer;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch (IOException e){
			e.printStackTrace();
			return 0;
		} 
	}*/
	
	public static void lesFraFil(CDarkivADT cdarkiv, String filnavn) {
		
		try {
			String linje = null;
			FileReader inn = new FileReader(filnavn);
			BufferedReader bufferedReader = new BufferedReader(inn);
			bufferedReader.readLine();
			while ((linje = bufferedReader.readLine()) != null) {
				CD cd = lastCD(linje);
				cdarkiv.leggTilCd(cd);
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} 
	}
	
	public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn) {
		try {
			FileWriter ut = new FileWriter(filnavn);
			BufferedWriter bufferedWriter = new BufferedWriter(ut);
			int antallCDer = cdarkiv.hentAntall();
			bufferedWriter.write(antallCDer + "\n");
			for (int i=0;i<antallCDer;i++) {
				CD cd = cdarkiv.hentCdTabell()[i];
				String cdString = skrivCD(cd);
				bufferedWriter.write(cdString);
			}
			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static private CD lastCD(String linje) {
		String[] CDinfo= linje.split(SKILLE);
		CD cd = new CD();
		cd.setNummer(Integer.parseInt(CDinfo[0]));
		cd.setArtist(CDinfo[1]);
		cd.setAlbum(CDinfo[2]);
		cd.setAar(Integer.parseInt(CDinfo[3]));
		cd.setSjanger(Sjanger.valueOf(CDinfo[4]));
		cd.setLabel(CDinfo[5]);
		
		return cd;
	}
	
	static private String skrivCD(CD cd) {
		String cdInfoString = 	cd.getNummer() + "#" +
				cd.getArtist() + "#" +
				cd.getAlbum() + "#" +
				cd.getAar() + "#" +
				cd.getSjanger() + "#" +
				cd.getLabel() + "\n";
		return cdInfoString;
	}	
}
