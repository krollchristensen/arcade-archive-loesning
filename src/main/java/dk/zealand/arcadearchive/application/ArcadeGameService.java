package dk.zealand.arcadearchive.application;

import dk.zealand.arcadearchive.domain.ArcadeGame;
import dk.zealand.arcadearchive.domain.ArcadeGameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArcadeGameService {

    private final ArcadeGameRepository arcadeGameRepository;

    public ArcadeGameService(ArcadeGameRepository arcadeGameRepository) {
        this.arcadeGameRepository = arcadeGameRepository;
    }

    public List<ArcadeGame> getAllGames() {
        return arcadeGameRepository.findAll();
    }

    public Optional<ArcadeGame> getGameById(int id) {
        return arcadeGameRepository.findById(id);
    }

    public void createGame(ArcadeGame arcadeGame) {
        arcadeGameRepository.save(arcadeGame);
    }

    public void updateGame(ArcadeGame arcadeGame) {
        arcadeGameRepository.update(arcadeGame);
    }

    public void deleteGame(int id) {
        arcadeGameRepository.deleteById(id);
    }
}