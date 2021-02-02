package main.java.ru.appline.orgsharestock;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.ru.appline.orgsharestock.model.Organization;
import main.java.ru.appline.orgsharestock.service.Service;
import main.java.ru.appline.orgsharestock.service.ServiceImpl;

import java.io.*;
import java.util.List;

public class DoMain {

    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            InputStream inputStream = new FileInputStream("src/main/resources/CompaniesData.json");

            List<Organization> organizations = objectMapper.readValue(inputStream, new TypeReference<List<Organization>>() {
            });

            Service service = new ServiceImpl();
            service.printAllCompanies(organizations);
            service.printPastDueSecurities(organizations);
            service.printCompaniesBasedAfterDate(organizations, "10.12.1999");
            service.printSecuritiesUsingCurrency(organizations, "RUB");

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}