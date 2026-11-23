package enumerations.composition.exercise1;

import enumerations.composition.exercise1.entities1.Departament;
import enumerations.composition.exercise1.entities1.HourContract;
import enumerations.composition.exercise1.entities1.Worker;
import enumerations.composition.exercise1.enums1.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Worker worker;
        HourContract contract;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("-".repeat(10) + "| WORKER DATA |" + "-".repeat(10));

        System.out.print("Enter department's name: ");
        String department = sc.nextLine();
        Departament dep = new Departament(department);

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Level(Junior, Mid, Senior): ");
        String strlevel = sc.next().toUpperCase();
        WorkerLevel level = WorkerLevel.valueOf(strlevel);

        System.out.print("Base Salary: R$ ");
        double salary = sc.nextDouble();

        worker = new Worker(name, level, salary, dep);

        System.out.println("-".repeat(10) + "| CONTRACT DATA |" + "-".repeat(10));

        System.out.print("Number of contracts: ");
        int contracts = sc.nextInt();

        for (int i = 1; i <= contracts; i++) {
            System.out.printf("Contract #%d:\n", i);
            System.out.print("Date(dd/mm/yyyy): ");
            sc.nextLine();
            String strDate = sc.next();
            LocalDate date = LocalDate.parse(strDate, fmt);

            System.out.print("ValuePerHour: R$ ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Hours: ");
            int hours = sc.nextInt();

            worker.addContract(new HourContract(date, valuePerHour, hours));
            System.out.println("");
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();

        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

    }
}
