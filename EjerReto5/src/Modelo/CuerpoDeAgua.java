package Modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author jhon pinedo
 */
public class CuerpoDeAgua extends ObjetoGeografico {

    private String tipocuerpo;
    private String tipoagua;
    private Double irca;

    public CuerpoDeAgua(String tipocuerpo, String tipoagua, Double irca, String nombre, int id, String municipio) {
        super(nombre, id, municipio);
        this.tipocuerpo = tipocuerpo;
        this.tipoagua = tipoagua;
        this.irca = irca;
    }

    public CuerpoDeAgua(int id) {
        super(id);
    }
    
    public CuerpoDeAgua() {
        super(null, 0, null);
    }

    
        public String nivel(){
         String nivel = "";
        if(getIrca()>=0 && getIrca() <=5){
          nivel = "SIN RIESGO";
        }else if(getIrca()>5 && getIrca() <=14){
        nivel= "BAJO";
        }else if(getIrca()>14 && getIrca() <=35){
        nivel = "MEDIO";
        }else if(getIrca()>35 && getIrca() <=80){
        nivel="ALTO";
        }else if(getIrca()>80 && getIrca() <=100){
        nivel="INVIABLE SANITARIAMENTE";
        }
        return nivel;
        }

    public String getTipocuerpo() {
        return tipocuerpo;
    }

    public void setTipocuerpo(String tipocuerpo) {
        this.tipocuerpo = tipocuerpo;
    }

    public String getTipoagua() {
        return tipoagua;
    }

    public void setTipoagua(String tipoagua) {
        this.tipoagua = tipoagua;
    }

    public Double getIrca() {
        return irca;
    }

    public void setIrca(Double irca) {
        this.irca = irca;
    }

    
   
}