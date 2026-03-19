package dk.zealand.arcadearchive.infrastructure;

import dk.zealand.arcadearchive.domain.ArcadeGame;
import dk.zealand.arcadearchive.domain.ArcadeGameRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcArcadeGameRepository implements ArcadeGameRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcArcadeGameRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ArcadeGame> findAll() {
        String sql = """
                SELECT id, title, release_year, genre, manufacturer, players, active
                FROM arcade_games
                ORDER BY title
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new ArcadeGame(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("release_year"),
                        rs.getString("genre"),
                        rs.getString("manufacturer"),
                        rs.getInt("players"),
                        rs.getBoolean("active")
                )
        );
    }

    @Override
    public Optional<ArcadeGame> findById(int id) {
        String sql = """
                SELECT id, title, release_year, genre, manufacturer, players, active
                FROM arcade_games
                WHERE id = ?
                """;

        List<ArcadeGame> games = jdbcTemplate.query(sql, (rs, rowNum) ->
                new ArcadeGame(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("release_year"),
                        rs.getString("genre"),
                        rs.getString("manufacturer"),
                        rs.getInt("players"),
                        rs.getBoolean("active")
                ), id
        );

        if (games.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(games.get(0));
    }

    @Override
    public void save(ArcadeGame arcadeGame) {
        // TODO:
        // Lav SQL til INSERT
        // Brug jdbcTemplate.update(...)
        throw new UnsupportedOperationException("save() er ikke implementeret endnu");
    }

    @Override
    public void update(ArcadeGame arcadeGame) {
        // TODO:
        // Lav SQL til UPDATE
        // Husk WHERE id = ?
        throw new UnsupportedOperationException("update() er ikke implementeret endnu");
    }

    @Override
    public void deleteById(int id) {
        // TODO:
        // Lav SQL til DELETE
        throw new UnsupportedOperationException("deleteById() er ikke implementeret endnu");
    }
}