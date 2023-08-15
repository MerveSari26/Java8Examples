package com.example.java8examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {
	public static class User{
		int id;
		String name;
		public User(int id,String name) {
			this.id=id;
			this.name=name;
		}
		@Override 
		public String toString() {
			return "User [id="+id+",name="+name+"]";
		}
		public void talk() {
			System.out.println("Hi,I am "+this.name);
		}
	}
	public static void main(String[] args) {
		 List<String> programmingLanguages = Stream.of("Java", "C#", "C++", "Python", "Javascript")
		            .filter(L -> L.length() <= 4) // Filtreleme harf sayısı 4 den küçükler
		            .map(String::toUpperCase) // Haritalama
		            .sorted() // Sıralama
		            .collect(Collectors.toList()); // Sonuçları bir List'e toplama
		System.out.println(programmingLanguages); 
		
		List<User> users=new ArrayList<>();
		users.add(new User(1,"Merve"));
		users.add(new User(2,"Mustafa"));
		users.add(new User(3,"Demet"));
		users.add(new User(4,"Buket"));
		users.add(new User(5,"Flower"));
		users.add(new User(6,"Papatya"));
		
		users.stream().forEach(user->{
			System.out.println("****************************");
			System.out.println(user.toString());
			}); //Listedeki her bir user ekrana bastırılıyor.
		
		//method reference ile de kullanım
		users.stream().forEach(User::talk);
		System.out.println("****************************");
		//filter ve map methodları tek başına bir sonuç çıkaramaz sadece filtreler ve değiştirir, collect ile bu filtrelenen sonuçlar yeni listeye atıldı.
		List<User> usersFiltered=users.stream().filter(user->user.id>3).collect(Collectors.toList()); 
		usersFiltered.stream().forEach(User::talk);
		List<User> usersMapped=users.stream().map(user->new User(user.id+100,user.name)).collect(Collectors.toList());
		usersMapped.stream().forEach(user->System.out.println(user.toString()));
		
		//Listeden mape çevirme
		Map<Integer,String> userMap=users.stream().collect(Collectors.toMap(user->user.id,user->user.name));
		userMap.forEach((key,value)->System.out.println(key+":"+value));
	}
		
}
