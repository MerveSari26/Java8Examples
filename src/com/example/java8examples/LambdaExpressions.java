package com.example.java8examples;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressions {
	//Fonksiyonel Interface
	interface lambdaInterface{
		int addTwoNum(int a,int b);
	}
	//Lambda Expression Example: Comparator
	public static class student{
		String name;
		int age;
		double grade;
		public student(String name,int age,double grade) {
			this.name=name;
			this.age=age;
			this.grade=grade;
		}
		public double getGrade() {
			return grade;
		}
	}

	public static void main(String[] args) {
		lambdaInterface Iprint,Iadder;
		List<student>students=new ArrayList<>();
		students.add(new student("Merve",25,3.05));
		students.add(new student("Mustafa",30,2.05));
		students.add(new student("Karabas",5,4.00));
		students.add(new student("Ozge",24,3.95));
		
		List<String> words = new ArrayList<>();
        words.add("Merve");
        words.add("Sari");
        words.add("Lambda");
        words.add("Expression");
        words.add("Example");
        words.add("Bstart");

        // Lambda ifadesiyle bir liste üzerinde dolaşma ve her bir elemanı yazdırma
        words.forEach(word -> System.out.println(word));

        //listenin her bir elemanını büyük harfe çevirme
        words.replaceAll(word -> word.toUpperCase());

        //filtremele yapma ve belirli bir kurala uyanları listeden çıkarma
        words.removeIf(word -> word.startsWith("B")); 
        
        //lambda ifadesi ile lambdaInterface arayüzünü implement ettirme
        //a ve b argümanları - > ve gövde, tek ifade süslü paranteze gerek yok
        Iadder=(a,b)->a+b;
        System.out.println(Iadder.addTwoNum(5,10));
        
        //lambda ile thread başlatma
        Runnable r1=()->{  
        	System.out.println("Thread1 is running...");  
         };  
        Thread t1=new Thread(r1);  
            t1.start();  
          
        // Sort with Lambda and Comparator example
        students.sort((o1, o2) -> Double.compare(o1.getGrade(), o2.getGrade()));
        students.forEach(s -> System.out.println(s.name+" , "+s.age+" , "+s.grade));
         
        }	
}
