/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jhon pinedo
 */
public class DensidadPoblacional extends ObjetoGeografico {

    private int habitantes;

    public DensidadPoblacional(int habitantes, String nombre, int id, String municipio) {
        super(nombre, id, municipio);
        this.habitantes = habitantes;
    }

    public DensidadPoblacional() {
        super(0);
    }
    
    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }


    
     public int afección (){
        if(habitantes>=50000){
        return 2;
        }else if(habitantes< 50000 && habitantes>= 10000 ){
        return 1;
        }else{
        return 0;
     }
}
}
