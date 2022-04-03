package practice.springmvc.web.frontcontroller.v4.controller;

import java.util.List;
import java.util.Map;

import practice.springmvc.domain.member.Member;
import practice.springmvc.domain.member.MemberRepository;
import practice.springmvc.web.frontcontroller.v4.ControllerV4;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);
        return "members";
    }
}
