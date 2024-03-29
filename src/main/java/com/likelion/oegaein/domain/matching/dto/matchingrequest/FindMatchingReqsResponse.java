package com.likelion.oegaein.domain.matching.dto.matchingrequest;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FindMatchingReqsResponse {
    private int count;
    private List<FindMatchingReqData> data;
}
