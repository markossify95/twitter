/**
 * 
 */
package com.twitter.testUnits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Marko Kostadinovic	
 * this class is used for testing of all cases
 * related to methods from TwitterPoruka class
 *
 */
public class TwitterPorukaTest {
	private TwitterPoruka por;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		por = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		por = null;
	}
	
	//---------------TESTS FOR SET KORISNIK-----------------
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnikOkV1() {
		String korisnik = "Mark";
		por.setKorisnik(korisnik);
		assertEquals(korisnik, por.getKorisnik());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnikOkV2() {
		String korisnik = "K";
		por.setKorisnik(korisnik);
		assertEquals(korisnik, por.getKorisnik());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		por.setKorisnik(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmpty() {
		por.setKorisnik("");
	}
	
	//---------------TESTS FOR SET PORUKA-----------------
	

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPorukaOkV1() {
		String mes = "twitter is the best social network!";
		por.setPoruka(mes);
		assertEquals(mes, por.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPorukaOkV2() {
		String mes = "";
		por.setPoruka(mes);
		assertEquals(mes, por.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaLong(){
		por.setPoruka(
				"twitter is the best social network! twitter is the best social network! twitter is the best social network!twitter is the best social network! twitter is the best social network! twitter is the best social network!");
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		por.setPoruka(null);
	}

	//---------------TESTS FOR toString-------------------
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		por.setKorisnik("Ljilja");
		por.setPoruka("message");
		assertEquals("KORISNIK:"+por.getKorisnik()+" PORUKA:"+por.getPoruka(), por.toString());
	}

}
