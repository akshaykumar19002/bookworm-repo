package com.bookworm.ebook.service;

import java.util.List;

import com.bookworm.ebook.entity.CartEntity;
import com.bookworm.ebook.exception.BookAlreadyPresentInCartException;
import com.bookworm.ebook.model.Cart;

public interface CartService {

	void addToCart(Cart cart) throws BookAlreadyPresentInCartException;

	void clearCart(Integer userId);

	List<CartEntity> fetchAllItemsByUserId(Integer userId);

	void deleteBookFromCart(Integer cartId);

}
