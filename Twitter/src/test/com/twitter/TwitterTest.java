/**
 * 
 */
package test.com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

/**
 * @author Marko Kostadinovic
 *
 */
public class TwitterTest {
	private Twitter t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		String korisnik = "Mark";
		String poruka = "This is cool but im late";
		t.unesi(korisnik, poruka);
		LinkedList<TwitterPoruka> lista = t.vratiSvePoruke();
		assertEquals(poruka,lista.getLast().getPoruka());
	}

	@Test
	public void testVratiSvePoruke() {
		String a = "MK";
		String b = "mk";
		for (int i = 0; i < 20; i++) {
			a+="m";
			b+="k";
			t.unesi(a, b);			
		}
		assertEquals(20, t.vratiSvePoruke().size());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(10, null);		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmptyTag() {
		t.vratiPoruke(10, "");		
	}
	
	@Test 
	public void testVratiPorukeMaxBroj() {
		String a = "MK";
		String b = "mk";
		for (int i = 0; i < 35; i++) {
			a+="m";
			b+="k";
			t.unesi(a, b);			
		}
		assertEquals(30, t.vratiPoruke(30, "abc").length);
	}
	
	public void testVratiPorukeMaxBrojV2() {
		String a = "MK";
		String b = "mk";
		for (int i = 0; i < 135; i++) {
			a+="m";
			b+="k";
			t.unesi(a, b);			
		}
		TwitterPoruka[] test = t.vratiPoruke(-5, "abc");
		assertEquals(100, test.length);
	}

}
