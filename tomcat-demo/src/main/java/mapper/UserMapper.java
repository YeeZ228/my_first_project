package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

public interface UserMapper {
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User login(@Param("username") String username, @Param("password")String password);

    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(String username);

    @Select("insert into tb_user values(null, #{username}, #{password}, null)")
    void insert(User user);

}
