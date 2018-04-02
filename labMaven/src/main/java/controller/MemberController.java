package controller;

import repository.MemberRepository;
import exceptions.MemberAlreadyExistsException;
import model.Member;

public class MemberController {

	private MemberRepository memberRepository;

	public MemberController(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void addMember(Member newMember) throws MemberAlreadyExistsException {
		memberRepository.addMember(newMember);
	}

}