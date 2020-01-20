package car.car.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdduserDao {

    @Update("update PERSONAL_CENTER SET USER_NAME=#{username},AGE=#{age},SEX=#{sex},TELEPHONE=#{telephone},DRIVER_LICENSE=#{driver_license},INSURANCE=#{insurance},PREMIUM=#{preminum} where ID = #{id}")
    void adduser(@Param("username")String username,@Param("age")int age,@Param("sex")String sex,@Param("telephone")int telephone,@Param("driver_license")String driver_license,@Param("insurance")String insurance,@Param("preminum")int preminum,@Param("id")int id);
}
