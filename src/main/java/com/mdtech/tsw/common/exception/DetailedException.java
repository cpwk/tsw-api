package com.mdtech.tsw.common.exception;


import com.mdtech.tsw.common.entity.ErrorCode;

public class DetailedException extends ServiceException {

    public DetailedException(String msg) {
        super(ErrorCode.DETAILED.getCode(), msg);
    }

}
