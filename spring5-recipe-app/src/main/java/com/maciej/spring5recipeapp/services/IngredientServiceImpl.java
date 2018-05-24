package com.maciej.spring5recipeapp.services;

import com.maciej.spring5recipeapp.commands.IngredientCommand;
import com.maciej.spring5recipeapp.converters.IngredientToIngredientCommand;
import com.maciej.spring5recipeapp.domain.Recipe;
import com.maciej.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if (!recipeOptional.isPresent()) {
            // todo impl error handling
            log.error("recioe id not found:" + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream().filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredientToIngredientCommand::convert).findFirst();
        if (!ingredientCommandOptional.isPresent()) {
            // todo impl error handling

            log.error("Ingredient id not found: " + ingredientId);
        }
        return ingredientCommandOptional.get();
    }
}
