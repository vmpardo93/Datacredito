package Utilitarios;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joma Vega
 */
public class Persona implements Serializable{
    private Integer cedula;
    private String nombre;
    private String fecha_nacimiento;
    private String correo;
    private Map<Integer,Reporte> Reportes=new HashMap<Integer,Reporte>();
        
    
     public Persona(Integer cedula, String nombre, String fecha_nacimiento,String correo){
        this.cedula = cedula;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
     
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Map<Integer, Reporte> getReportes() {
        return Reportes;
    }

    public void setReportes(Map<Integer, Reporte> Reportes) {
        this.Reportes = Reportes;
    }

    
    
    public void mostrarDatos(){
    System.out.println(cedula+nombre);
    }
        
}
