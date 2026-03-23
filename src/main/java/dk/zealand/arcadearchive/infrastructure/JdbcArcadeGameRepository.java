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
                SELECT id, title, release_year, genre, manufacturer, players, active, image_name
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
                        rs.getBoolean("active"),
                        rs.getString("image_name")
                )
        );
    }

    @Override
    public Optional<ArcadeGame> findById(int id) {
        String sql = """
                SELECT id, title, release_year, genre, manufacturer, players, active, image_name
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
                        rs.getBoolean("active"),
                        rs.getString("image_name")
                ), id
        );

        if (games.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(games.get(0));
    }

    @Override
    public void save(ArcadeGame arcadeGame) {
        String sql = """
                INSERT INTO arcade_games (title, release_year, genre, manufacturer, players, active, image_name)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(sql,
                arcadeGame.getTitle(),
                arcadeGame.getReleaseYear(),
                arcadeGame.getGenre(),
                arcadeGame.getManufacturer(),
                arcadeGame.getPlayers(),
                arcadeGame.isActive(),
                arcadeGame.getImageName()
        );
    }

    @Override
    public void update(ArcadeGame arcadeGame) {
        String sql = """
                UPDATE arcade_games
                SET title = ?, release_year = ?, genre = ?, manufacturer = ?, players = ?, active = ?, image_name = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(sql,
                arcadeGame.getTitle(),
                arcadeGame.getReleaseYear(),
                arcadeGame.getGenre(),
                arcadeGame.getManufacturer(),
                arcadeGame.getPlayers(),
                arcadeGame.isActive(),
                arcadeGame.getImageName(),
                arcadeGame.getId()
        );
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM arcade_games WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }
}