package edu.estu.strategy.rating.concretes;

import edu.estu.entities.Recipe;
import edu.estu.strategy.rating.abstracts.RatingStrategy;

public class TotalRatingsStrategy implements RatingStrategy {

    @Override
    public void updateRatings(Recipe recipe, int rating) {
        recipe.setTotalRatings(recipe.getTotalRatings() + 1);
    }

    @Override
    public double computeImpact(Recipe recipe) {
        return recipe.getTotalRatings();
    }
}
