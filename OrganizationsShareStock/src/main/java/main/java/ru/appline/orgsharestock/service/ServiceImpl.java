package main.java.ru.appline.orgsharestock.service;

import main.java.ru.appline.orgsharestock.model.Organization;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ServiceImpl implements Service {

    @Override
    public void printAllOrganization(List<Organization> organizations) {
        System.out.println("Краткое название - Дата основания \n");
        organizations.stream()
                .map(organization -> String.format("%s - %s", organization.getNameShort(), organization.getEgrulDate()
                        .format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))))
                .forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printAllOverdueSecurities(List<Organization> organizations) {
        System.out.println("Просроченные ценные бумаги: \n");
        organizations.stream()
                .map(Organization::getSecurities)
                .flatMap(Collection::stream)
                .filter((s) -> s.getDateTo().isBefore(LocalDate.now()))
                .map(security -> String.format("%s, %s, %s", security.getCode(), security.getDateTo(), security.getNameCompany()))
                .forEach(System.out::println);
        System.out.println();
        long count = organizations.stream()
                .map(Organization::getSecurities)
                .flatMap(Collection::stream)
                .filter(x -> x.getDateTo().isBefore(LocalDate.now()))
                .count();
        System.out.println("Общее количество: " + count);
        System.out.println();
    }

    @Override
    public void printOrganizationsBasedAfterDate(List<Organization> organizations, String date) {
        System.out.println("Организации, основанные после " + date + ": \n");
        organizations.stream()
                .filter(organization -> organization.getEgrulDate().isAfter(Objects.requireNonNull(Organization.parseDate(date))))
                .map(organization -> String.format("%s, %s", organization.getNameShort(), organization.getEgrulDate()))
                .forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printSecuritiesUsingCurrency(List<Organization> organizations, String currency) {
        System.out.println("Ценные бумаги в: " + currency + "\n");
        organizations.stream()
                .map(Organization::getSecurities)
                .flatMap(Collection::stream)
                .filter(security -> security.getCurrency().getCode().equals(currency))
                .map(security -> String.format("%s, %s", security.getId(), security.getCode()))
                .forEach(System.out::println);
        System.out.println();
    }
}
