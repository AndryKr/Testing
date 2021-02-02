package main.java.ru.appline.orgsharestock.service;

import main.java.ru.appline.orgsharestock.model.Organization;

import java.util.List;

public interface Service {

    void printAllOrganization(List<Organization> organizations);

    void printAllOverdueSecurities(List<Organization> organizations);

    void printOrganizationsBasedAfterDate(List<Organization> organizations, String date);

    void printSecuritiesUsingCurrency(List<Organization> organizations, String currency);
}
