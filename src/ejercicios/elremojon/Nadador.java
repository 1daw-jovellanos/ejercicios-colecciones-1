package ejercicios.elremojon;

import java.time.LocalDate;


public class Nadador implements Comparable<Nadador> {

    private String nombre;
    private LocalDate fechaNacimiento;
    private String nacionalidad;

    public Nadador(String nombre, LocalDate fechaNacimiento, String nacionalidad) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
    }
    
    @Override
    public int compareTo(Nadador arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
}
