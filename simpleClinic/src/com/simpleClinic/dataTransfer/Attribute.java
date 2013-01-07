package com.simpleClinic.dataTransfer;
import java.io.Serializable;

public class Attribute<G extends AttributeGroup, T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public Attribute(String name) {

        if (name == null) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public static  <F extends AttributeGroup, S> Attribute<F, S> getInstance(
            String name) {
		return new Attribute<F, S>(name);
    }

    @Override
    public String toString() {
        return name;
    }

    // equals(), hashCode() ...
}