package com.zp.mapper;

import com.zp.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * MemberMapper.xml.xml
 *
 * @author zhengpanone
 * @since 2021-09-22
 */
@Mapper
public interface MemberMapper {
    int insert(Member member);
}
