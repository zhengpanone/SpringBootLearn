package com.zp;

import com.zp.entity.Member;
import com.zp.service.MemberService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * DatasourceDemoApplicationTests
 *
 * @author zhengpanone
 * @since 2021-09-22
 */
@SpringBootTest
public class DatasourceDemoApplicationTests {
    @Autowired
    private MemberService memberService;

    @Test
    public void write() {
        Member member = new Member();
        member.setName("write");
        //memberService.insert(member);
    }
}
