package com.yjiawei.controller;

import com.yjiawei.entity.Club;
import com.yjiawei.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/club")
public class ClubController {
    @Autowired
    ClubService clubService;

    @RequestMapping(value = "/getClubInfo", method = RequestMethod.POST)
    public List<Club> getClubInfo(@RequestBody Map<String,Object> params){
        int page_id = (int)params.get("id");
        if(page_id>0) page_id = 6*(page_id-1);
        List<Club> activities = clubService.getClubById(page_id);
        return activities;
    }
}
