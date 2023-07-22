package com.backend.domain.member.service;

import com.backend.domain.member.dto.MemberInfoResponseDto;
import com.backend.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberInfoService {

    private final MemberService memberService;

    @Transactional(readOnly = true)
    public MemberInfoResponseDto getMemberInfo(String email) {
        Member member = memberService.findMemberByEmail(email);
        return MemberInfoResponseDto.of(member);
    }

}
