package com.sparta.memo.service;

import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemoServiceTest {

    @Autowired
    MemoRepository memoRepository;

    @Test
//    @Transactional
    void getMemosByKeyword() {
        memoRepository.findAllByContentsContainingOrderByModifiedAtDesc("전파 테스트")
                .stream().map(Memo::getContents).toList()
                .forEach(System.out::println);
    }
}