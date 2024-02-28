package com.yupi.project.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 调用接口请求
 *
 * @TableName product
 */
@Data
public class InterfaceInvokeRequest implements Serializable {
    /**
     * 接口id
     */
    private Long id;

    /**
     * 用户请求参数
     */
    private String userRequestParams;

    private static final long serialVersionUID = 1L;
}