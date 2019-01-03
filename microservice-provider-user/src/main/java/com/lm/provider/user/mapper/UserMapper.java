package com.lm.provider.user.mapper;

import com.lm.provider.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author lming.41032@gmail.com
 * @date 18-12-21 下午5:48
 */
@Mapper
public interface UserMapper {


    @Select("select * from cms_user where id = #{id}")
    User selectById(@Param("id") String id);

}
