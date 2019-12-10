package com.yjiawei.repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yjiawei.entity.ClubActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ClubActivityRepository extends JpaRepository<ClubActivity,Integer> {
    interface ActivityDto {
        String getDate();
        String getTitle();
    }

    @Query(nativeQuery = true, value = "SELECT * FROM CLUB_ACTIVITY act WHERE act.status IN :statusList LIMIT 6")
    List<ClubActivity> findAllByStatus(@Param("statusList")List<String> statusList);

    @Query(nativeQuery = true, value = "SELECT * FROM CLUB_ACTIVITY act WHERE act.status IN :statusList ORDER BY RAND() LIMIT 6")
    List<ClubActivity> findRand(@Param("statusList")List<String> statusList);

    @Query(nativeQuery = true, value = "SELECT * FROM CLUB_ACTIVITY act WHERE act.club_Id = :clubId ORDER BY act.updated_time")
    List<ClubActivity> findAllByClassId(@Param("clubId")int id);

    @Query(nativeQuery = true, value = "SELECT DATE_FORMAT(act.start_time,'%Y/%m/%d') AS date, act.theme AS title FROM CLUB_ACTIVITY act WHERE act.club_Id = :clubId ORDER BY act.start_time")
    List<ActivityDto> findRecentByClassId(@Param("clubId")int id);


}
