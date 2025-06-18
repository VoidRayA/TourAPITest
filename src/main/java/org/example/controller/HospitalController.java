package org.example.controller;

import org.example.api.HospitalDetailService;
import org.example.dto.HospitalDetailItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {
    private final HospitalDetailService hospitalDetailService;

    public HospitalController(HospitalDetailService hospitalDetailService) {
        this.hospitalDetailService = hospitalDetailService;
    }

    @GetMapping("/{ykiho}")
    public HospitalDetailItem getHospital(@PathVariable String ykiho) {
        return hospitalDetailService.getHospitalDetail(ykiho);
    }
}
