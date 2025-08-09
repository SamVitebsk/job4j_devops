package ru.job4j.devops.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Объект с двумя полями для хранения входных данных и вычисления суммы и произведения
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TwoArgs {
    private double first;
    private double second;
}
