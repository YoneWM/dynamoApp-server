package engComp.dynamometerApp_server.dto;

import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserUpdateDTO {
    private String name;
    private String username;
    private LocalDate dataNascimento;

    @Email(message = "Email inválido")
    private String email;

    @Size(max = 12, message = "Senha deve ter no máximo 12 caracteres")
    private String password;

    private Double peso;
    private String genero;
    private Integer altura;

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Integer getAltura() { return altura; }
    public void setAltura(Integer altura) { this.altura = altura; }
}
