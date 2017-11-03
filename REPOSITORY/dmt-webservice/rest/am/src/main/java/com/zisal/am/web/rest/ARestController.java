package com.zisal.am.web.rest;

import com.zisal.am.dto.response.BaseResponseDTO;

/**
 * Created by Ladies Man on 1/8/2016.
 */
public abstract class ARestController {

    public BaseResponseDTO generateSuccessResponse(){
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setErrorCode("0");
        baseResponseDTO.setMessage("success");
        baseResponseDTO.setDescription("success accessing API");
        return baseResponseDTO;
    }

    public BaseResponseDTO generateFailedResponse(){
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setErrorCode("-1");
        baseResponseDTO.setMessage("failed");
        baseResponseDTO.setDescription("failed accessing API");
        return baseResponseDTO;
    }
}
