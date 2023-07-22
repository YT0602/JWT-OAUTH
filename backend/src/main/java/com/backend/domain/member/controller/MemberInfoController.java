package com.backend.domain.member.controller;

import com.backend.domain.member.dto.MemberInfoResponseDto;
import com.backend.domain.member.service.MemberInfoService;
import com.backend.global.jwt.service.TokenManager;
import com.backend.global.resolver.memberInfo.MemberInfo;
import com.backend.global.resolver.memberInfo.MemberInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberInfoController {

    private final TokenManager tokenManager;
    private final MemberInfoService memberInfoService;

    @GetMapping("/info")
    public ResponseEntity<MemberInfoResponseDto> getMemberInfo(@MemberInfo MemberInfoDto memberInfoDto) {

        String email = memberInfoDto.getEmail();
        MemberInfoResponseDto memberInfoResponseDto = memberInfoService.getMemberInfo(email);

        return ResponseEntity.ok(memberInfoResponseDto);
    }
}
