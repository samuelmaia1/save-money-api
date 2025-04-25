package com.samuelmaia1_github.SaveMoney.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

public class TransactionDto {
    private String id;
    private String type;
    private Double value;
    private LocalDate date;
    private String description;
    private String source;
    private String receiver;
    private String category;
    private String title;

    public TransactionDto() {}

    public TransactionDto(
            String id,
            String type,
            Double value,
            LocalDate date,
            String description,
            String source,
            String category,
            String title
    ) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.date = date;
        this.description = description;
        this.source = source;
        this.title = title;
        this.category = category;
    }

    public TransactionDto(
            String id,
            String type,
            Double value,
            LocalDate date,
            String description,
            String receiver,
            String category,
            String title,
            Boolean isExpense
    ) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.date = date;
        this.description = description;
        this.receiver = receiver;
        this.category = category;
        this.title = title;
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

    public String getSource() {
        return source;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }
}
