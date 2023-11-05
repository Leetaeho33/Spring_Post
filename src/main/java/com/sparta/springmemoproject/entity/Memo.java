package com.sparta.springmemoproject.entity;

import com.sparta.springmemoproject.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

// 메모 Entity
// 메모가 가져야할 모든 정보를 가져야함
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    private String title;
    private String pwd;
    private String contents;
    private Date date;
    private long id;
    private String userName;

    public Memo(MemoRequestDto memoRequestDto){
        this.title = memoRequestDto.getTitle();
        this.pwd = memoRequestDto.getPwd();
        this.contents = memoRequestDto.getContents();
        this.date = memoRequestDto.getDate();
        this.userName = memoRequestDto.getUserName();
    }
}
