package com.wph.demo.sh.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sh_order")
public class ShOrder extends BaseEntity {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String name;
  private Integer number;
  private double price;


}
