package ua.com.ledison.dao;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import ua.com.ledison.entity.Product;
import ua.com.ledison.util.SearchCriteria;

import java.util.ArrayList;
import java.util.List;

public final class ProductSpecificationsBuilder {

	private final List<SearchCriteria> params;

	public ProductSpecificationsBuilder(ArrayList<SearchCriteria> params) {
		this.params = params;
	}

	public ProductSpecificationsBuilder with(String key, String operation, Object value) {
		params.add(new SearchCriteria());
		return this;
	}

	public Specification<Product> build() {
		if (params.size() == 0) {
			return null;
		}

		List<Specification<Product>> specs = new ArrayList<>();
		for (SearchCriteria param : params) {
			specs.add(new ProductSpecification(param));
		}

		Specification<Product> result = specs.get(0);
		for (int i = 1; i < specs.size(); i++) {
			result = Specifications.where(result).and(specs.get(i));
		}
		return result;
	}
}