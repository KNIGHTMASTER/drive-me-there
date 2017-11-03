package com.zisal.am.web.rest;

import com.zisal.am.dto.request.DTORequestLogin;
import com.zisal.am.dto.response.BaseResponseDTO;
import com.zisal.am.service.IServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ladies Man on 1/8/2016.
 */
@RestController
@RequestMapping("/service/api/v1")
public class RestLogin extends ARestController{

    @Autowired
    IServiceLogin iServiceLogin;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponseDTO doLogin(@RequestBody DTORequestLogin dtoRequestLogin){
        if(dtoRequestLogin != null){
            int result = iServiceLogin.doLogin(dtoRequestLogin.getUserName(), dtoRequestLogin.getPassword());
            if(result == 1){
                return generateSuccessResponse();
            }else{
                return generateFailedResponse();
            }
        }else{
            return generateFailedResponse();
        }
    }
}
