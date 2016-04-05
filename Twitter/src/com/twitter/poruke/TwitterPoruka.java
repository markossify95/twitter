package com.twitter.poruke;
/**
 * 
 * 
 * This class is used for editing of 
 * basic twitter user and message details
 * @author Marko Kostadinovic
 * @version 1.0 - basic functionality
 *
 */
public class TwitterPoruka {
	/**
	 * this string is user name
	 */
	private String korisnik;
	/**
	 * this string contains the message 
	 * of the user above
	 */
	private String poruka;
	
	/**
	 * get method for korisnik attribute
	 * @return korisnik - String which contains user name
	 */
	public String getKorisnik() {
	return korisnik;
	}
	/**
	 * Set method for the korisnik String
	 * @param korisnik - String which contains user name
	 * @throws java.lang.RuntimeException in next situations:
	 * <ul>
	 * 	<li> if korisnik == null </li>
	 *  <li> if korisnik is an empty string </li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
	if (korisnik==null || korisnik == "")
	throw new RuntimeException(
	"Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	
	/**
	 * Get method for poruka attribute
	 * @return poruka - string which contains the message
	 */
	public String getPoruka() {
	return this.getPoruka();
	}
	
	/**
	 * Set method for the String poruka
	 * @param poruka - string which contains the message of the user
	 * @throws java.lang.RuntimeException in next situations:
	 * <ul>
	 * 	<li> if poruka == null </li>
	 *  <li> if poruka is longer than 140 chars </li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
	if (poruka==null || this.poruka.length()>140)
	throw new RuntimeException(
	"Poruka mora biti uneta i mora imati najvise 140 znakova");
	this.poruka = poruka;
	}
	
	/**
	 * Override : toString method from the object superclass
	 * @return the TwitterPoruka object in appropriate form 
	 * @since v1.0
	 * @see java.lang.Object
	 */
	public String toString(){
	return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}

