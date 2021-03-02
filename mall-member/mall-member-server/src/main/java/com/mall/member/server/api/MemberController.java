package com.mall.member.server.api;

import com.mall.member.server.service.IUmsMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li
 * description:
 * date: 2021/3/2
 */
@RestController
@RequestMapping("/base")
@RequiredArgsConstructor
public class MemberController {

    private final IUmsMemberService umsMemberService;

    @GetMapping("/test")
    public String test(){
        return umsMemberService.test();
    }

}
