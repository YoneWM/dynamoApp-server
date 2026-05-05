package engComp.dynamometerApp_server.dto;

import java.time.LocalDateTime;

//o que é devolvido como resposta ao request do front

public class ResultResponseDTO {
    private Double pinchMax;
    private Double palmMax;
    private LocalDateTime examDate;

    public ResultResponseDTO(engComp.dynamometerApp_server.entities.Result result) {
        this.pinchMax = result.getPinchMax();
        this.palmMax = result.getPalmMax();
        this.examDate = result.getExamDate();
    }

    // Getters
    public Double getPinchMax() { return pinchMax; }
    public Double getPalmMax() { return palmMax; }
    public LocalDateTime getExamDate() { return examDate; }
}
