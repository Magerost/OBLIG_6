package Oppgave1;

public abstract class Kort implements Comparable<Kort>, Cloneable {

	private static int antallKort;
	private String fornavn;
	private String etternavn;
	private int pin;
	private int kortnummer;
	private boolean sperretKort;

	public Kort(String fornavn, String etternavn, int pin) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.pin = pin;
		kortnummer = ++antallKort;
		sperretKort = false;
	}

	public abstract boolean sjekkPin(int pin);

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getPin() {
		return pin;
	}

	public int getKortnummer() {
		return kortnummer;
	}

	public boolean isSperret() {
		return sperretKort;
	}

	public void toogleSperret() {
		sperretKort = !sperretKort;
	}

	@Override
	public String toString() {
		return "Fornavn: " + fornavn + ", Etternavn: " + etternavn + ", Pin: "
				+ pin + ", Kortnummer: " + kortnummer + ", Er sperret? "
				+ sperretKort;
	}

	@Override
	public int compareTo(Kort o) {

		if (o ==null)
			return -1;
		if (this.getEtternavn().compareTo(o.getEtternavn()) < 0) {
			return -1;
			
		} else if (this.getFornavn().compareTo(o.getEtternavn()) > 0) {
			return 1;
			
		} else if (this.getFornavn().compareTo(o.getFornavn()) < 0) {
			return -1;
		
			
		} else if (this.getFornavn().compareTo(o.getFornavn()) > 0) {
			return 1;
			
		} else
			return 0;
			
	}

	@Override
	public Object clone() {
		try {
			Kort clone = (Kort) super.clone();
			clone.setFornavn(new String(this.getFornavn()));
			clone.setEtternavn(new String(this.getEtternavn()));
			return clone;

		} catch (CloneNotSupportedException e) {
			return null;

		}
	}
}