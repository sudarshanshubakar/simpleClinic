package com.simpleClinic.dataTransfer;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DTO<G extends AttributeGroup> implements Serializable {

	private static final long serialVersionUID = 1L;
	private Class<G> attributeGroup;
	private Map<Attribute<G, ?>, Object> attributes = new LinkedHashMap<Attribute<G, ?>, Object>();

	private DTO(Class<G> attributeGroup) {
		this.attributeGroup = attributeGroup;
	}

	public static <B extends AttributeGroup> DTO<B> getInstance(Class<B> clazz) {
		return new DTO<B>(clazz);
	}

	public <T> DTO<G> set(Attribute<G, T> identifier, T value) {
		attributes.put(identifier, value);
		return this;
	}

	public <T> T get(Attribute<G, T> identifier) {

		@SuppressWarnings("unchecked")
		T theValue = (T) attributes.get(identifier);

		return theValue;
	}

	public <T> T remove(Attribute<G, T> identifier) {

		@SuppressWarnings("unchecked")
		T theValue = (T) attributes.remove(identifier);

		return theValue;
	}

	public void clear() {
		attributes.clear();
	}

	public int size() {
		return attributes.size();
	}

	public Set<Attribute<G, ?>> getAttributes() {
		return attributes.keySet();
	}

	public boolean contains(Attribute<G, ?> identifier) {

		return attributes.containsKey(identifier);
	}

	@Override
	public String toString() {
		return attributeGroup.getSimpleName() + " [" + attributes + "]";
	}

	// equals(), hashCode() ...
}