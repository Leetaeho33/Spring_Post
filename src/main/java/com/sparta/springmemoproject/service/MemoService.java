package com.sparta.springmemoproject.service;

import com.sparta.springmemoproject.dto.MemoRequestDto;
import com.sparta.springmemoproject.dto.MemoResponseDto;
import com.sparta.springmemoproject.entity.Memo;
import com.sparta.springmemoproject.repository.MemoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoService{

    MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }

    // 메모 작성 로직
    public MemoResponseDto createMemo(MemoRequestDto memoRequestDto){
        // RequestDto -> Entity
        Memo requestMemo = new Memo(memoRequestDto);
        // DB에 저장
        Memo responseMemo = memoRepository.saveMemo(requestMemo);
        // Entity -> ResponsesDto
        return new MemoResponseDto(requestMemo);
    }

    //메모 업데이트 로직
    public MemoResponseDto updateMemo(MemoRequestDto memoRequestDto, long id, String pwd ){
        // 수정할 RequestDto -> Entity
        Memo requestMemo = new Memo(memoRequestDto);

        // DB에서 id로 메모 조회
        Memo findMemo = selectMemo(id);

        // 찾는 id의 메모와 입력된 비밀번호 확인
        if(checkPwd(findMemo, pwd)) {
            // DB에 수정(requestMemo -> 해당하는 id의 메모에 수정)
            // Entity -> ResponseDto
            return new MemoResponseDto(memoRepository.updateMemo(requestMemo, id));

        } else{
            // 비밀번호 오류시
//            System.out.println("비밀번호가 틀렸습니다.");
            return null;
        }
    }

    //전체 메모 조회 로직
    public List<MemoResponseDto> getAllMemo(){
        // ResponseDto를 담을 List 생성
        List<MemoResponseDto> responseDtoList = new ArrayList<>();

        // 레파지토리에 메모 전체 조회 후 Memo List에 담음
        List<Memo> memoList = memoRepository.getAllMmeo();
        MemoResponseDto responseDto;

        // Memo list에서 가져온 Entity를 ResponseDto로 변경 후 List에 담음
        for(int i=0; i<memoList.size(); i++){
            responseDto = new MemoResponseDto(memoList.get(i));
            responseDtoList.add(responseDto);
        }
        // ResponseDto를 담은 List 반환
        return responseDtoList;

    }
    //선택된 메모 조회 로직
    public MemoResponseDto getSelectedMemo(long id){
        // DB에서 id로 메모 조회
        Memo selectedMemo = selectMemo(id);

        // Entity -> ResponseDto
        return new MemoResponseDto(selectedMemo);
    }

    // 메모 삭제
    public void deleteMemo(long id, String pwd){
        // DB에서 id로 메모 조회
        Memo deleteMemo = selectMemo(id);

        // 찾는 id의 메모와 입력된 비밀번호 확인
        if(checkPwd(deleteMemo, pwd)){
            // DB에서 해당 id 메모 삭제
            memoRepository.deleteMemo(id);
        }else {
            // 비밀번호 오류시
//            System.out.println("비밀번호가 틀렸습니다.");
        }
    }


    //메모 선택 메서드
    public Memo selectMemo(long id){
        return memoRepository.findMemoById(id);
    }

    // 메모 비밀번호 체크 메서드
    public boolean checkPwd(Memo memo, String pwd){
        Memo checkedMemo = memoRepository.findMemoById(memo.getId());
        if(memo.getPwd().equals(pwd)){
            return true;
        }else return false;
    }

}
