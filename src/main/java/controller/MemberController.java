package controller;

import repository.MemberRepository;
import exceptions.MemberAlreadyExistsException;
import model.Member;

public class MemberController {

	private MemberRepository memberRepository;

	public MemberController(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public String addMember(Member newMember) {
		try{
			memberRepository.addMember(newMember);
			return null;
		}catch(Exception ex){
			return ex.getMessage();
		}
	}

}