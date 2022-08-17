package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CorporatePayer;
import entities.IndividualPayer;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n= sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.println("Individual or company (i/c) ?");
			System.out.print("Answer: ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			if (ch == 'i' || ch == 'I'){
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				
				list.add(new IndividualPayer(name, anualIncome, healthExpenditures));
			}
			
			else if (ch == 'c' || ch == 'C') {
				System.out.print("Number of employees: ");
				int numbEmployees = sc.nextInt();
				
				list.add(new CorporatePayer(name, anualIncome, numbEmployees));
			}
			
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		double totalTaxes = 0;
		for (TaxPayer taxPayer : list) {
			System.out.println(taxPayer.getName() + ": $" + String.format("%.2f", taxPayer.taxValue()));
			totalTaxes += taxPayer.taxValue();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", totalTaxes));
		
		sc.close();

	}

}
