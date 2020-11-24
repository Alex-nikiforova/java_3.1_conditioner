package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConditionerTest {
    Conditioner conditioner = new Conditioner();

    @Test
    public void shouldGetAndSet() {

        String expected = "Кондишн";
        assertNull(conditioner.getName());
        conditioner.setName(expected);
        assertEquals(expected, conditioner.getName());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'current t = min t', 32, 16, 17",
                    "'current t = 31°C', 32, 31, 32",
                    "'current t = max t', 32, 32, 32"
            }
    )
    public void shouldIncreaseCurrentTemperature(String test, int maxTemperature, int currentTemperature, int expectedTemperature) {
        conditioner.setMaxTemperature(maxTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.increaseCurrentTemperature();


        assertEquals(expectedTemperature, conditioner.getCurrentTemperature());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'current t = min t', 16, 16, 16",
                    "'current t = 17°C', 16, 17, 16",
                    "'current t = max t', 16, 32, 31"
            }
    )
    public void shouldDecreaseTemperature(String test, int minTemperature, int currentTemperature, int expectedTemperature) {
        conditioner.setMinTemperature(minTemperature);
        conditioner.setCurrentTemperature(currentTemperature);
        conditioner.decreaseCurrentTemperature();

        assertEquals(expectedTemperature, conditioner.getCurrentTemperature());
    }

}