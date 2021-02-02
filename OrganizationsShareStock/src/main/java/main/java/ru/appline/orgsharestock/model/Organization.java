package main.java.ru.appline.orgsharestock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Organization {
    @JsonProperty("name_full")
    private String nameFull;
    @JsonProperty("name_short")
    private String nameShort;
    @JsonProperty("inn")
    private String inn;
    @JsonProperty("ogrn")
    private String ogrn;
    @JsonProperty("egrul_date")
    private String egrulDate;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phone")
    private String phone;
    private List<Security> securities = new ArrayList<Security>();

    public Organization() {
    }

    @JsonProperty("name_short")
    public String getNameShort() {
        return nameShort;
    }

    @JsonProperty("egrul_date")
    public LocalDate getEgrulDate() {
        return LocalDate.parse(this.egrulDate);
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public static LocalDate parseDate(String strDate) {

        try {
            if ((strDate != null) && !("").equals(strDate)) {

                DateTimeFormatter parser = DateTimeFormatter.ofPattern("[dd/MM/yyyy][dd/MM/yy][dd.MM.yyyy][dd.MM.yy]");
                LocalDate date = LocalDate.parse(strDate, parser);
                return date;
            }
        } catch (NullPointerException | DateTimeParseException e) {
            System.out.println("Неверный формат даты.");
        }
        return null;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("nameFull", nameFull)
                .append("nameShort", nameShort)
                .append("inn", inn)
                .append("ogrn", ogrn)
                .append("egrulDate", egrulDate)
                .append("address", address)
                .append("phone", phone)
                .append("securities", securities)
                .toString();
    }
}