package guru.springframework.recipeapp.controllers;

import guru.springframework.recipeapp.model.Category;
import guru.springframework.recipeapp.model.UnitOfMeasure;
import guru.springframework.recipeapp.repositories.CategoryRepository;
import guru.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import guru.springframework.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}

