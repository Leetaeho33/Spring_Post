package com.sparta.springmemoproject.controller;

import com.sparta.springmemoproject.dto.MemoRequestDto;
import com.sparta.springmemoproject.dto.MemoResponseDto;
import com.sparta.springmemoproject.entity.Memo;
import com.sparta.springmemoproject.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemoController {
    MemoService memoService;

    // 게시글 작성 요청 및 반환
    @PostMapping("/memo")
    public MemoResponseDto post(@RequestBody MemoRequestDto memoRequestDto){
        // 작성된 메모 ResponseDto 반환
        return memoService.createMemo(memoRequestDto);
    }

    // 게시글 전체 목록 조회 요청 및 반환
    @GetMapping("/memo")
    public List<MemoResponseDto> getAll(){
        // 전체 메모 조회 후 List에 담아 반환
        return memoService.getAllMemo();
    }

    // 게시글 선택 조회 요청 및 반환
    @GetMapping("/memo/{id}")
    public MemoResponseDto getSelected(@PathVariable Long id){
        // 선택된 메모 ResponseDto로 반환
        return memoService.getSelectedMemo(id);
    }

    // 게시글 수정 요청 및 반환
    @PutMapping("/memo/{id}/{pwd}")
    public MemoResponseDto put(@RequestBody MemoRequestDto requestDto, @PathVariable long id, @PathVariable String pwd){
        // 업데이트 된 메모 ResponseDto로 반환
        return memoService.updateMemo(requestDto,id, pwd);
    }


    // 게시글 삭제 요청
    @DeleteMapping("/memo/{id}/{pwd}")
    public String delete(@PathVariable long id,@PathVariable String pwd ){
        // 해당 id 메모 삭제
        memoService.deleteMemo(id, pwd);
        return null;
    }

}
