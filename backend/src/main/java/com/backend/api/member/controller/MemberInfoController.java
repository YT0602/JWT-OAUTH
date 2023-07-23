package com.backend.api.member.controller;

import com.backend.api.member.dto.MemberDto;
import com.backend.api.member.dto.MemberInfoResponseDto;
import com.backend.api.member.service.MemberInfoService;
import com.backend.global.jwt.service.TokenManager;
import com.backend.global.resolver.memberInfo.MemberInfo;
import com.backend.global.resolver.memberInfo.MemberInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberInfoController {

    private final TokenManager tokenManager;
    private final MemberInfoService memberInfoService;

    // 회원 정보 조회
    @GetMapping("/info")
    public ResponseEntity<MemberInfoResponseDto> getMemberInfo(@MemberInfo MemberInfoDto memberInfoDto) {

        String email = memberInfoDto.getEmail();
        MemberInfoResponseDto memberInfoResponseDto = memberInfoService.getMemberInfo(email);

        return ResponseEntity.ok(memberInfoResponseDto);
    }

    // 추가정보 업데이트 메서드
    @PatchMapping("/additional")
    public ResponseEntity<MemberDto.Response> updateAdditionalInfo(@RequestBody MemberDto.UpdateRequest request, @MemberInfo MemberInfoDto memberInfoDto) {
        MemberDto.Response response = memberInfoService.updateAdditionalInfo(request, memberInfoDto.getEmail());
        return ResponseEntity.ok(response);
    }
}
