package com.smarthome.light.controller;

import com.google.common.collect.ImmutableMap;
import com.google.firebase.database.DatabaseReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController("/vision")
public class VisionController {

    @Autowired
    private DatabaseReference reference;

    @RequestMapping(method = POST, consumes = "application/json")
    public void handle(@RequestBody  Map<String, Boolean> map) {
        if (map.get("ledState"))
            reference.updateChildren(ImmutableMap.of("ledState", true));
        else
            reference.updateChildren(ImmutableMap.of("ledState", false));
    }
}
