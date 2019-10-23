package org.itstep;

// Есть стандартный итератор. Зачем этот нужен?
public interface Iterator {
    boolean hasNext();
    Object next();
}
