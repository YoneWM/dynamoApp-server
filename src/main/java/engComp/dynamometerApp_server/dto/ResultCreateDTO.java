package engComp.dynamometerApp_server.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

//Representa os dados recebidos do frontend

public class ResultCreateDTO {

    @NotBlank(message = "email obrigatório")
    @Email(message = "Email inválido")
    private String email;

    private Double pinchMax;

    private Double palmMax;

    @NotNull(message = "examDate obrigatória")
    private LocalDateTime examDate;

    @AssertTrue(message = "pinchMax e palmMax não podem ser nulos ao mesmo tempo")
    public boolean isPinchOrPalmValid() {
        return pinchMax != null || palmMax != null;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Double getPinchMax() { return pinchMax; }
    public void setPinchMax(Double pinchMax) { this.pinchMax = pinchMax; }

    public Double getPalmMax() { return palmMax; }
    public void setPalmMax(Double palmMax) { this.palmMax = palmMax; }

    public LocalDateTime getExamDate() { return examDate; }
    public void setExamDate(LocalDateTime examDate) { this.examDate = examDate; }

}
