package com.sparta.springmemoproject.controller;

import com.sparta.springmemoproject.dto.MemoRequestDto;
import com.sparta.springmemoproject.dto.MemoResponseDto;
import com.sparta.springmemoproject.entity.Memo;
import com.sparta.springmemoproject.service.MemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class MemoController {
    MemoService memoService;
    @PostMapping("/memo")
    @ResponseBody
    public MemoResponseDto post(@RequestBody MemoRequestDto memoRequestDto){
        //RequestDto를 Entity로 변환
        Memo memo = new Memo(memoRequestDto);

        return null;
    }
    @GetMapping("/total")
    @ResponseBody
    public String getTotal(){
        return null;
    }
    @GetMapping("/selected")
    @ResponseBody
    public String getSelected(){
        return null;
    }
    @PutMapping("/memo")
    @ResponseBody
    public String put(){
        return null;
    }
    @DeleteMapping("/memo")
    @ResponseBody
    public String delete(){
        return null;
    }

}
