package com.sparta.springmemoproject.entity;

import com.sparta.springmemoproject.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Memo {
    private String memoTitle;
    private String pwd;
    private String contents;
    private Date date;
    private long id;

    public Memo(MemoRequestDto memoRequestDto){
        this.memoTitle = memoRequestDto.getMemoTitle();
        this.pwd = memoRequestDto.getPwd();
        this.contents = memoRequestDto.getContents();
        this.date = memoRequestDto.getDate();
    }
}
