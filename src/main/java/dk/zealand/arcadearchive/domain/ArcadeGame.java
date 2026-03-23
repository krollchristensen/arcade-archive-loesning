package dk.zealand.arcadearchive.domain;

public class ArcadeGame {

    private int id;
    private String title;
    private int releaseYear;
    private String genre;
    private String manufacturer;
    private int players;
    private boolean active;
    private String imageName;

    public ArcadeGame() {
    }

    public ArcadeGame(int id, String title, int releaseYear, String genre, String manufacturer, int players, boolean active, String imageName) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.manufacturer = manufacturer;
        this.players = players;
        this.active = active;
        this.imageName = imageName;
    }

    public ArcadeGame(String title, int releaseYear, String genre, String manufacturer, int players, boolean active, String imageName) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.manufacturer = manufacturer;
        this.players = players;
        this.active = active;
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}