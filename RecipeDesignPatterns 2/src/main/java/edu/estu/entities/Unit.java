package edu.estu.entities;

import edu.estu.common.DataSource;

public record Unit(String name) implements DataSource.Entity {
}