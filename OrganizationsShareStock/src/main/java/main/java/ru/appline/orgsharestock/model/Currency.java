package main.java.ru.appline.orgsharestock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Currency {
    @JsonProperty("code")
    private String code;
    @JsonProperty("name_full")
    private String nameFull;

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("name_full")
    public String getNameFull() {
        return nameFull;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", getCode())
                .append("nameFull", getNameFull())
                .toString();
    }

}