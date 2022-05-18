package com.bookworm.ebook.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.ebook.entity.CartEntity;
import com.bookworm.ebook.entity.EbookEntity;
import com.bookworm.ebook.exception.BookAlreadyPresentInCartException;
import com.bookworm.ebook.model.Cart;
import com.bookworm.ebook.repo.CartRepository;
import com.bookworm.ebook.service.CartService;

@Service("cartService")
@Transactional()
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepo;
	
	@Override
	public void addToCart(Cart cart) throws BookAlreadyPresentInCartException {
		EbookEntity ebook = ServiceLocator.getEbookService().viewBook(cart.getBookId()).convertToEntity();
		List<CartEntity> books = cartRepo.findByUserIdAndBookIdAndAction(cart.getUserId(), ebook, cart.getAction());
		if (books.size() == 0) {
			cartRepo.save(cart.convertToEntity(ebook));
		} else {
			throw new BookAlreadyPresentInCartException();
		}
	}

	@Override
	public void clearCart(Integer userId) {
		cartRepo.clearCart(userId);
	}

	@Override
	public void deleteBookFromCart(Integer cartId) {
		cartRepo.deleteById(cartId);
	}

	@Override
	public List<CartEntity> fetchAllItemsByUserId(Integer userId) {
		return cartRepo.findByUserId(userId);
	}

}
