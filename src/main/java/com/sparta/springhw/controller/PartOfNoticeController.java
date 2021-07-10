package com.sparta.springhw.controller;



import com.sparta.springhw.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PartOfNoticeController {

    private final NoticeRepository noticeRepository;


    @GetMapping("/notices/{id}")
    public String getNotice(@PathVariable Long id, Model model){
        model.addAttribute("id",id);
        return "post.html";
    }

}
