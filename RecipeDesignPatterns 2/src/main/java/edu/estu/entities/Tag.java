package edu.estu.entities;

import edu.estu.common.DataSource;

public record Tag(String name) implements DataSource.Entity {
}
