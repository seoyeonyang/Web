package com.example.firstproject.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity //DB가 해당 객체를 인식 할 수 있도록 해주는 어노테이션
public class Article {

    @Id // 대표값을 지정! 주민등록번호같은 개념
    @GeneratedValue // 자동생성 어노테이션
    private Long id;

    @Column //DB가 이해할 수 있도록 하는 어노테이션
    private String title;

    @Column
    private String content;

}