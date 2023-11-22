package entities;


import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Departament departament;
	private List<HourContract> contracts = new ArrayList();

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContracts(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	
	// Forma moderna e mais apropriada:
	public double income(int year, int month) {
		double sum = baseSalary;
		for (HourContract c : contracts) {
			int contractYear = c.getDate().getYear();
			int contractMonth = c.getDate().getMonthValue();
			if (contractYear == year && contractMonth == month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
	/*Forma antiga:
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance(); 
		//Criamos um calendario e atribuímos um Calendar.getInstace();
		for (HourContract c : contracts) {
			// Atribuimos a esse calendario os valores de datas 
			// aramazenados no atributo "date" do objeto do tipo 
			// HourContract presente na lista que está sendo varrida.
			cal.setTime(c.getDate());
			
			// As variaveis recebem o valor do ano e mês usando o calendario "cal"
			// para trazer com o método "cal.get" o atributo YEAR e MONTH da classe "Calendar" 
			int contract_year = cal.get(Calendar.YEAR); 									
			int contract_month = 1 + cal.get(Calendar.MONTH); 
			// foi colocado "1+" porque os meses começam a ser contados a partir do numero 0
			
			
			if (contract_year == year && contract_month == month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}*/

	@Override
	public String toString() {
		return "Name: " + getName()
			  +"\nDepartament: " + getDepartament().getName();
	}
	
	
}
