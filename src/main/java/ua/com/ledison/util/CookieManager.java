package ua.com.ledison.util;

import ua.com.ledison.entity.CartDTO;
import ua.com.ledison.entity.CartItemDTO;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CookieManager {

	public static Cookie saveCartToCookie(String cookieName, CartDTO cartDTO, int maxAge) {
		String str = Arrays.asList(cartDTO.toString()).toString().replaceAll(", ", "&");

		Cookie newCookie = new Cookie(cookieName, str);
		newCookie.setMaxAge(maxAge);
		return newCookie;
	}

	public static CartDTO convertCookieToCartDTO(String cartCookie) {
		CartDTO cartDTO = new CartDTO();
		List<CartItemDTO> cartItemsDTO = new ArrayList<>();

		Pattern pattern = Pattern.compile("(\\w+)(=)(\\d+\\.\\d+|\\d+|-\\d+)");
		Matcher matcher = pattern.matcher(cartCookie + "&");

		List<SearchCriteria> searchCriteriaList = new ArrayList<>();

		while (matcher.find()) {
			searchCriteriaList.add(new SearchCriteria(matcher.group(1), matcher.group(3)));
		}

		for (int i = 0; i < searchCriteriaList.size(); ) {
			Integer cartItemId = Integer.parseInt(searchCriteriaList.get(i++).getValueAsString());
			Integer productId = Integer.parseInt(searchCriteriaList.get(i++).getValueAsString());
			Integer quantity =Integer.parseInt(searchCriteriaList.get(i++).getValueAsString());
			Double totalPrice = Double.parseDouble(searchCriteriaList.get(i++).getValueAsString());

			cartItemsDTO.add(new CartItemDTO(cartItemId, productId, quantity, totalPrice));

			cartDTO.setGrandTotal(Math.roundDoubleValue(cartDTO.getGrandTotal() + totalPrice,2));
		}

		cartDTO.setCartItems(cartItemsDTO);

		return cartDTO;
	}
}
