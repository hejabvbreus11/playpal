package com.yjiawei.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "BASE_USER")
public class BaseUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    int NTId;

    @Column
    String nickName;

    @Column
    String hobbies;

    @Column
    Double answerPoints;
}
