package ru.job4j.devops.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.devops.models.Result;
import ru.job4j.devops.models.TwoArgs;

/**
 * CalcController
 */
@RestController
@RequestMapping("calc")
public class CalcController {
    /**
     * Метод суммирует 2 числа
     * @param twoArgs объект с двумя числами
     * @return сумму
     */
    @PostMapping("summarise")
    public ResponseEntity<Result> summarise(@RequestBody TwoArgs twoArgs) {
        var result = twoArgs.getFirst() + twoArgs.getSecond();
        return ResponseEntity.ok(new Result(result));
    }

    /**
     * Метод умножает 2 числа
     * @param twoArgs объект с двумя числами
     * @return произведение
     */
    @PostMapping("times")
    public ResponseEntity<Result> times(@RequestBody TwoArgs twoArgs) {
        var result = twoArgs.getFirst() * twoArgs.getSecond();
        return ResponseEntity.ok(new Result(result));
    }
}
