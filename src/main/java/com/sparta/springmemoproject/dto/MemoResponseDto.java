package com.sparta.springmemoproject.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class MemoResponseDto{
    private String title;
    private String contents;
    private Date date;
    private String userName;
    private long id;
}
