package ua.com.ledison.dao;

import org.springframework.data.jpa.domain.Specification;
import ua.com.ledison.entity.Product;
import ua.com.ledison.util.SearchCriteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {

	private SearchCriteria criteria;

	public ProductSpecification(final SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		if (criteria.getOperation().equalsIgnoreCase(">")) {
			return builder.greaterThanOrEqualTo(
					root.get(criteria.getKey()), criteria.getValue().toString());
		}
		else if (criteria.getOperation().equalsIgnoreCase("<")) {
			return builder.lessThanOrEqualTo(
					root.get(criteria.getKey()), criteria.getValue().toString());
		}
		else if (criteria.getOperation().equalsIgnoreCase(":")) {
			if (criteria.getValue().toString().contains(";")) {
				String[] values = criteria.getValue().toString().split(";");
				for (String value : values) {
					return builder.and(builder.equal(root.get(criteria.getKey()), value));
				}
			} else {
				return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
//				return builder.equal(root.get(criteria.getKey()), criteria.getValue());
			}
		}
		return null;
	}
}
