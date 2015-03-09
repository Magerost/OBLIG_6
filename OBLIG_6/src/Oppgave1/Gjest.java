package Oppgave1;

import java.util.GregorianCalendar;

public class Gjest extends Kort {

	private GregorianCalendar expirationDate;

	public Gjest(String fornavn, String etternavn) {
		super(fornavn, etternavn, 9999);
		GregorianCalendar date = new GregorianCalendar();
		date.add(GregorianCalendar.DAY_OF_MONTH, 7);
		expirationDate = date;

	}

	@Override
	public boolean sjekkPin(int pin) {
		GregorianCalendar date = new GregorianCalendar();

		if (date.after(expirationDate))
			super.toogleSperret();
		if (!this.isSperret() && pin == 9999)
			return true;
		else
			return false;
	}
}
