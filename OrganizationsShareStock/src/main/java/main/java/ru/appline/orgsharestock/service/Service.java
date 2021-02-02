package main.java.ru.appline.orgsharestock.service;

import main.java.ru.appline.orgsharestock.model.Organization;

import java.util.List;

public interface Service {

    void printAllCompanies(List<Organization> organizations);

    void printPastDueSecurities(List<Organization> organizations);

    void printCompaniesBasedAfterDate(List<Organization> organizations, String date);

    void printSecuritiesUsingCurrency(List<Organization> organizations, String currency);
}
