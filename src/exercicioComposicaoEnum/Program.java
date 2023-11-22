package exercicioComposicaoEnum;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Enter the departament's name: ");
		String namedp = input.next();
		
		System.out.println("Enter worker data");
		System.out.print("Name: ");
		String wName = input.next();
		System.out.print("Level: ");
		String level = input.next();
		System.out.print("Base Salary: ");
		Double wSalary = input.nextDouble();
		Worker worker = new Worker(wName,WorkerLevel.valueOf(level),wSalary, new Departament(namedp));
		
		System.out.print("How many contracts to this worker?: ");
		int n = input.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println("Enter contract #" + (i+1) + " data:" );
			System.out.print("Date (DD/MM/YYYY): ");
			LocalDate date = LocalDate.parse(input.next(),dtf);
			System.out.print("Value per hour: ");
			double value = input.nextDouble();
			System.out.print("Duration (hours): ");
			int hour = input.nextInt();
			HourContract contract = new HourContract(date,value,hour);
			worker.addContracts(contract);
		}
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		DateTimeFormatter mmyyyy = DateTimeFormatter.ofPattern("MM/yyyy");
		String monthYear = input.next();
		//YearMonth contractDate = YearMonth.parse(monthYear,mmyyyy); <--Maneira que fiz sozinho
		int year = Integer.parseInt(monthYear.substring(0,2)); // <-- Maneira que o professor usou
		int month = Integer.parseInt(monthYear.substring(3)); 
		System.out.println(worker);
		System.out.print("Income for "+ monthYear +": " + String.format( "%.2f",worker.income(month,year )));
		//System.out.printf("%.2f",worker.income(year, month));
	
		input.close();
	}

}
