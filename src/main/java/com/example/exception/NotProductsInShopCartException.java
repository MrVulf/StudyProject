package com.example.exception;

public class NotProductsInShopCartException extends Exception {

    private static final String DEFAULT_MESSAGE = "Not enough products in stock";

    public NotProductsInShopCartException() {
        super(DEFAULT_MESSAGE);
    }

}
