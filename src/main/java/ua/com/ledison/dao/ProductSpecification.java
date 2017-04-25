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
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                    root.get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (criteria.getValue().toString().contains(";")) {
                String[] values = criteria.getValue().toString().split(";");
                Predicate predicate = null;
                for (String value : values) {
                    System.out.println("!!!! --- " + value);
                    if (predicate == null) {
                        predicate = builder.equal(root.get(criteria.getKey()), value);
                    } else {
                        predicate = builder.and(builder.equal(root.get(criteria.getKey()), value), predicate);
                        System.out.println("@@@@@" + predicate.getExpressions());
                    }
                }
                return predicate;
            } else {
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
            }
        }
        return null;
    }
}
