package com.smarthome.light.intent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class LightOFFHandlerTest {

    @InjectMocks
    private LightOFFHandler handler;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldReturnTrueWhenTheIntentNameIsLightsOFf() throws Exception {

        boolean canHandle = handler.canHandle("LightsOff");

        assertTrue(canHandle);
    }

    @Test
    public void shouldReturnFalseWhenTheIntentNameIsNotLightsOff() throws Exception {

        boolean canHandle = handler.canHandle("LightsOn1");

        assertFalse(canHandle);
    }
}