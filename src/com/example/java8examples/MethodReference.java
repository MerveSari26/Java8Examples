package com.example.java8examples;

import java.time.LocalDate;
import java.util.function.Supplier;

public class MethodReference {
	public static class Intern{
		String name;
		int age;
		String startDate;
		String finishDate;
		//Suplier için eklendi
		 public Intern() {
		        // Varsayılan değerler
		        this.name = "Unknown";
		        this.age = 0;
		        this.startDate = "N/A";
		        this.finishDate = "N/A";
		}
		public Intern(String name, int age, String startDate, String finishDate) {
	            this.name = name;
	            this.age = age;
	            this.startDate = startDate;
	            this.finishDate = finishDate;
	    }
		public static int calculateInternshipPeriod(String startDate, String finishDate) {
	            LocalDate startLocalDate = LocalDate.parse(startDate);
	            LocalDate finishLocalDate = LocalDate.parse(finishDate);
	            return (int) startLocalDate.until(finishLocalDate).toTotalMonths();
	    }
		public int calculateInternshipPeriod() {
			 LocalDate startLocalDate = LocalDate.parse(startDate);
	         LocalDate finishLocalDate = LocalDate.parse(finishDate);
	         return (int) startLocalDate.until(finishLocalDate).toTotalMonths();
		}
		public String getInternName() {
			return name;
		}

		
	}
	
	@FunctionalInterface
    interface InternallyCalculator {
        int calculate(String startDate, String finishDate);
    }
	@FunctionalInterface
    interface InstanceMethodReference {
        int calculate();
    }
	
	public static void main(String[] args) {
		Intern intern = new Intern("Merve SARI", 25, "2023-07-03", "2023-08-25");
		
		 // Statik metod referansı kullanımı
		InternallyCalculator calculator = Intern::calculateInternshipPeriod;
        String startDate = "2023-07-03";
        String finishDate = "2023-08-25";
        int period = calculator.calculate(startDate, finishDate);
        System.out.println("Internship period: " + period + " months");
        
        //Constructor metod referans, sınıf özellikleri değiştirilebiliyor.
        Supplier<Intern> internSupplier = Intern::new;
        Intern intern2 = internSupplier.get();
        intern2.name="Demet CICEK";
        System.out.println("Interner's name: " + intern2.getInternName());
        
        //Instance method referans
        Intern intern3=new Intern("Buket DEMET",22,"2023-08-04","2023-11-05");
        InstanceMethodReference calculator2=intern3::calculateInternshipPeriod;
        int period2=calculator2.calculate();
        System.out.println("Internship period: " + period2 + " months");
	}

}
