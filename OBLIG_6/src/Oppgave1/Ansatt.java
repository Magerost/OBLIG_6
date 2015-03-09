package Oppgave1;

import java.util.GregorianCalendar;

public class Ansatt extends Kort implements Fast {

	private GregorianCalendar ansatteTid;
	private double timebetaling;

	public Ansatt(String fornavn, String etternavn, int pin,
			GregorianCalendar ansatteTid, double timebetaling) {
		super(fornavn, etternavn, pin);
		this.ansatteTid = ansatteTid;
		this.timebetaling = timebetaling;

	}

	@Override
	public boolean sjekkPin(int pin) {

		GregorianCalendar tidspunkt = new GregorianCalendar();

		int time = tidspunkt.get(GregorianCalendar.HOUR_OF_DAY);
		int dag = tidspunkt.get(GregorianCalendar.DAY_OF_WEEK);

		if (time < 7 || time > 17 || dag == 1 || dag == 7 && !super.isSperret())
			if (pin == super.getPin())
				return true;
			else
				return false;

		if (!super.isSperret())
			return true;

		return false;
	}

	@Override
	public String getNavn() {

		return super.getFornavn() + " " + super.getEtternavn();
	}

	@Override
	public void setNavn(String navn) {

		String[] navnSplittet = navn.split("\\s");
		super.setFornavn(navnSplittet[0]);
		super.setEtternavn(navnSplittet[1]);

	}

	@Override
	public double beregnKreditt() {

		return FACTOR * timebetaling;
	}

	@Override
	public double beregnBonus() {
		GregorianCalendar Tid = new GregorianCalendar();

		int ≈rNÂ = Tid.get(GregorianCalendar.YEAR);
		int Ansatt≈r = ansatteTid.get(GregorianCalendar.YEAR);

		int ≈rAnsatt = ≈rNÂ - Ansatt≈r;

		return FACTOR * ≈rAnsatt;
	}

}