package br.com.zup.edu.nutricionistas.controller;

import br.com.zup.edu.nutricionistas.model.Nutricionista;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class NutricionistaRequest {
    @NotBlank(message = "Este campo é obrigatório")
    private String nome;

    @NotBlank(message = "Este campo é obrigatório")
    @Email(message = "Formado de e-mail inválido")
    private String email;

    @NotBlank(message = "Este campo é obrigatório")
    private String crn;

    @NotBlank(message = "Este campo é obrigatório")
    @CPF(message = "Formato de CPF inválido")
    private String cpf;

    @NotNull(message = "A data de nascimento é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "A data de nascimneto tem que estar no passado")
    private LocalDate dataNascimento;

    public NutricionistaRequest(String nome, String email, String crn, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.crn = crn;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public NutricionistaRequest() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCRN() {
        return crn;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Nutricionista toModel() {
        return new Nutricionista(nome, email, crn, cpf, dataNascimento);
    }
}
