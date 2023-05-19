package edu.estu.entities;

import edu.estu.common.DataSource;

public record Category(String name) implements DataSource.Entity {
}
