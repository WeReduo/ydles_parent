package com.ydles.entity;

/**
 * Project Name: ydles_parent
 * File Name: StatusCode
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/05/上午 10:31
 * Copyright (c) 2022,
 */
public class StatusCode {
    public static final int OK=20000;//成功
  public static final int ERROR=20001;//失败
  public static final int LOGINERROR=20002;//用户名或密码错误
  public static final int ACCESSERROR=20003;//权限不足
  public static final int REMOTEERROR=20004;//远程调用失败

    public static final int REPERROR = 20005;//重复操作


    
}

