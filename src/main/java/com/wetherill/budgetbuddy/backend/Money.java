package com.wetherill.budgetbuddy.backend;

import java.text.DecimalFormat;
import java.util.Objects;

public class Money {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    private double value;
    private String name;
    private String note;

    public Money(double value, String name, String note) {
        this.value = value;
        this.name = name;
        this.note = note;
    }

    public Money() {
        this(0, "", "");
    }

    public Money(double value) {
        this(value, "", "");
    }

    public Money(double value, String name) {
        this(value, name, "");
    }

    public Money(String name, String note) {
        this(0, name, note);
    }

    private double getValue() {
        return value;
    }

    private String getName() {
        return name;
    }

    private String getNote() {
        return note;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void add(Money money) {
        this.value += money.getValue();
    }

    public void subtract(Money money) {
        this.value -= money.getValue();
    }

    public boolean isPositive() {
        return value > 0;
    }

    public boolean isNegative() {
        return value < 0;
    }

    public boolean isZero() {
        return value == 0;
    }

    public boolean isGreaterThan(Money money) {
        return value > money.getValue();
    }

    public boolean isLessThan(Money money) {
        return value < money.getValue();
    }

    public boolean isEqualTo(Money money) {
        return value == money.getValue();
    }

    public double percentageOf(Money money) {
        return value / money.getValue() * 100;
    }

    public String toDisplay() {
        return "$" + DECIMAL_FORMAT.format(value);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return Double.compare(money.value, value) == 0 &&
                Objects.equals(name, money.name) &&
                Objects.equals(note, money.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, name, note);
    }
}
