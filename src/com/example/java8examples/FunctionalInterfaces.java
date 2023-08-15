package com.example.java8examples;

abstract class FunctionalInterfaces {
	//anotasyon ile kullanım
	@FunctionalInterface
	interface Square {
	    int calculate(int x);
	}
	public static void main(String[] args) {
		//functional interface yapısına lambda kullanımı
		new Thread(() -> {
            System.out.println("New thread created");
        }).start();
		
		//anotasyonlu interface kullanımı
		Square s=(x)->x*x;
		System.out.println(s.calculate(5));
	}

}
