package com.yjiawei.repository;

import com.yjiawei.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository  extends JpaRepository<Club,Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM CLUB club ORDER BY club.id LIMIT :id, 6")
    List<Club> findClubsById(@Param("id") int id);
}
