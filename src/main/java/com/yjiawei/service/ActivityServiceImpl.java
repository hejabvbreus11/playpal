package com.yjiawei.service;

import com.yjiawei.entity.Activity;
import com.yjiawei.entity.ClubActivity;
import com.yjiawei.repository.ClubActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class ActivityServiceImpl implements ActivityService{
    @Autowired
    private ClubActivityRepository clubActivityRepository;


    @Override
    public List<ClubActivity> getAllActiveClubActivities() {
        List<ClubActivity> activities = clubActivityRepository.findAllByStatus(new ArrayList<>(Arrays.asList("Recruit","Active")));
        if (CollectionUtils.isEmpty(activities)) return new ArrayList<ClubActivity>();
        return activities;
    }

    @Override
    public List<ClubActivity> getRandomClubActivities(){
        List<ClubActivity> activities = clubActivityRepository.findRand(new ArrayList<>(Arrays.asList("Recruit","Active")));
        if (CollectionUtils.isEmpty(activities)) return new ArrayList<ClubActivity>();
        return activities;
    }

    @Override
    public List<ClubActivity> getAllActivitiesByClubId(int id){
        List<ClubActivity> activities = clubActivityRepository.findAllByClassId(id);
        if (CollectionUtils.isEmpty(activities)) return new ArrayList<ClubActivity>();
        return activities;
    }

    @Override
    public List<ClubActivityRepository.ActivityDto> getRecentActivitiesByClubId(int id){
        List<ClubActivityRepository.ActivityDto> events = clubActivityRepository.findRecentByClassId(id);
        if (CollectionUtils.isEmpty(events)) return new ArrayList<>();
        return events;
    }

    @Override
    public Activity addOneClubActivitie(ClubActivity activity){
        return clubActivityRepository.save(activity);
    }
}
