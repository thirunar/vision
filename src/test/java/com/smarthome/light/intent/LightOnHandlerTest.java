package com.smarthome.light.intent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class LightOnHandlerTest {

    @InjectMocks
    private LightOnHandler handler;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldReturnTrueWhenTheIntentNameIsLightsOn() throws Exception {

        boolean canHandle = handler.canHandle("LightsOn");

        assertTrue(canHandle);
    }

    @Test
    public void shouldReturnFalseWhenTheIntentNameIsNotLightsOn() throws Exception {

        boolean canHandle = handler.canHandle("LightsOn1");

        assertFalse(canHandle);
    }
}