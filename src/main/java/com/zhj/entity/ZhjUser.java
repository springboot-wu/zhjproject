package com.zhj.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ZhjUser implements Serializable {
     private Integer userID;
     private String loginName;
     private String loginPwd;
     private ZhjDept zhjDept;
     private String userName;
     private String mobile;
     private Integer status;
     private String isDuty;
     private Date onDutyDate;
     private Date offDutyDate;
     private String remark;
     private String logonState;
     private String  roleName;

}
