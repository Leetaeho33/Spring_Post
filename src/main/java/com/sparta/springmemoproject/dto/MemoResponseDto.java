package com.sparta.springmemoproject.dto;

import com.sparta.springmemoproject.entity.Memo;
import lombok.Getter;

import java.util.Date;

// 메모 응답 Dto
// 클라이언트에게 보여줄 정보들만 담음
@Getter
public class MemoResponseDto{
    private String title;
    private String contents;
    private Date date;
    private String userName;
    private long id;

    public MemoResponseDto(Memo memo) {
        this.title = memo.getTitle();
        this.contents = memo.getContents();
        this.date = memo.getDate();
        this.userName = memo.getUserName();
        this.id = memo.getId();
    }
}
