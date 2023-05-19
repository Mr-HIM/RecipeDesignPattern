package edu.estu.common;

import edu.estu.entities.Category;
import edu.estu.entities.Tag;
import edu.estu.entities.Unit;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;

@UtilityClass
public class DataSeeder {

    public void seed() {
        DataSource.addToDataSet(Category.class, categories());
        DataSource.addToDataSet(Tag.class, tags());
        DataSource.addToDataSet(Unit.class, units());
    }

    private Collection<DataSource.Entity> categories() {
        Collection<DataSource.Entity> entities = new ArrayList<>();
        entities.add(new Category("Meat"));
        entities.add(new Category("Dessert"));
        entities.add(new Category("Snack"));
        entities.add(new Category("Drink"));
        entities.add(new Category("Salad"));
        entities.add(new Category("Soup"));
        entities.add(new Category("Sauce"));
        entities.add(new Category("Side dish"));
        entities.add(new Category("Bread"));
        entities.add(new Category("Pasta"));
        entities.add(new Category("Appetizer"));
        entities.add(new Category("Poultry"));
        entities.add(new Category("Seafood"));
        entities.add(new Category("Vegetable"));
        entities.add(new Category("Fruit"));
        entities.add(new Category("Nut"));
        entities.add(new Category("Herb"));
        entities.add(new Category("Spice"));
        entities.add(new Category("Condiments"));
        entities.add(new Category("Beverage"));
        entities.add(new Category("Lunch"));
        entities.add(new Category("Breakfast"));
        entities.add(new Category("Dinner"));
        return entities;
    }

    private Collection<DataSource.Entity> tags() {
        Collection<DataSource.Entity> entities = new ArrayList<>();
        entities.add(new Tag("Celery free"));
        entities.add(new Tag("Mustard free"));
        entities.add(new Tag("Nut free"));
        entities.add(new Tag("Egg free"));
        entities.add(new Tag("Fish free"));
        entities.add(new Tag("Sesame free"));
        entities.add(new Tag("Lupin free"));
        entities.add(new Tag("Mollusc free"));
        entities.add(new Tag("Hot"));
        entities.add(new Tag("Quick"));
        entities.add(new Tag("Easy"));
        entities.add(new Tag("Hard"));
        entities.add(new Tag("Healthy"));
        entities.add(new Tag("Unhealthy"));
        entities.add(new Tag("Spicy"));
        entities.add(new Tag("Sweet"));
        entities.add(new Tag("Sour"));
        entities.add(new Tag("Salty"));
        entities.add(new Tag("Bitter"));
        entities.add(new Tag("Fresh"));
        entities.add(new Tag("Cold"));
        entities.add(new Tag("Vegetarian"));
        entities.add(new Tag("Vegan"));
        entities.add(new Tag("Gluten free"));
        entities.add(new Tag("Dairy free"));
        entities.add(new Tag("Shellfish free"));
        entities.add(new Tag("Peanut free"));
        entities.add(new Tag("Soy free"));
        entities.add(new Tag("Wheat free"));
        entities.add(new Tag("Crustacean free"));
        entities.add(new Tag("Alcohol free"));
        entities.add(new Tag("Kosher"));
        entities.add(new Tag("Halal"));
        return entities;
    }

    private Collection<DataSource.Entity> units() {
        Collection<DataSource.Entity> entities = new ArrayList<>();
        entities.add(new Unit("Bottle"));
        entities.add(new Unit("Can"));
        entities.add(new Unit("Cup"));
        entities.add(new Unit("Tablespoon"));
        entities.add(new Unit("Teaspoon"));
        entities.add(new Unit("Kilogram"));
        entities.add(new Unit("Liter"));
        entities.add(new Unit("Piece"));
        return entities;
    }

}
