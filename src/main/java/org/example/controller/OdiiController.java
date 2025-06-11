package org.example.controller;

import org.example.api.OdiiService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class OdiiController {

    private final OdiiService odiiService;

    public OdiiController(OdiiService odiiService) {
        this.odiiService = odiiService;
    }

    @GetMapping("/tourapi/theme")
    public String getThemeBasedList(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int numOfRows,
            @RequestParam(defaultValue = "ko") String langCode
    ) throws Exception {

        return odiiService.getThemeBasedList(pageNo, numOfRows, langCode);
    }
}