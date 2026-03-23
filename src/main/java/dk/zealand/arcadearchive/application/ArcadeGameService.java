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
        validateArcadeGame(arcadeGame);
        arcadeGameRepository.save(arcadeGame);
    }

    public void updateGame(ArcadeGame arcadeGame) {
        validateArcadeGame(arcadeGame);
        arcadeGameRepository.update(arcadeGame);
    }

    public void deleteGame(int id) {
        arcadeGameRepository.deleteById(id);
    }

    private void validateArcadeGame(ArcadeGame arcadeGame) {
        if (arcadeGame.getTitle() == null || arcadeGame.getTitle().isBlank()) {
            throw new IllegalArgumentException("Titel må ikke være tom");
        }

        if (arcadeGame.getGenre() == null || arcadeGame.getGenre().isBlank()) {
            throw new IllegalArgumentException("Genre må ikke være tom");
        }

        if (arcadeGame.getManufacturer() == null || arcadeGame.getManufacturer().isBlank()) {
            throw new IllegalArgumentException("Producent må ikke være tom");
        }

        if (arcadeGame.getReleaseYear() < 1970 || arcadeGame.getReleaseYear() > 2000) {
            throw new IllegalArgumentException("Udgivelsesår skal være mellem 1970 og 2000");
        }

        if (arcadeGame.getPlayers() < 1 || arcadeGame.getPlayers() > 2) {
            throw new IllegalArgumentException("Antal spillere skal være 1 eller 2");
        }

        if (arcadeGame.getImageName() == null || arcadeGame.getImageName().isBlank()) {
            throw new IllegalArgumentException("Billednavn må ikke være tomt");
        }
    }
}