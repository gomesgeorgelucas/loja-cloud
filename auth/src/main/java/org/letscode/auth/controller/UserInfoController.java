package org.letscode.auth.controller;

import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/user")
public class UserInfoController {

    @GetMapping(path = "/info")
    public ResponseEntity<PessoaModel> getUserInfo(Principal principal) {
        PessoaModel applicationUser = (PessoaModel) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return new ResponseEntity<>(applicationUser, HttpStatus.OK);
    }
}