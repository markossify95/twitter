package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * 
 * This class is used for basic activities with twitter messages
 * @author Marko Kostadinovic
 * @version 1.0 - basic functionality
 * @see com.twitter.poruke.TwitterPoruka
 */
public class Twitter {
	/**
	 * this attribute presents the list of messages
	 * 
	 * for information about the type of objects that 
	 * this list contains:
	 * @see com.twitter.poruke.TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke =
	new LinkedList<TwitterPoruka>();
	
	/**
	 * Use it to get all the messages from Twitter
	 * @return poruke - list of all messages
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * this method is used for entering the new TwitterPoruka object
	 * @param korisnik - String, name of an user
	 * @param poruka - String, appropriate message
	 * @see com.twitter.poruke.TwitterPoruka
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Method used to get a wanted number of messages that contain a certain hash tag
	 * @param maxBroj - maximum number of messages
	 * @param tag - desired tag that messages must contain
	 * @throws java.lang.RuntimeException in next situations:
	 * <ul>
	 * 	<li> if tag == null </li>
	 *  <li> if tag is an empty string </li>
	 * </ul>
	 * 
	 * @return an array of messages that contain wanted tag
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0; 
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac+1]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
} 