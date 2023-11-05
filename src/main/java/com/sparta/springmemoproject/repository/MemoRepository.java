package com.sparta.springmemoproject.repository;

import com.sparta.springmemoproject.entity.Memo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemoRepository {
    JdbcTemplate jdbcTemplate;

    public MemoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // 메모 저장
    public Memo saveMemo(Memo memo){

        // id값을 가져오기 위함(이해가 잘 되지않음..)
        KeyHolder keyHolder = new GeneratedKeyHolder();
        // 메모 제목, 내용, 작성자, 비밀번호, 작성 날짜/사간 저장
        String sql ="INSERT INTO memo (title, contents, username, pwd, date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, memo.getTitle());
            preparedStatement.setString(2, memo.getContents());
            preparedStatement.setString(3, memo.getUserName());
            preparedStatement.setString(4, memo.getPwd());
            // 왜 Datetime을 String으로 반환해야하는지 이해가 안됨.
            preparedStatement.setString(5, String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
            return preparedStatement;
        }, keyHolder);

        long id = keyHolder.getKey().longValue();
        memo.setId(id);

        return memo;
    }

    // 해당id 메모 조회
    public Memo findMemoById(Long id){
        // SQL SELECT문을 통해 id값을 찾는 쿼리 작성
        String sql = "SELECT title, contents, username, date FROM MEMO WHERE id = ? ";

        // 해당 id를 갖는 Memo 객체를 반환
        // queryForObject() 메서드는 한개의 컬럼을 조회할 때 사용
        return jdbcTemplate.queryForObject(sql, new RowMapper<Memo>() {
            @Override
            public Memo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Memo memo = new Memo();
                memo.setTitle(rs.getString("title"));
                memo.setContents(rs.getString("contents"));
                memo.setUserName(rs.getString("username"));
                memo.setDate(rs.getDate("date"));
                return memo;
            }
        }, id);
    }

    //모든 메모 조회
    public List<Memo> getAllMmeo(){
        String sql = "SELECT title, contents, username, date FROM MEMO";
        jdbcTemplate
        return null;
    }

    // 해당 id 메모 수정
    public Memo updateMemo(Memo memo, long id){
        Memo updatedMemo = memo;
        return updatedMemo;
    }

    // 해당 메모 삭제
    public void deleteMemo(long id){

    }

}
