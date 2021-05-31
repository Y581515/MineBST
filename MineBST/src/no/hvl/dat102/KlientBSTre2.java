package no.hvl.dat102;

import java.util.*;

public class KlientBSTre2 {
	static int n = 8192;

	public static void main(String[] args) {

		int storst = 0;
		int minst = n;
		int hoyde = 0;
		int snitt = 0;
		int iterasjoner = 100;

		for (int j = 0; j < iterasjoner; j++) {
			hoyde = bsTreGetHoyde();
			if (hoyde > storst) {
				storst = hoyde;
			}
			if (hoyde < minst) {
				minst = hoyde;
			}
			snitt = snitt + hoyde;
		}
		snitt = snitt / 100;

		System.out.println("  i) Noder: " + n);

		System.out.println(" ii) Minimal teoretisk høyde: " + minTeoHoyde(n));

		System.out.println("iii) Maksimal teoretisk høyde: " + (n - 1));

		System.out.println(" iv) Minst målt høyde: " + minst);

		System.out.println("  v) Størst målt høyde: " + storst);

		System.out.println(" vi) Snitt høyde: " + snitt);

		double c = snitt / (Math.log(n) / Math.log(2));

		System.out.println("målt c=" + c);

	}

	private static int bsTreGetHoyde() {
		KjedetBSTre bstre = new KjedetBSTre();
		Random terning = new Random();
		int tall = terning.nextInt();

		for (int i = 0; i < n; i++) {
			bstre.leggTil(tall);
			tall = terning.nextInt();
		}
		return bstre.hoyde();
	}

	private static int minTeoHoyde(int n) {
		return (int) (Math.log(n) / Math.log(2));
	}

}