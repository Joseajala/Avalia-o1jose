package controlePiloto.Impl;

import controlePiloto.Pessoa;

public class Piloto extends Pessoa {
    private int _matricula;


    public Piloto(String nome, int matricula, String cpf) {
        super(nome, cpf);
        _matricula = matricula;
       
    }

    public int getMatricula() {
        return _matricula;
    }



    @Override
    public String toString() {
        return super.toString() + ":[matricula=" + _matricula +   "]";
    }

    @Override
    public String getTipo() {
        return "Piloto";
    }

 
        
                





}
