package com.sparta.springmemoproject.dto;

import lombok.Getter;

import java.util.Date;
@Getter

public class MemoRequestDto {
    private String memoTitle;
    private String pwd;
    private String contents;
    private Date date;
    private long id;
}
