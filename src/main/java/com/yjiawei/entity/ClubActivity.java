package com.yjiawei.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CLUB_ACTIVITY")
public class ClubActivity extends Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column
    int clubId;

    @Column
    int topicCount;

    @Column
    int postCount;
}
