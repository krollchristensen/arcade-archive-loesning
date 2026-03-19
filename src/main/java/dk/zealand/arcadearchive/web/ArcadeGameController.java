package dk.zealand.arcadearchive.web;

import dk.zealand.arcadearchive.application.ArcadeGameService;
import dk.zealand.arcadearchive.domain.ArcadeGame;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class ArcadeGameController {

    private final ArcadeGameService arcadeGameService;

    public ArcadeGameController(ArcadeGameService arcadeGameService) {
        this.arcadeGameService = arcadeGameService;
    }

    @GetMapping
    public String showAllGames(Model model) {
        model.addAttribute("games", arcadeGameService.getAllGames());
        return "games/list";
    }

    @GetMapping("/{id}")
    public String showGameDetails(@PathVariable int id, Model model) {
        ArcadeGame arcadeGame = arcadeGameService.getGameById(id).orElse(null);

        if (arcadeGame == null) {
            return "redirect:/games";
        }

        model.addAttribute("game", arcadeGame);
        return "games/details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("game", new ArcadeGame());
        return "games/create";
    }

    @PostMapping("/create")
    public String createGame(@ModelAttribute ArcadeGame game) {
        arcadeGameService.createGame(game);
        return "redirect:/games";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        ArcadeGame arcadeGame = arcadeGameService.getGameById(id).orElse(null);

        if (arcadeGame == null) {
            return "redirect:/games";
        }

        model.addAttribute("game", arcadeGame);
        return "games/edit";
    }

    @PostMapping("/edit")
    public String updateGame(@ModelAttribute ArcadeGame game) {
        arcadeGameService.updateGame(game);
        return "redirect:/games";
    }

    @PostMapping("/delete/{id}")
    public String deleteGame(@PathVariable int id) {
        arcadeGameService.deleteGame(id);
        return "redirect:/games";
    }
}