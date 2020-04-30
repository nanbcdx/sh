package com.wph.demo.sh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sh_role")
public class ShRole extends BaseEntity {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String name;
  private String note;
  private String createdUser;
  private String modifiedUser;



}
