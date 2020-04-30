package com.wph.demo.sh.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sh_role_menu")
public class ShRoleMenu {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private Integer roleId;
  private Integer menuId;



}
