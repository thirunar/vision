package com.smarthome.light;

import com.alexaframework.springalexa.intent.IntentHandler;
import com.alexaframework.springalexa.intent.StaticIntentHandler;
import com.alexaframework.springalexa.speechlet.SpringSpeechlet;
import com.amazon.speech.speechlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisionSpeechlet extends SpringSpeechlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(VisionSpeechlet.class);

    @Autowired
    public VisionSpeechlet(StaticIntentHandler staticIntentHandler,
                           IntentHandler... intentHandlers) {
        super(staticIntentHandler, intentHandlers);
    }

    @Override
    public void onSessionStarted(SessionStartedRequest sessionStartedRequest, Session session) throws SpeechletException {

    }

    @Override
    public SpeechletResponse onLaunch(LaunchRequest launchRequest, Session session) throws SpeechletException {
        return null;
    }

    @Override
    public void onSessionEnded(SessionEndedRequest sessionEndedRequest, Session session) throws SpeechletException {

    }
}
