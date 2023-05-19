package edu.estu.helper;

import edu.estu.common.ConsoleUtils;
import edu.estu.common.DataSource;
import edu.estu.entities.Category;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.List;

@UtilityClass
public class CategoryHelper {

    public HashSet<Category> createCategoryList() {
        System.out.println();
        HashSet<Category> selected = new HashSet<>(3);
        List<String> options = DataSource.getDataSet(Category.class).stream().map(entity -> ((Category) entity).name()).toList();
        ConsoleUtils.printOptions(options, "Categories (up to 3)");
        while (selected.size() < 3) {
            int choice = ConsoleUtils.readInt("Enter your choice: ", 0, options.size());
            if (choice == 0) break;
            selected.add(new Category(options.get(choice - 1)));
        }
        return selected;
    }

    public Category selectCategory() {
        List<String> options = DataSource.getDataSet(Category.class).stream().map(entity -> ((Category) entity).name()).toList();
        ConsoleUtils.printOptions(options, "Categories (up to 3)");
        int choice = ConsoleUtils.readInt("Enter your choice: ", 1, options.size());
        return new Category(options.get(choice - 1));
    }

}
