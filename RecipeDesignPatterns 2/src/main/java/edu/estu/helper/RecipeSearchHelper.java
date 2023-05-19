package edu.estu.helper;

import edu.estu.common.ConsoleUtils;
import edu.estu.entities.Category;
import edu.estu.entities.Tag;

import java.util.Arrays;
import java.util.List;

public class RecipeSearchHelper {
    private final RecipeSearch search = new RecipeSearch();

    public void handleSearchRecipe() {
        List<String> options = Arrays.asList("Title", "Category", "Ingredient", "Tag");
        ConsoleUtils.printOptions(options, "Search by");
        int choice = ConsoleUtils.readInt("Enter your choice: ", 1, options.size());

        switch (choice) {
            case 1 -> searchRecipeByName();
            case 2 -> searchRecipeByCategory();
            case 3 -> searchRecipeByIngredient();
            case 4 -> searchRecipeByTag();
        }
    }

    private void searchRecipeByTag() {
        System.out.println("<<<<Search By Tag>>>>");
        Tag tag = TagHelper.selectTag();
        search.searchRecipeByTag(tag);
        System.out.println("________________________________________");

    }

    private void searchRecipeByIngredient() {
        System.out.println("<<<<Search By Ingredient>>>>");
        String name = ConsoleUtils.readLine("Enter ingredient name: ");
        search.searchRecipeByIngredient(name);
        System.out.println("____________________________________");
    }

    private void searchRecipeByCategory() {
        System.out.println("<<<<Search By Category>>>>");
        Category category = CategoryHelper.selectCategory();

        search.searchRecipeByCategory(category);
        System.out.println("___________________________________");
    }

    public void searchRecipeByName() {
        System.out.println("<<<<Search By Name>>>>");
        String name = ConsoleUtils.readLine("Enter recipe name: ");
        search.searchRecipeByName(name);
        System.out.println("_________________________________________");

    }
}
