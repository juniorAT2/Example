package it.accenture.model.abstractions;

public interface WithId<K> {
    K getId();
    void setId(K id);
}
