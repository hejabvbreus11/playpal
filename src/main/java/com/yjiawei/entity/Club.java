package com.yjiawei.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "CLUB")
public class Club implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @Column
    int owner_id;

    @Column
    String club_name;

    @Column
    String description;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    private Timestamp createdTime;
}
