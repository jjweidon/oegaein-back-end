package com.likelion.oegaein.domain.matching.entity;

import com.likelion.oegaein.domain.member.entity.Member;
import com.likelion.oegaein.domain.matching.exception.MatchingRequestException;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class MatchingRequest {
    @Id @GeneratedValue
    @Column(name = "matching_req_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matching_post_id")
    private MatchingPost matchingPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id")
    private Member participant;

    @Enumerated(EnumType.STRING)
    private MatchingAcceptance matchingAcceptance; // 매칭 수락 여부 : 수락/거부

    protected MatchingRequest(){}
    public MatchingRequest(MatchingPost matchingPost, Member participant){
        this.matchingPost = matchingPost;
        this.participant = participant;
    }

    public void acceptMatchingRequest(){
        if(this.matchingAcceptance.equals(MatchingAcceptance.ACCEPT)){
            throw new MatchingRequestException("이미 수락된 매칭 요청입니다.");
        }
        this.matchingAcceptance = MatchingAcceptance.ACCEPT;
    }

    public void rejectMatchingRequest(){
        if(this.matchingAcceptance.equals(MatchingAcceptance.REJECT)){
            throw new MatchingRequestException("이미 거부된 매칭 요청입니다.");
        }
        this.matchingAcceptance = MatchingAcceptance.REJECT;
    }
}
