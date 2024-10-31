package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDTO;
import com.sparta.memo.dto.MemoResponseDTO;
import com.sparta.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MemoController {

    private final Map<Long, Memo> memoList = new HashMap<>();

    @PostMapping("/memos")
    public MemoResponseDTO createMemo(@RequestBody MemoRequestDTO memoRequestDTO) {
        // RequestDTO -> Entity
        Memo memo = new Memo(memoRequestDTO);

        // Memo Max ID Check
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxId);

        // DB 저장
        memoList.put(memo.getId(), memo);

        // Entity -> ResponseDTO
        return new MemoResponseDTO(memo);
    }

    @GetMapping("/memos")
    public List<MemoResponseDTO> getMemos() {
        // Map To List
        return memoList.values().stream()
                .map(MemoResponseDTO::new).toList();
    }
}
