package com.wph.demo.sh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sh_menu")
public class ShMenu extends BaseEntity{

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String name;
  private String url;
  private Integer type;
  private Integer sort;
  private String note;
  private Integer parentId;
  private String permission;
  private String createdUser;
  private String modifiedUser;


}
