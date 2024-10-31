package com.sparta.memo.entity;

import com.sparta.memo.dto.MemoRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@NoArgsConstructor
@EntityScan
public class Memo {
    private Long id;
    private String username;
    private String contents;

    public Memo(MemoRequestDTO memoRequestDTO) {
        this.username = memoRequestDTO.getUsername();
        this.contents = memoRequestDTO.getContents();
    }

    public void update(MemoRequestDTO memoRequestDTO) {
        this.username = memoRequestDTO.getUsername();
        this.contents = memoRequestDTO.getContents();
    }
}
