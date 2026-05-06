package engComp.dynamometerApp_server.controllers;

import engComp.dynamometerApp_server.dto.ResultCreateDTO;
import engComp.dynamometerApp_server.dto.ResultResponseDTO;
import engComp.dynamometerApp_server.services.ResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;
/*
*Funcionalidades:
* - Retornar os X últimos resultados (palMax,pinchMax,examDate) de um usuário Y (FEITO -> TESTAR)
* - Retornar os resultados (palMax,pinchMax,examDate) de um usuário Y de uma data d1 até d2 (FEITO -> TESTAR)
* - Retornar todos os resultados (palMax,pinchMax,examDate) (FEITO -> TESTAR)
* - Retornar Count, Média, Máx de exames realizados na semana, para ambos pinchMax e palmMax
* - Retornar Média por semana de ambos resultados
* */

@RestController
@RequestMapping("/api/result")
public class ResultController {
    private static final Logger logger = Logger.getLogger(ResultController.class.getName());

    @Autowired
    private ResultService resultService;

    //métodos GET
    @GetMapping("/all")
    public ResponseEntity<List<ResultResponseDTO>> getAllResults(@RequestParam String email) {
        logger.info("Getting all results for user: " + email);

        List<ResultResponseDTO> results = resultService.getAllResults(email);

        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @GetMapping("/getLastX")
    public ResponseEntity<List<ResultResponseDTO>> getLastResults(@RequestParam String email, @RequestParam int quantidade) {
        logger.info("Getting last " + quantidade + " results for user: " + email);

        List<ResultResponseDTO> results = resultService.getLastResults(email, quantidade);

        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @GetMapping("/getDateRange")
    public ResponseEntity<List<ResultResponseDTO>> getResultsByDateRange(
            @RequestParam String email,
            @RequestParam LocalDateTime d1,
            @RequestParam LocalDateTime d2) {
        logger.info("Getting results for user: " + email + " between " + d1 + " and " + d2);

        List<ResultResponseDTO> results = resultService.getResultsByDateRange(email, d1, d2);

        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    @PostMapping("/create")
    public ResponseEntity<ResultResponseDTO> createResult(@RequestBody @Valid ResultCreateDTO dto) {
        logger.info("Creating new result for user: " + dto.getEmail());

        ResultResponseDTO newResult = resultService.createResult(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newResult);
    }
}
