package com.AppRH.AppRH.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.context.annotation.Configuration;

@Entity
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String rg;

    @NotEmpty
    @Column(name = "nome_candidato")
    private String nomeCandidato;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Por favor, insira um email válido (exemplo: nome@dominio.com)")
    @NotEmpty(message = "O email é obrigatorio")
    private String email;

    @ManyToOne
    private Vaga vaga;



    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public  String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(@NotEmpty String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty String email) {
        this.email = email;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
}
