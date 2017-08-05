package epam.java.flowers;

import java.util.List;

public interface  Type {
	Type getType();
	Type getSyperType();
	List<Type> getSubTypes();
}
