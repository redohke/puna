package fi.omapizzeria.security;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import fi.omapizzeria.sivusto.bean.WebUser;

public class UserGenerator {
	public static void main(String[] args) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		String selkokielinenSalasana;
		String suola;
		String kryptattuSalasana;
		Scanner lukija = new Scanner(System.in);
		System.out.println("Anna selkokielinen salasana");
		selkokielinenSalasana = lukija.nextLine();
		suola = Salaaja.generoiSuola();
		kryptattuSalasana = Salaaja.salaa(selkokielinenSalasana, suola,
				Salaaja.SHA512, 100);
		System.out.println("SUOLA: " + suola);
		System.out.println("KRYPTATTU SALASANA (SHA-512, 100krt): "
				+ kryptattuSalasana);
	}
}