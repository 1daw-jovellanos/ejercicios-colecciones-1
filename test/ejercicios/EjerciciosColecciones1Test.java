package ejercicios;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class EjerciciosColecciones1Test {
    
    public EjerciciosColecciones1Test() {
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
    public void testListaFibonacciImpares() {
        int n = 150;
        List<Integer> expResult = Arrays.asList(1, 1, 3, 5, 13, 21, 55, 89);
        List<Integer> result = EjerciciosColecciones1.listaFibonacciImpares(n);
        
        assertEquals(expResult.size(), result.size());
        boolean iguales = true;
        int i = 0;
        while (i < expResult.size() && iguales) {
            if (!expResult.get(i).equals(result.get(i))) {
                iguales = false;
            } else {
                i++;
            }
        }
        assertEquals("no iguales", true, iguales);
    }

    @Test
    public void testObtenerIesQueNoSonDeFuenla() {
        Set<String> iesDeMadrid = new HashSet<>();
        Collections.addAll(iesDeMadrid, "Uno", "dos", "tres", "Kuatro", "CinKo", "SEIX");
        List<String> iesDeFuenla = new ArrayList<>();
        Collections.addAll(iesDeFuenla, "dos", "Kuatro", "CinKo");
        List<String> expResult = new ArrayList<>();
        Collections.addAll(expResult, "UNO", "TRES", "SEIX");
        List<String> result = EjerciciosColecciones1.obtenerIesQueNoSonDeFuenla(iesDeMadrid, iesDeFuenla);
        boolean iguales = true;
        int i = 0;
        while (i < expResult.size() && iguales) {
            if (!expResult.get(i).equals(result.get(i))) {
                iguales = false;
            } else {
                i++;
            }
        }
        assertEquals("No es el esperado.", true, iguales);
    }

    @Test
    public void testObtenerConsonantes() {
        String[] cadenas = {"Ir Y Quedarse", "y con quedar partirse", 
            "PARTIR SIN ALMA", "Y IR CON alma AJENA"};
        String expResult = "CJLMNPQRSTY";
        String result = EjerciciosColecciones1.obtenerConsonantes(cadenas);
        assertEquals(expResult, result);
    }
    
}
