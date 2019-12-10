package com.yjiawei.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class Activity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    String theme;

    String tag;

    int publisherId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    private Timestamp createdTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    private Timestamp updatedTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    private Timestamp startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    private Timestamp endTime;

    String description;

    String status;
}
