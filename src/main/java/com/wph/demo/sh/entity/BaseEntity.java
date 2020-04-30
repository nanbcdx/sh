package com.wph.demo.sh.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/25 12:01
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2646840234997388805L;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

}
