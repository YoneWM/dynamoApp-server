package engComp.dynamometerApp_server.controllers;

import engComp.dynamometerApp_server.dto.ResultCreateDTO;
import engComp.dynamometerApp_server.dto.ResultResponseDTO;
import engComp.dynamometerApp_server.services.ResultService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;
/*
*Funcionalidades:
* - Retornar os X últimos resultados (palMax,pinchMax,examDate) de um usuário Y
* - Retornar os resultados (palMax,pinchMax,examDate) de um usuário Y de uma data d1 até d2
* - Retornar todos os resultados (palMax,pinchMax,examDate)
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

    @PostMapping("/create")
    public ResponseEntity<ResultResponseDTO> createResult(@RequestBody @Valid ResultCreateDTO dto) {
        logger.info("Creating new result for user: " + dto.getEmail());
        ResultResponseDTO newResult = resultService.createResult(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newResult);
    }
}
