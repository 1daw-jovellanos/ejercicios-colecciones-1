/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.elremojon;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victor
 */
public class NadadorTest {
    
    public NadadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
        @Test
    public void testComparableNadadores() {
        Nadador n1 = new Nadador("PEPE", LocalDate.of(2000, 1, 1), "español");
        Nadador n2 = new Nadador("luisa", LocalDate.of(2000, 1, 1), "español");
        Nadador n3 = new Nadador("luisa", LocalDate.of(2002, 1, 1), "español");
        Nadador n4 = new Nadador("luisa", LocalDate.of(1990, 1, 1), "español");
        assertEquals(true, n1.compareTo(n2) > 0);
        assertEquals(true, n1.compareTo(n3) > 0);
        assertEquals(true, n1.compareTo(n4) > 0);
        assertEquals(true, n2.compareTo(n3) < 0);
        assertEquals(true, n2.compareTo(n4) > 0);
        assertEquals(true, n3.compareTo(n4) > 0);
    }

}
