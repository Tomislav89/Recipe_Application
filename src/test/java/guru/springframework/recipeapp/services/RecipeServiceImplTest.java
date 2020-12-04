package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.model.Recipe;
import guru.springframework.recipeapp.repositories.RecipeRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeServiceimpl;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeServiceimpl = new RecipeServiceImpl(recipeRepository);

    }

    @Test
    void getRecipes() throws Exception {

        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        //kad u getRecipes metodi recipeRepository nadje sve recepte, on ce vratiti u  public Set<Recipe> getRecipes() recipesData (RecipeServiceImpl)
        when(recipeRepository.findAll()).thenReturn(recipesData);


        Set<Recipe> recipes = recipeServiceimpl.getRecipes();
        assertEquals(recipes.size(), 1);
    }
}