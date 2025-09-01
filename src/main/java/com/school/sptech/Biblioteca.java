package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros = 0;
    private Boolean ativa = true;

    public  Biblioteca(String nome, Double multaDiaria){
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        qtdLivros = 0;
        ativa = true;
    }
    public void registrarLivro(Integer quantidade){

        if(quantidade != null && quantidade > 0){
            if(ativa == true){
                qtdLivros = qtdLivros + quantidade;
            }
        }

    }

    public Integer emprestar(Integer quantidade){
        if(ativa == true && quantidade != null && quantidade > 0 && qtdLivros >= quantidade){
                qtdLivros-=quantidade;
                return quantidade;
        }
        else{
            return null;
        }
    }

    public Integer devolver(Integer quantidade){
        if (ativa == true){
                if(quantidade != null && quantidade > 0){
                    qtdLivros+=quantidade;
                    return quantidade;
                }
                else {
                    return null;
                }
        }
        else{
            return null;
        }
    }

    public Integer desativar(){
        Integer antigaQtdLivros = qtdLivros;
        if(ativa == true){
            ativa = false;
            qtdLivros = 0;
        }
        else{
            return null;
        }
        return antigaQtdLivros;
    }

    public void transferir(Biblioteca destino, Integer quantidade){
        if(this.ativa == true && destino.ativa == true){
            if(quantidade > 0 && quantidade <= this.qtdLivros){
                destino.qtdLivros+=quantidade;
                this.qtdLivros-=quantidade;
                System.out.println("Livros transferidos com sucesso");
            }
        }
    }

    public Boolean reajustarMulta(Double percentual){
        if(percentual != null && percentual > 0){
            multaDiaria = multaDiaria * (1+percentual);
            return true;
        }
        return false;
    }
    public String getNome(){
        return nome;
    }
    public Double getMultaDiaria(){
        return multaDiaria;
    }
    public Integer getQtdLivros(){
        return qtdLivros;
    }
    public Boolean getAtiva(){
        return ativa;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

}

