package com.wph.demo.sh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sh_user_role")
public class ShUserRole {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private Integer userId;
  private Integer roleId;



}
