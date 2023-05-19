package edu.estu.entities;

import edu.estu.common.DataSource;
import edu.estu.strategy.rating.abstracts.RatingStrategy;
import edu.estu.strategy.rating.concretes.AverageRatingStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Recipe implements DataSource.Entity {

    private String title;
    private String description;
    private int servingSize;
    private List<Ingredient> ingredients = new LinkedList<>();
    private Set<Category> categories = new HashSet<>(3);
    private Set<Tag> tags = new HashSet<>(3);
    private String instructions;

    private RatingStrategy ratingStrategy;
    private int totalRatings;
    private double averageRating;

    public Recipe(String title, String description, int servingSize) {
        this.title = title;
        this.description = description;
        this.servingSize = servingSize;
        ratingStrategy = new AverageRatingStrategy();
    }

    public void addRating(int rating) {
        ratingStrategy.updateRatings(this, rating);
    }

    public double getImpact() {
        return ratingStrategy.computeImpact(this);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addCategory(Category category) {
        if (categories.size() < 3) categories.add(category);
        else System.out.println("You can't add more than 3 categories");
    }

    public void addTag(Tag tag) {
        if (tags.size() < 3) tags.add(tag);
        else System.out.println("You can't add more than 3 tags");
    }

}
