package edu.estu.strategy.rating.concretes;

import edu.estu.entities.Recipe;
import edu.estu.strategy.rating.abstracts.RatingStrategy;

public class AverageRatingStrategy implements RatingStrategy {
    @Override
    public void updateRatings(Recipe recipe, int rating) {
        recipe.setTotalRatings(recipe.getTotalRatings() + 1);
        recipe.setAverageRating((recipe.getAverageRating() * (recipe.getTotalRatings() - 1) + rating) / recipe.getTotalRatings());
    }

    @Override
    public double computeImpact(Recipe recipe) {
        return recipe.getAverageRating();
    }
}
