package com.example.boardservice.domain.board.dto.request;

import com.example.boardservice.domain.board.entity.Board;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class UpdateBoardRequestDto {
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @Column(nullable = false)
    List<MultipartFile> pictures;
    public Board toEntity(UpdateBoardRequestDto updateBoardRequestDto, Long memberId) {
        return Board.builder()
                .content(updateBoardRequestDto.getContent())
                .title(updateBoardRequestDto.getTitle())
                .memberId(memberId)
                .build();
    }
}
