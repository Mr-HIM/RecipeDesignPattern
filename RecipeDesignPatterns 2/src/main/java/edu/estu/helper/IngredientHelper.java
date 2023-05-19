package edu.estu.helper;

import edu.estu.common.ConsoleUtils;
import edu.estu.common.DataSource;
import edu.estu.entities.Ingredient;
import edu.estu.entities.Unit;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class IngredientHelper {

    public List<Ingredient> createIngredientList() {
        System.out.println();
        List<Ingredient> ingredients = new ArrayList<>();
        System.out.println("<<<<Create Ingredients>>>>");

        while (true) {
            String name = ConsoleUtils.readLine("Please input the name of the ingredient('E' to Exit): ");
            if (name.equals("E")) break;
            ingredients.add(createIngredient(name));
        }
        return ingredients;
    }

    public Ingredient createIngredient(String name) {
        double amount = ConsoleUtils.readDouble("Please input the amount of the ingredient: ", 0, 10000);

        System.out.println();
        List<String> options = DataSource.getDataSet(Unit.class).stream().map(entity -> ((Unit) entity).name()).toList();
        ConsoleUtils.printOptions(options, "Units");
        int choice = ConsoleUtils.readInt("Enter your choice: ", 1, options.size());
        return new Ingredient(name, amount, new Unit(options.get(choice - 1)));
    }
}
