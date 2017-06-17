package ua.com.ledison.util;

import ua.com.ledison.entity.CartDTO;

import javax.servlet.http.Cookie;
import java.util.Arrays;

public class CookieManager {

	public static Cookie saveCartToCookie(CartDTO cartDTO, int maxAge){
		String str = Arrays.asList(cartDTO.toString()).toString().replaceAll(", ", "&");

		Cookie newCookie = new Cookie("cart", str);
		newCookie.setMaxAge(maxAge);
		return newCookie;
	}

}
