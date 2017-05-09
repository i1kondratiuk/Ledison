package ua.com.ledison.util;

import ua.com.ledison.entity.Product;

import javax.persistence.JoinColumn;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SearchCriteria {

	private String key;
	private String operation;
	private Object value;
	private String joinEntity;

	static Map<String, String> joinColumns;

	public SearchCriteria() {
	}

	public SearchCriteria(final String key, final String operation, final Object value) {
		this.key = key;
		this.operation = operation;
		this.value = value;
		findJoinColumns();
	}

	private void findJoinColumns() {
		if (joinColumns == null) {
			joinColumns = new HashMap<>();
			Field[] fields = Product.class.getDeclaredFields();
			for (Field field : fields) {
				Annotation[] annotations = field.getDeclaredAnnotations();
				for (Annotation annotation : annotations) {
					if (annotation instanceof JoinColumn) {
						JoinColumn joinColumnAnnotation = (JoinColumn) annotation;
						joinColumns.put(joinColumnAnnotation.name(), field.getName());
					}
				}
			}
		}
	}

	public boolean isJoinColumn() {
		for (Map.Entry<String, String> entry : joinColumns.entrySet()) {
			if (entry.getKey().equals(this.getKey())) {
				setJoinEntity(entry.getValue());
				return true;
			}
		}
		return false;
	}

	public String getKey() {
		return key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(final String operation) {
		this.operation = operation;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(final Object value) {
		this.value = value;
	}

	public String getJoinEntity() {
		return joinEntity;
	}

	public void setJoinEntity(String joinEntity) {
		this.joinEntity = joinEntity;
	}

	@Override
	public String toString() {
		return "SearchCriteria: {" + "key=" + key + ", operation=" + operation + ", value=" + value + "}";
	}
}
