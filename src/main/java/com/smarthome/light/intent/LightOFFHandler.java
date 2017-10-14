package com.smarthome.light.intent;


import com.alexaframework.springalexa.intent.IntentHandler;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.google.common.collect.ImmutableMap;
import com.google.firebase.database.DatabaseReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LightOFFHandler implements IntentHandler {

    private static final String INTENT_NAME = "LightsOff";

    private static final Logger LOGGER = LoggerFactory.getLogger(LightOFFHandler.class);

    @Autowired
    private DatabaseReference reference;

    @Override
    public boolean canHandle(String intentName) {
        return INTENT_NAME.equals(intentName);
    }

    @Override
    public SpeechletResponse handle(Session session, Intent intent) {
        reference.updateChildren(ImmutableMap.of("ledState", false), (error, ref) -> LOGGER.info("Light is off"));

        return getTellSpeechletResponse("Light is off");
    }
}
