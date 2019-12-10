package com.yjiawei.service;

import com.yjiawei.entity.Activity;
import com.yjiawei.entity.ClubActivity;
import com.yjiawei.repository.ClubActivityRepository;

import java.util.List;

public interface ActivityService {
    public List<ClubActivity> getAllActiveClubActivities();

    public List<ClubActivity> getRandomClubActivities();

    public List<ClubActivity> getAllActivitiesByClubId(int id);

    public List<ClubActivityRepository.ActivityDto> getRecentActivitiesByClubId(int id);

    public Activity addOneClubActivitie(ClubActivity clubActivity);

}
