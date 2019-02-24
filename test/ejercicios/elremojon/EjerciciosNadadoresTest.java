/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.elremojon;

import java.time.LocalDate;
import java.util.*;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victor
 */
public class EjerciciosNadadoresTest {

    public EjerciciosNadadoresTest() {
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
    public void testEliminarLosNoAlevines() {
        List<Nadador> nadadores = new LinkedList<>();
        for (int j = 1; j <= 10; j++) {
            for (int i = 2001; i <= 2010; i++) {
                nadadores.add(new Nadador("", LocalDate.of(i, 6, 7), ""));
            }
        }
        EjerciciosNadadores.eliminarLosNoAlevines(nadadores);
        assertEquals(80, nadadores.size());
    }

    @Test
    public void testObtenerNacionalidades() {
        List<Nadador> todos = new ArrayList<>();
        todos.add(new Nadador("Fa", LocalDate.EPOCH, "española"));
        todos.add(new Nadador("Fe", LocalDate.EPOCH, "francesa"));
        todos.add(new Nadador("fi", LocalDate.EPOCH, "inglesa"));
        todos.add(new Nadador("Fo", LocalDate.EPOCH, "inglesa"));
        todos.add(new Nadador("Fu", LocalDate.EPOCH, "española"));
        todos.add(new Nadador("Fy", LocalDate.EPOCH, "inglesa"));
        Map<String, Integer> result = EjerciciosNadadores.obtenerNacionalidades(todos);
        assertEquals(3, result.size());
        assertEquals(2, result.get("española").intValue());
        assertEquals(1, result.get("francesa").intValue());
        assertEquals(3, result.get("inglesa").intValue());

    }

    @Test
    public void testHacemosRelevosVeteranos() {
        List<Nadador> apuntadosALosJuegos = new ArrayList<>();
        assertEquals(false, EjerciciosNadadores.hacemosRelevosVeteranos(apuntadosALosJuegos));
        for (int i = 0; i < 7; i++) {
            apuntadosALosJuegos.add(new Nadador("fa", LocalDate.of(1950, 1, 1), "xx"));
            apuntadosALosJuegos.add(new Nadador("fe", LocalDate.of(1990, 1, 1), "xx"));
            apuntadosALosJuegos.add(new Nadador("fi", LocalDate.of(2000, 1, 1), "xx"));
        }
        assertEquals(false, EjerciciosNadadores.hacemosRelevosVeteranos(apuntadosALosJuegos));
        apuntadosALosJuegos.add(new Nadador("fa", LocalDate.of(1950, 1, 1), "xx"));
        apuntadosALosJuegos.add(new Nadador("fe", LocalDate.of(1990, 1, 1), "xx"));
        apuntadosALosJuegos.add(new Nadador("fi", LocalDate.of(2000, 1, 1), "xx"));
        assertEquals(true, EjerciciosNadadores.hacemosRelevosVeteranos(apuntadosALosJuegos));

    }

    @Test
    public void testMezclarNombres() {
        System.out.println("mezclarNombres");
        List<String> lista1 = Arrays.asList("AGUST D.", "CNBLUE", "DEAN", "FAMOUD DEX", "G-DRAGON", "INFINITE");
        List<String> lista2 = Arrays.asList("BIGBANG", "EXO", "HEIZE", "JUNGKOOK", "KIM NAMJOON", "LAY");
        List<String> expResult = new LinkedList(lista1);
        expResult.addAll(lista2);
        Collections.sort(expResult); // Esto no lo debe hacer el método mezclarNombres.
        List<String> result = EjerciciosNadadores.mezclarNombres(lista1, lista2);
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
        assertEquals("No es el esperado.", true, iguales);
    }

    @Test
    public void testObtenerNadadoresPorNacionalidad() {
        List<Nadador> todos = new ArrayList<>();
        Nadador esp1 = new Nadador("esp1", LocalDate.EPOCH, "española");
        Nadador esp2 = new Nadador("esp2", LocalDate.EPOCH, "española");
        Nadador esp3 = new Nadador("esp3", LocalDate.EPOCH, "española");
        Nadador fra1 = new Nadador("fra1", LocalDate.EPOCH, "francesa");
        Nadador ing1 = new Nadador("ing1", LocalDate.EPOCH, "inglesa");
        Nadador ing2 = new Nadador("ing2", LocalDate.EPOCH, "inglesa");
        Collections.addAll(todos, esp1, fra1, ing1, esp2, ing2, esp3);
        Collection<String> nacionalidades = Arrays.asList("española", "inglesa", "italiana");
        Map<String, SortedSet<Nadador>> result = EjerciciosNadadores.obtenerNadadoresPorNacionalidad(todos, nacionalidades);
        assertEquals(3, result.size());
        assertEquals(3, result.get("española").size());
        assertEquals(true, result.get("española").contains(esp1));
        assertEquals(true, result.get("española").contains(esp2));
        assertEquals(true, result.get("española").contains(esp3));
        assertEquals(2, result.get("inglesa").size());
        assertEquals(true, result.get("inglesa").contains(ing1));
        assertEquals(true, result.get("inglesa").contains(ing2));
        assertEquals(0, result.get("italiana").size());
    }

}
