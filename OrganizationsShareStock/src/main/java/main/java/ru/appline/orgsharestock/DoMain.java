package main.java.ru.appline.orgsharestock;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.ru.appline.orgsharestock.model.Organization;
import main.java.ru.appline.orgsharestock.service.Service;
import main.java.ru.appline.orgsharestock.service.ServiceImpl;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class DoMain {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            ObjectMapper objectMapper = new ObjectMapper();

            InputStream inputStream = new FileInputStream("src/main/resources/CompaniesData.json");

            List<Organization> organizations = objectMapper.readValue(inputStream, new TypeReference<List<Organization>>() {
            });

            Service service = new ServiceImpl();
            service.printAllOrganization(organizations);
            service.printAllOverdueSecurities(organizations);

            System.out.println("Чтобы получить список организаций основаных после конкретной даты веедите дату " +
                    "\n в формате dd/MM/yyyy, dd/MM/yy, dd.MM.yyyy или dd.MM.yy");
            String date = scanner.nextLine();
            service.printOrganizationsBasedAfterDate(organizations, date);

            System.out.println("Чтобы получить список ценных бумаг по валюте введите наименование валюты " +
                    "\n из следующих вариантов: RUB, USD, EUR или UAH");
            String currency = scanner.nextLine();
            service.printSecuritiesUsingCurrency(organizations, currency);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}