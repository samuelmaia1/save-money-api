package com.samuelmaia1_github.SaveMoney.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class TransactionRequestDto {
    @NotNull
    String type;

    @NotNull
    String title;

    @NotNull @Positive
    Double value;

    @NotNull
    Boolean isCurrent;

    @NotBlank
    String description;

    @NotNull @PastOrPresent @JsonFormat
    LocalDate date;

    String receiver;
    String category;

    String source;

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public @NotNull @Positive Double getValue() {
        return value;
    }

    public void setValue(@NotNull @Positive Double value) {
        this.value = value;
    }

    public @NotNull Boolean getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(@NotNull Boolean current) {
        isCurrent = current;
    }

    public @NotBlank String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank String description) {
        this.description = description;
    }

    public @NotNull @PastOrPresent LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull @PastOrPresent LocalDate date) {
        this.date = date;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public @NotNull String getType() {
        return type;
    }

    public void setType(@NotNull String type) {
        this.type = type;
    }

    public void validate() {
        if (isExpense() && (receiver == null || category == null)) {
            throw new IllegalArgumentException("Atributos receiver e category necessários");
        }
        if (isIncome() && source == null) {
            throw new IllegalArgumentException("Atributo source é necessário");
        }
    }

    public boolean isExpense() {
        return this.type.toLowerCase().equals("expense");
    }

    public boolean isIncome() {
        return this.type.toLowerCase().equals("income");
    }
}
