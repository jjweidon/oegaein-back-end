package com.likelion.oegaein.dto.matching.matchingpost;

import com.likelion.oegaein.dto.global.ResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UpdateMatchingPostResponse implements ResponseDto {
    private final Long matchingPostId;
}
