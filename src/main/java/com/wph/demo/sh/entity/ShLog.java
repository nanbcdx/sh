package com.wph.demo.sh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sh_log")
public class ShLog extends BaseEntity {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String optUsername;
  private String operation;
  private String method;
  private String params;
  private Integer optTime;
  private String ip;









































































}
