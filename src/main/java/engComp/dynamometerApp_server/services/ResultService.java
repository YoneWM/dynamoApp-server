package engComp.dynamometerApp_server.services;

import engComp.dynamometerApp_server.dto.ResultCreateDTO;
import engComp.dynamometerApp_server.dto.ResultResponseDTO;
import engComp.dynamometerApp_server.entities.Result;
import engComp.dynamometerApp_server.entities.User;
import engComp.dynamometerApp_server.repositories.ResultRepository;
import engComp.dynamometerApp_server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ResultService {
    private static final Logger logger = Logger.getLogger(ResultService.class.getName());

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserRepository userRepository;

    //GET
    public List<ResultResponseDTO> getLastResults(String email, int quantidade) {
        if (userRepository.findByEmail(email).isEmpty()) {
            throw new RuntimeException("Usuário não encontrado com email: " + email);
        }

        return resultRepository.findLastResults(email, quantidade)
                .stream()
                .map(ResultResponseDTO::new)
                .toList();
    }

    public List<ResultResponseDTO> getResultsByDateRange(String email, LocalDateTime d1, LocalDateTime d2) {
        if (userRepository.findByEmail(email).isEmpty()) {
            throw new RuntimeException("Usuário não encontrado com email: " + email);
        }

        return resultRepository.findByEmailAndDateRange(email, d1, d2)
                .stream()
                .map(ResultResponseDTO::new)
                .toList();
    }

    public List<ResultResponseDTO> getAllResults(String email) {
        if (userRepository.findByEmail(email).isEmpty()) {
            throw new RuntimeException("Usuário não encontrado com email: " + email);
        }

        return resultRepository.findByUserEmailOrderByExamDateDesc(email)
                .stream()
                .map(ResultResponseDTO::new)
                .toList();
    }

    //POST
    public ResultResponseDTO createResult(ResultCreateDTO dto) {
        // busca o usuário pelo email
        Optional<User> userOptional = userRepository.findByEmail(dto.getEmail());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado com email: " + dto.getEmail());
        }

        Result result = new Result();
        result.setUser(userOptional.get());
        result.setPinchMax(dto.getPinchMax());
        result.setPalmMax(dto.getPalmMax());
        result.setExamDate(dto.getExamDate());

        return new ResultResponseDTO(resultRepository.save(result));
    }
}