package ua.com.ledison.service;

import org.springframework.data.jpa.domain.Specification;
import ua.com.ledison.entity.Product;
import ua.com.ledison.util.SearchCriteria;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

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
        } else if (criteria.getOperation().equalsIgnoreCase("-")) {
            String[] values = criteria.getValue().toString().split(";");
            return builder.between(
                    root.get(criteria.getKey()), values[0], values[1]);
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (criteria.getValue().toString().contains(";")) {
                String[] values = criteria.getValue().toString().split(";");
                List<Predicate> predicates = new ArrayList<>();
                if (criteria.isJoinColumn()) {
                    for (String value : values) {
                        predicates.add(builder.equal(root.join(criteria.getJoinEntity()).get(criteria.getKey()), value));
                    }
                } else {
                    for (String value : values) {
                        predicates.add(builder.equal(root.get(criteria.getKey()), value));
                    }
                }
                Predicate[] p = predicates.toArray(new Predicate[predicates.size()]);
                return builder.or(p);
            } else {
                if (criteria.isJoinColumn()) {
                    return builder.equal(root.join(criteria.getJoinEntity()).get(criteria.getKey()), criteria.getValue());
                }
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
            }
        }
        return null;
    }


}
