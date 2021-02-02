package main.java.ru.appline.orgsharestock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;

public class Security {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("code")
    private String code;
    @JsonProperty("name_company")
    private String nameCompany;
    @JsonProperty("date_to")
    private String dateTo;
    @JsonProperty("state_reg_date")
    private String stateRegDate;
    @JsonProperty("currency")
    private Currency currency;

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    @JsonProperty("name_company")
    public String getNameCompany() {
        return nameCompany;
    }

    @JsonProperty("date_to")
    public LocalDate getDateTo() {
        return LocalDate.parse(this.dateTo);
    }

    @JsonProperty("state_reg_date")
    public String getStateRegDate() {
        return stateRegDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("code", getCode())
                .append("nameCompany", getNameCompany())
                .append("dateTo", getDateTo())
                .append("stateRegDate", getStateRegDate())
                .append("currency", getCurrency())
                .toString();
    }
}