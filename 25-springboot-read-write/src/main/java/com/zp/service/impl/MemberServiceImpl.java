package com.zp.service.impl;

import com.zp.entity.Member;
import com.zp.mapper.MemberMapper;
import com.zp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * MemberServiceImpl
 *
 * @author zhengpanone
 * @since 2021-09-22
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Transactional
    @Override
    public int insert(Member member) {
        return memberMapper.insert(member);
    }
}
