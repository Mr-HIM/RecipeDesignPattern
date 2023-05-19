package edu.estu.entities;

import edu.estu.common.DataSource;

public record Ingredient(String name, double amount, Unit unit) implements DataSource.Entity {
}

