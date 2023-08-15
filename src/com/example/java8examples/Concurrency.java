package com.example.java8examples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Concurrency {

	public static void main(String[] args) {
		//8 thread oluşturuyor
		ExecutorService executor=Executors.newFixedThreadPool(8); 
		
		//Callable arayüzü ile Callable<Integer> nesnesi listesi
		List<Callable<Integer>> listOfCallable = new ArrayList<>(
                Arrays.asList(
                    () -> { int a = 1; int b = 2; System.out.println("Callable 1 -> " + (a + b)); return a + b; },
                    () -> { int a = 2; int b = 2; System.out.println("Callable 2 -> " + (a + b)); return a + b; },
                    () -> { int a = 3; int b = 2; System.out.println("Callable 3 -> " + (a + b)); return a + b; },
                    () -> { int a = 4; int b = 2; System.out.println("Callable 4 -> " + (a + b)); return a + b; },
                    () -> { int a = 5; int b = 2; System.out.println("Callable 5 -> " + (a + b)); return a + b; },
                    () -> { int a = 6; int b = 2; System.out.println("Callable 6 -> " + (a + b)); return a + b; },
                    () -> { int a = 7; int b = 2; System.out.println("Callable 7 -> " + (a + b)); return a + b; }
                )
        );
		
		// ExecutorService ile birden fazla Callable işlemi paralel olarak çalıştırma ve sonuçlarını yönetme süreçleri
		try {
			executor.invokeAll(listOfCallable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("***************************************");
		//Future nesneleri, çalışan iş parçacığının sonucunu temsil eder.
		try {
			List<Future<Integer>> results = executor.invokeAll(listOfCallable);
			results.forEach(r->{
				try {
					r.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}