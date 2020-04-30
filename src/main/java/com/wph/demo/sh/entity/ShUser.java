package com.wph.demo.sh.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sh_user")
public class ShUser extends BaseEntity{
  @TableId(type = IdType.AUTO)
  private Integer id;
  private String username;
  private String password;
  private String salt;
  private String email;
  private String mobile;
  private Integer valid;
  private Integer deptId;
  private String createdUser;
  private String modifiedUser;

}
