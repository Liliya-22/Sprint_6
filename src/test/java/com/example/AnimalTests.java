package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTests {
    Animal animal = new Animal();

    @Test
    public void getFamilyIsCorrect() {
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        MatcherAssert.assertThat("Некорректный перечень семейств",
                new Animal().getFamily(),
                equalTo(expectedString)
        );
    }


        @Test
        public void getFoodCheckException() throws Exception {
            List<String> expectedPredatorFood = List.of("Животные", "Птицы", "Рыба");
            String expectedExceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

            try {
                List<String> actualAnimalFood = animal.getFood("animalKind");
                assertEquals(expectedPredatorFood, actualAnimalFood);
            } catch (Exception exception) {
                String actualException = exception.getMessage();
                assertEquals(expectedExceptionMessage, actualException);
            }
        }
    }
