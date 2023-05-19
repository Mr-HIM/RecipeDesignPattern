package edu.estu.helper;

import edu.estu.common.ConsoleUtils;
import edu.estu.common.DataSource;
import edu.estu.entities.Tag;

import java.util.HashSet;
import java.util.List;

public class TagHelper {

    static HashSet<Tag> createTagList() {
        System.out.println();
        HashSet<Tag> selected = new HashSet<>(3);
        List<String> options = DataSource.getDataSet(Tag.class).stream().map(entity -> ((Tag) entity).name()).toList();
        ConsoleUtils.printOptions(options, "Tags (up to 3)");
        while (selected.size() < 3) {
            int choice = ConsoleUtils.readInt("Enter your choice: ", 0, options.size());
            if (choice == 0) break;
            selected.add(new Tag(options.get(choice - 1)));
        }
        return selected;
    }

    public static Tag selectTag() {
        List<String> options = DataSource.getDataSet(Tag.class).stream().map(entity -> ((Tag) entity).name()).toList();
        ConsoleUtils.printOptions(options, "Tags (up to 3)");
        int choice = ConsoleUtils.readInt("Enter your choice: ", 1, options.size());
        return new Tag(options.get(choice - 1));
    }
}
