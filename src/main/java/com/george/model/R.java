package com.george.model;

import com.george.constant.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author: George Chan
 * @date: 2019/06/04
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 接口返回结果
     */
    @Getter
    @Setter
    private boolean flag = CommonConstants.TRUE;
    /**
     * 接口返回编码
     * 0-成功标记
     * 1-失败标记
     */
    @Getter
    @Setter
    private int code = CommonConstants.SUCCESS;
    /**
     * 接口返回信息
     */
    @Getter
    @Setter
    private String msg = "success";
    /**
     * 接口返回数据
     */
    @Getter
    @Setter
    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public R(boolean flag, int code, T data, String msg) {
        super();
        this.flag = flag;
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public R(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = CommonConstants.FAIL;
    }

    public R(boolean flag, Integer code, String msg, Object data) {
        super();
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = (T) data;
    }

    public R(boolean flag, Integer code, String msg) {
        super();
        this.flag = flag;
        this.code = code;
        this.msg = msg;
    }
}
