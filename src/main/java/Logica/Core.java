/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Utilitarios.Persona;
import Utilitarios.Reporte;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Darkgrey93
 */
public class Core implements Serializable{
    
    Map<Integer,Persona> personas=new HashMap<Integer,Persona>();
    public static BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
    public void agregarPersona (Persona persona){
        if (!personas.containsKey(persona.getCedula())) {
            personas.put(persona.getCedula(),persona);
        }
    }
    
    public void agregarReporte(Integer identificacion,Reporte reporte){
        try{
            if(personas.containsKey(identificacion)){
                Persona persona=personas.get(identificacion);
                if(!persona.getReportes().containsKey(reporte.getCodigo())){
                    persona.getReportes().put(reporte.getCodigo(),reporte);
                }
                else{
                    System.out.println("ese codigo de reporte ya existe");
                }
                personas.remove(identificacion);
                personas.put(persona.getCedula(),persona);
            }
            else{
                System.out.println("Esa identificacion no existe vuelva a escribir");
            }
        }catch(Exception  e){
            System.out.println("no se pudo agregar Reporte");
        }
    }
    
    public void eliminarReporte(Integer identificacion,Integer codigo){
        try{
            if(personas.containsKey(identificacion)){
                Persona persona=personas.get(identificacion);
                if(persona.getReportes().containsKey(codigo)){
                    persona.getReportes().remove(codigo);
                }
                else{
                    System.out.println("ese codigo de reporte no existe");
                }
                personas.put(persona.getCedula(),persona);
            }
            else{
                System.out.println("Esa identificacion no existe vuelva a escribir");
            }
        }catch(Exception  e){
            System.out.println("no se pudo agregar Reporte");
        }
    }
    public void imprimirReportes(Integer identificacion){
        if(personas.containsKey(identificacion)){
            for (Map.Entry<Integer, Reporte> entry : personas.get(identificacion).getReportes().entrySet()) {
                Integer key = entry.getKey();
                Reporte value = entry.getValue();
                value.mostrardatos();
                
            }
        }
    }
    public void iniciar(){
        try{
            leerArchivo();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void menu() {
        try{
            
        System.out.println("Que desea hacer:\n"+
                           "1.Agregar Personas\n"+
                           "2.agregar Reportes a personas\n"+
                           "3.Ver Reportes por cedula\n"+
                           "4.Guardar y salir");
        int opcion=0;
        try {
           opcion=Integer.parseInt((entrada.readLine()));; 
        } catch (Exception ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch(opcion){
            case 1:
                Integer cedula=0;
                String nombre="";
                String fecha="";
                String correo="";
                System.out.println("digite cedula");
                try {
                    cedula = Integer.parseInt((entrada.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("digite nombre");
                try {
                    nombre = ((entrada.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("digite fecha de nacimiento");
                try {
                    fecha = ((entrada.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("digite correo");
                try {
                    correo = ((entrada.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }
                Persona nueva=new Persona(cedula,nombre,fecha,correo);
                agregarPersona(nueva);
                menu();
               break;
            case 2:
                Integer id=0;
                Integer codigo=0;  
                String descripcion=""; 
                String estado="";
                Integer valor=0;
                System.out.println("Digite la cedula a quien se le hara el reporte");
                try {
                    id = Integer.parseInt((entrada.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("digite el codigo del reporte");
                try {
                    codigo = Integer.parseInt((entrada.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Digite descripcion del reporte");
                try {
                    descripcion = ((entrada.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Digite el estado del reporte");
                try {
                    estado = ((entrada.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Digite el valor del reporte");
                try {
                    valor = Integer.parseInt((entrada.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }
                Reporte nuevo=new Reporte(codigo,descripcion,estado,valor);
                agregarReporte(id, nuevo);
                menu();
                break;
            case 3:
                Integer id2= 0;
                 System.out.println("Digite la identificacion de la persona para ver sus reportes\n");
                try {
                    id2 = Integer.parseInt((entrada.readLine()));
                } catch (IOException ex) {
                    Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
                }
                imprimirReportes(id2);
                menu();
                break;
            case 4:
                
                guardarArchivo();
                break;
            
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
     public void leerArchivo() throws FileNotFoundException, IOException{
        File f;
        f=new File("src/prueba.txt");
        ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(f));
        try{
            personas=(HashMap)entrada.readObject();
        }catch(Exception ex){
            System.out.println("Error al leer el archivo");
            System.err.println(ex.getMessage());
        }finally{
            entrada.close();
        }
        
    }
    public void guardarArchivo() throws FileNotFoundException, IOException{
        File f;
        f=new File("src/prueba.txt");
        ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(f));
        try{
            salida.writeObject(personas);
        }catch(Exception ex){
            System.out.println("Error al Guardar el archivo");
            ex.getMessage();
        }finally{
            salida.close();
        }
    }
        
 }

