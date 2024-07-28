package com.example.pokeapi.consultaPokeApi;

import java.util.List;

public class PokeConsulta {
    private String name;
    private int id;
    private int height;
    private int weight;
    private List<TypeSlot> types;
    private List<StatNum> stats;
    private Sprites sprites;

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }
// Getters y setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<TypeSlot> getTypes() {
        return types;
    }

    public void setTypes(List<TypeSlot> types) {
        this.types = types;
    }

    public List<StatNum> getStats() {
        return stats;
    }

    public void setStats(List<StatNum> stats) {
        this.stats = stats;
    }
}
