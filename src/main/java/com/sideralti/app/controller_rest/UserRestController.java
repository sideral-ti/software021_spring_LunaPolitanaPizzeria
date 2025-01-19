package com.sideralti.app.controller_rest;

import com.sideralti.app.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/users")
@RequiredArgsConstructor
public class UserRestController {

    private IUserService iUserService;





}
