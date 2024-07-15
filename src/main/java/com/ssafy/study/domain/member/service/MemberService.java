package com.ssafy.study.domain.member.service;

import com.ssafy.study.domain.member.service.converter.MemberConverter;
import com.ssafy.study.domain.member.ui.dto.MemberRequest;
import com.ssafy.study.domain.member.entity.Member;
import com.ssafy.study.domain.member.dao.MemberRepository;
import com.ssafy.study.domain.member.ui.dto.MemberResponse;
import com.ssafy.study.global.common.exception.BaseException;
import com.ssafy.study.global.common.response.BaseResponseStatus;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = false)
    public void create(MemberRequest.MemberDto memberDto) {
        Member member = MemberConverter.toMember(memberDto);
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public MemberResponse.MemberDto getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.MEMBER_NOT_FOUND));
        return MemberConverter.toMemberDto(member);
    }
}
