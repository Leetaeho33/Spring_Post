package com.sparta.springmemoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
@Getter
@AllArgsConstructor

// 메모 요청 Dto
// 메모에 들어가야 할 정보들을 모두 가져야함
public class MemoRequestDto {
    private String title;
    private String pwd;
    private String contents;
    private Date date;
    private long id;
    private String userName;
}
