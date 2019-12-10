package com.yjiawei.service;

import com.yjiawei.entity.Club;
import com.yjiawei.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClubServiceImpl implements ClubService{
    @Autowired
    ClubRepository clubRepository;

    @Override
    public List<Club> getClubById(int id){
        List<Club> clubs = clubRepository.findClubsById(id);
        if (CollectionUtils.isEmpty(clubs)) return new ArrayList<Club>();
        return clubs;
    }
}
