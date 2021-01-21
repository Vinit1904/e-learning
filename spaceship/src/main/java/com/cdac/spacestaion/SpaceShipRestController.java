package com.cdac.spacestaion;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/spaceship")
@RequiredArgsConstructor
public class SpaceShipRestController {
	
	@Autowired
    private SpaceShipService spaceShipService;

    @GetMapping("/")
    public List<SpaceShip> ships(@RequestParam String captainname) {
        return spaceShipService.findForCaptain(captainname);
    }
}
