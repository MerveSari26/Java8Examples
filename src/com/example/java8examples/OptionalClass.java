package com.example.java8examples;
import java.util.Optional;

import com.example.java8examples.StreamApi.User;

public class OptionalClass {
	public static void main(String[] args) {
		// User içi null olabilir olduğu için hata vermez.
        Optional<User> user = Optional.ofNullable(null);
        // User içi boş bir nesne oluşturuldu.
        Optional<User> user2= Optional.empty();
        // User içi dolu bir nesne oluşturuldu.
        Optional<User> user3=Optional.of(new User(3,"Karabas"));

        // filter ve ifPresent çalışmayacak çünkü user boş ancak program çalışacak
        user.filter(u -> u.id > 4).ifPresent(System.out::println);

        // User nesnesi oluşturuldu.
        user = Optional.of(new User(5, "Merve"));

        // Burada User nesnesinin id'si 5, filtre sonucu true olacak.
        user.filter(u -> u.id > 4).ifPresent(System.out::println); 
        user3.filter(u -> u.id > 2).ifPresent(System.out::println);
        
        //Sadece user2 exception çıktısı verecektir.
        user.orElseThrow(() -> new IllegalStateException("Object is empty."));
        user2.orElseThrow(() -> new IllegalStateException("Object is empty."));
        user3.orElseThrow(() -> new IllegalStateException("Object is empty."));

    }
		
	

}
