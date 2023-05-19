package edu.estu.strategy.rating.abstracts;

import edu.estu.entities.Recipe;

public interface RatingStrategy {
    void updateRatings(Recipe recipe, int rating);

    double computeImpact(Recipe recipe);
}
