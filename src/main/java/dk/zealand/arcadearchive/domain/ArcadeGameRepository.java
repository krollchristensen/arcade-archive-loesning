package dk.zealand.arcadearchive.domain;

import java.util.List;
import java.util.Optional;

public interface ArcadeGameRepository {

    List<ArcadeGame> findAll();

    Optional<ArcadeGame> findById(int id);

    void save(ArcadeGame arcadeGame);

    void update(ArcadeGame arcadeGame);

    void deleteById(int id);
}