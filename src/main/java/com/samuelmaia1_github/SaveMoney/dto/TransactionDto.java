package com.samuelmaia1_github.SaveMoney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
public class TransactionDto {
    private String id;
    private String type;
    private Double value;
    private LocalDate date;
    private String description;
    private Boolean isCurrent;
    private String source;
    private String receiver;
    private String category;

    public TransactionDto(
            String id,
            String type,
            Double value,
            LocalDate date,
            String description,
            Boolean isCurrent,
            String source
    ) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.date = date;
        this.description = description;
        this.isCurrent = isCurrent;
        this.source = source;
    }

    public TransactionDto(
            String id,
            String type,
            Double value,
            LocalDate date,
            String description,
            Boolean isCurrent,
            String receiver,
            String category
    ) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.date = date;
        this.description = description;
        this.isCurrent = isCurrent;
        this.receiver = receiver;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsCurrent() {
        return isCurrent;
    }

    public String getSource() {
        return source;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getCategory() {
        return category;
    }
}
