package ua.com.ledison.util;

import ua.com.ledison.entity.CartDTO;
import ua.com.ledison.entity.CartItem;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CookieManager {

	public static Cookie saveCartToCookie(String cookieName, CartDTO cartDTO, int maxAge){
		String str = Arrays.asList(cartDTO.toString()).toString().replaceAll(", ", "&");

		Cookie newCookie = new Cookie(cookieName, str);
		newCookie.setMaxAge(maxAge);
		return newCookie;
	}

	public static CartDTO convertCookieToCartDTO(String cartCookie){
		CartDTO cartDTO = new CartDTO();
		List<CartItem> cartItems = new ArrayList<>();

		Pattern pattern = Pattern.compile("\"(\\w+?)(=)(\\w+?)\"");
		Matcher matcher = pattern.matcher(cartCookie + "&");

		while (matcher.find()) {
			cartItems.add(new CartItem(Integer.parseInt(matcher.group(2)), Double.parseDouble(matcher.group(3))));
		}

		cartDTO.setCartItems(cartItems);

		return cartDTO;
	}

}
