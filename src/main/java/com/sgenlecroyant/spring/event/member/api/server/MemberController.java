package com.sgenlecroyant.spring.event.member.api.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.spring.event.member.api.request.MemberRequest;
import com.sgenlecroyant.spring.event.member.api.response.MemberResponse;
import com.sgenlecroyant.spring.event.member.entity.Member;
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
	
	@PostMapping(value = "/api/members")
	public ResponseEntity<MemberResponse> saveMember(@RequestBody MemberRequest memberRequest){
		Member savedMember = this.memberService.saveMember(memberRequest);
		return 
				ResponseEntity.status(HttpStatus.CREATED)
							  .body(new MemberResponse(savedMember.getFirstName(), savedMember.getLastName()));
	}
	
	@PutMapping(value = "/api/members/{id}")
	private ResponseEntity<MemberResponse> updateMember(@PathVariable String id, @RequestBody MemberRequest memberRequest){
		MemberResponse memberResponse = this.memberService.updateMember(id, memberRequest);
		return new ResponseEntity<MemberResponse>(memberResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/members")
	private ResponseEntity<List<MemberResponse>> fetchMembers(){
		return new ResponseEntity<List<MemberResponse>>(this.memberService.fetchMembers(), HttpStatus.OK);
	}

}
