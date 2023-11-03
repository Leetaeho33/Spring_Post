package com.sparta.springmemoproject.service;

import com.sparta.springmemoproject.dto.MemoRequestDto;
import com.sparta.springmemoproject.dto.MemoResponseDto;
import com.sparta.springmemoproject.repository.MemoRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class MemoService{
    MemoRepository memoRepository;

    public MemoResponseDto createMemo(@RequestBody MemoRequestDto memoRequestDto){

        return null;
    }

    public MemoResponseDto updateMemo(@RequestBody MemoRequestDto memoRequestDto){
        return null;
    }

    public MemoResponseDto selectMemo(@RequestBody MemoRequestDto memoRequestDto, long id){
        return null;
    }

    public MemoRequestDto

    public void deleteMemo(@RequestBody MemoRequestDto memoRequestDto, long id){

    }

}
