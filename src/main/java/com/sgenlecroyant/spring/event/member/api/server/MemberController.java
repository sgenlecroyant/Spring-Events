package com.sgenlecroyant.spring.event.member.api.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.spring.event.member.api.response.MemberResponse;
import com.sgenlecroyant.spring.event.member.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = "/api/members/{id}")
	public ResponseEntity<MemberResponse> fetchMemberById(@PathVariable String id){
		MemberResponse memberResponse = this.memberService.fetchMemberById(id);
		return new ResponseEntity<MemberResponse>(memberResponse, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/api/members/{id}")
	private ResponseEntity<Void> deleteMemberById(@PathVariable String id){
		this.memberService.deleteMemberById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
