package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by am on 10/15/2025
 */

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>{
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()) {
            throw new RuntimeException("No Unit of Measure found");
        }

        Optional<UnitOfMeasure> teaSpoonOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaSpoonOptional.isPresent()) {
            throw new RuntimeException("No Unit of Measure found");
        }

        Optional<UnitOfMeasure> tableSpoonOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonOptional.isPresent()) {
            throw new RuntimeException("No Unit of Measure found");
        }

        Optional<UnitOfMeasure> pinchOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if(!pinchOptional.isPresent()) {
            throw new RuntimeException("No Unit of Measure found");
        }

        Optional<UnitOfMeasure> cupOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupOptional.isPresent()) {
            throw new RuntimeException("No Unit of Measure found");
        }

        Optional<UnitOfMeasure> ounceOptional = unitOfMeasureRepository.findByDescription("Ounce");

        if(!ounceOptional.isPresent()) {
            throw new RuntimeException("No Unit of Measure found");
        }

        Optional<UnitOfMeasure> dashOptional = unitOfMeasureRepository.findByDescription("Dash");

        if(!dashOptional.isPresent()) {
            throw new RuntimeException("No Unit of Measure found");
        }

        Optional<UnitOfMeasure> pintOptional = unitOfMeasureRepository.findByDescription("Pint");

        if(!pintOptional.isPresent()) {
            throw new RuntimeException("No Unit of Measure found");
        }

        UnitOfMeasure each = eachUomOptional.get();
        UnitOfMeasure teaSpoon = teaSpoonOptional.get();
        UnitOfMeasure tableSpoon = tableSpoonOptional.get();
        UnitOfMeasure pinch = pinchOptional.get();
        UnitOfMeasure ounce = ounceOptional.get();
        UnitOfMeasure dash = dashOptional.get();
        UnitOfMeasure cup = cupOptional.get();
        UnitOfMeasure pint = pintOptional.get();

        Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanOptional.isPresent()) {
            throw new RuntimeException("No Category found");
        }

        Optional<Category> americanOptional = categoryRepository.findByDescription("American");

        if(!americanOptional.isPresent()) {
            throw new RuntimeException("No Category found");
        }

        Optional<Category> fastFoodOptional = categoryRepository.findByDescription("Fast Food");

        if(!fastFoodOptional.isPresent()) {
            throw new RuntimeException("No Category found");
        }

        Optional<Category> italianOptional = categoryRepository.findByDescription("Italian");

        if(!italianOptional.isPresent()) {
            throw new RuntimeException("No Category found");
        }

        Optional<Category> thaiOptional = categoryRepository.findByDescription("Thai");

        if(!thaiOptional.isPresent()) {
            throw new RuntimeException("No Category found");
        }

        Category mexican = mexicanOptional.get();
        Category fastFood = fastFoodOptional.get();
        Category italian = italianOptional.get();
        Category american = americanOptional.get();
        Category thai = thaiOptional.get();

        //finally I can actually get started
        Recipe kaiJeow = new Recipe();
        kaiJeow.setDescription("Kai Jeow");
        kaiJeow.setPrepTime(5);
        kaiJeow.setCookTime(5);
        kaiJeow.setDifficulty(Difficulty.EASY);
        kaiJeow.setDirection(" In a medium bowl, combine the eggs, fish sauce, brown sugar, scallion, Thai chili (if using) and black pepper in a medium bowl. Whisk vigorously until well combined and no egg whites are visible.\n" +
                " Heat vegetable oil in a small (about 8-inch diameter) nonstick skillet over medium-high heat until the oil is hot. You will know when the oil is ready when it smokes lightly.\n" +
                " Hold the bowl of egg mixture 12 inches above the skillet and pour it into the skillet. \n" +
                " The egg will immediately start to fry and become puffy. Cook until lightly browned on the bottom. While you wait, use a small spatula or chopsticks to push the edges of the omelet inward and tilt the pan to encourage the raw eggs in the center to come in contact with the pan. Cook the first side for approximately 3 minutes. \n" +
                " Once the omelet is firm, flip the omelet by either flicking your wrist to flip the omelet like a pancake or use a large spatula. Allow it to cook until the other side is browned, approximately 15 seconds.\n" +
                " Don’t worry if the omelet does not flip perfectly. It’ll still taste just as good.\n" +
                " Serve immediately with cooked rice, cucumber slices, romaine lettuce, and sriracha (if using). You can create a lettuce wrap with the romaine lettuce if you’d like. In the wrap, you can add cucumber, omelet, and rice. \n");
        Notes thaiNotes = new Notes();
        thaiNotes.setRecipeNotes("If you are having the kai jeow with steamed rice" +
                " and raw vegetables, use the full 2 teaspoons of fish sauce," +
                " as the salty omelet will “season” what’s served with it." +
                " If you are having the omelet on its own," +
                " you may want to reduce the fish sauce to 1 teaspoon.");
        thaiNotes.setRecipe(kaiJeow);
        kaiJeow.setNotes(thaiNotes);

        kaiJeow.getIngredients().add(new Ingredient("large eggs", new BigDecimal(3), each, kaiJeow));
        kaiJeow.getIngredients().add(new Ingredient("fish sauce", new BigDecimal(2), teaSpoon, kaiJeow));
        kaiJeow.getIngredients().add(new Ingredient("brown sugar", new BigDecimal("0.25"), teaSpoon, kaiJeow));
        kaiJeow.getIngredients().add(new Ingredient("scallion, minced", new BigDecimal(1), each, kaiJeow));
        kaiJeow.getIngredients().add(new Ingredient("Thai chili to start, minced (optional, can add more if desired)", new BigDecimal(0.5), each, kaiJeow));
        kaiJeow.getIngredients().add(new Ingredient("black pepper", new BigDecimal("0.25"), teaSpoon, kaiJeow));
        kaiJeow.getIngredients().add(new Ingredient("vegetable oil", new BigDecimal(3), tableSpoon, kaiJeow));
        kaiJeow.getIngredients().add(new Ingredient("cooked jasmine rice", new BigDecimal(1), cup, kaiJeow));
        kaiJeow.getIngredients().add(new Ingredient("cucumber slices", new BigDecimal(4), each, kaiJeow));

        kaiJeow.getCategories().add(thai);

        recipes.add(kaiJeow);

        return recipes;
    }
}
