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
public class Reporte implements Serializable {
    private Integer codigo;
    private String descripcion;
    private String estado;
    private Integer valor;
    
    
    public Reporte(Integer codigo, String descripcion, String estado, Integer valor){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.valor = valor;
        
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    
    
    public void mostrardatos(){
        System.out.println(descripcion+estado);
    }
    
    
}
