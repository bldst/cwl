package com.Mapper;

import com.Student.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    @Select("select * from student")
    List<Student> finAll();


    @Select("select * from student where id=#{id}")

    List<Student> findone(int id);
    @Update("update student set car_id =#{carId},Student_name=#{StudentName},grade=#{grade},student_sex=#{studentSex},major=#{major}  where id=#{id}")
    int update(Student student);


}
