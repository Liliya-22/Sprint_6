package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception{
        lion = new Lion("Самец", feline);
    }

    @Test
    public void createLionThrowsException() {
    assertThrows(Exception.class, () -> new Lion("InvalidSex", feline));
    }

    @Test
    public void getKittensIsCorrect() throws Exception{

        int expectedCount = 5;
        Mockito.when(feline.getKittens()).thenReturn(expectedCount);

        MatcherAssert.assertThat("Некорректное количество котят",
                lion.getKittens(),
                equalTo(expectedCount)
        );
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedListOfFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedListOfFood);
        List<String> actual = lion.getFood();
        assertEquals(expectedListOfFood, actual);
    }

}
