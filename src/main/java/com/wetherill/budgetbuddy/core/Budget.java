package com.wetherill.budgetbuddy.core;

import java.util.ArrayList;
import java.util.Objects;

public class Budget {

    private String name;
    private ArrayList<Money> components;

    public Budget(String name, ArrayList<Money> components) {
        this.name = name;
        this.components = components;
        if (this.components == null) {
            this.components = new ArrayList<>();
        }
    }

    public Budget(String name) {
        this(name, new ArrayList<>());
    }

    public Budget(ArrayList<Money> components) {
        this("", components);
    }

    public Budget() {
        this("", new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ArrayList<Money> getComponents() {
        return components;
    }

    public void add(Money component) {
        components.add(component);
    }

    public void add(Budget budget) {
        for (Money component : budget.getComponents()) {
            this.add(component);
        }
    }

    @Override
    public String toString() {
        return "Budget{" +
                "name='" + name + '\'' +
                ", components=" + components +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Budget)) return false;
        Budget budget = (Budget) o;
        return Objects.equals(name, budget.name) &&
                components.equals(budget.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, components);
    }
}
