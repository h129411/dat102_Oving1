package no.hib.dat102;

public class CD {
	private int nummer;
	private String artist;
	private String album;
	private int aar;
	private Sjanger sjanger;
	private String label;
	
	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getAar() {
		return aar;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public CD() {}

	public CD(int nummer, String artist, String album, int aar, Sjanger sjanger, String label) {
		super();
		this.nummer = nummer;
		this.artist = artist;
		this.album = album;
		this.aar = aar;
		this.sjanger = sjanger;
		this.label = label;
	};
	
}
