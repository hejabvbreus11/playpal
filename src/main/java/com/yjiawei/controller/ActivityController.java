package com.yjiawei.controller;

import com.yjiawei.entity.ClubActivity;
import com.yjiawei.repository.ClubActivityRepository;
import com.yjiawei.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/activity")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getActiveClubActivities", method = RequestMethod.POST)
    public List<ClubActivity> getActive(){
        List<ClubActivity> activities = activityService.getAllActiveClubActivities();
        return activities;
    }

    @RequestMapping(value = "/getRandActiveClubActivities", method = RequestMethod.POST)
    public List<ClubActivity> getRandom(){
        List<ClubActivity> activities = activityService.getRandomClubActivities();
        return activities;
    }

    @RequestMapping(value = "/getClubActivitiesByClubId", method = RequestMethod.POST)
    public List<ClubActivity> getClubActivitiesByClubId(@RequestBody Map<String,Object> params){
        int clubId = (Integer)params.get("clubId");
        List<ClubActivity> activities = activityService.getAllActivitiesByClubId(clubId);
        return activities;
    }

    @RequestMapping(value = "/getRecentClubActivitiesByClubId", method = RequestMethod.POST)
    public List<ClubActivityRepository.ActivityDto> getRecentClubActivitiesByClubId(@RequestBody Map<String,Object> params){
        int clubId = (Integer)params.get("clubId");
        List<ClubActivityRepository.ActivityDto> events = activityService.getRecentActivitiesByClubId(clubId);
        return events;
    }

    @RequestMapping(value = "/publishClubActivity", method = RequestMethod.POST)
    public void getClubInfo(@RequestBody Map<String,Object> params){
        Object form = params.get("form");
        try{
            String act_name = ((Map)form).get("activityName").toString();
            String act_disc = ((Map)form).get("disc").toString();
            String club_name = ((Map)form).get("club").toString();
            int club_id = getClubIdFromName(club_name);
            String start_time = ((Map)form).get("start_time").toString();
            String end_time = ((Map)form).get("end_time").toString();
            SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'+08:00'");
            Timestamp start_ts = new Timestamp(inFormat.parse(start_time).getTime());
            Timestamp end_ts = new Timestamp(inFormat.parse(end_time).getTime());
            String tags = ((Map)form).get("tags").toString();
            ClubActivity activity = new ClubActivity();
            activity.setClubId(club_id);
            activity.setCreatedTime(start_ts);
            activity.setCreatedTime(end_ts);
            activity.setPublisherId(1);
            activity.setUpdatedTime(new Timestamp((new Date()).getTime()));
            activity.setStartTime(start_ts);
            activity.setEndTime(end_ts);
            activity.setStatus("Active");
            activity.setDescription(act_disc);
            activity.setTheme(act_name);
            activity.setTag(tags);
            activity.setTopicCount(0);
            activity.setPostCount(0);
            activityService.addOneClubActivitie(activity);
            logger.info(String.format("act_list:%s %s %s %s %s %s", act_name, act_disc, club_name, start_ts.toString(), end_ts.toString(), tags));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getClubIdFromName(String clubName){
        switch (clubName){
            case "轻羽飞扬俱乐部": return 1;
            case "吉他社": return 2;
            case "猫狗宠物团": return 3;
            default: return 1;
        }
    }
}
