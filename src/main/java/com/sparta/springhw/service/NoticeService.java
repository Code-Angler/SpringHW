package com.sparta.springhw.service;

import com.sparta.springhw.Dto.PartOfNoticeRequestDto;
import com.sparta.springhw.domain.Notice;
import com.sparta.springhw.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public Long update(Long id, PartOfNoticeRequestDto requestDto) {
        Notice notice = noticeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        notice.update(requestDto);
        return notice.getId();
    }
}