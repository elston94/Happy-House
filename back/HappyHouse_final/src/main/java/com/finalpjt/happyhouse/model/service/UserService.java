package com.finalpjt.happyhouse.model.service;

import org.apache.commons.mail.HtmlEmail;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpjt.happyhouse.model.dto.UserDto;
import com.finalpjt.happyhouse.model.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private SqlSession session;
	
	public UserDto login(String id,String pwd) {
		return session.getMapper(UserMapper.class).login(id, pwd);
	}
	
	public boolean join(UserDto dto) {
		if(session.getMapper(UserMapper.class).join(dto)>0)
			return true;
		return false;
	}

	public boolean update(UserDto dto) {
		if(session.getMapper(UserMapper.class).update(dto)>0)
			return true;
		return false;
	}

	public boolean delete(String id) {
		if(session.getMapper(UserMapper.class).delete(id)>0)
			return true;
		return false;
	}

	public UserDto detail(String id) {
		return session.getMapper(UserMapper.class).detail(id);
	}

	public boolean sendEmail(UserDto dto, String div) throws Exception {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; //네이버 이용시 smtp.naver.com
		String hostSMTPid = "vapeloverboy@gmail.com";//서버 이메일 주소(보내는 사람 이메일 주소)
		String hostSMTPpwd = "@roffjrtl2";//서버 이메일 비번(보내는 사람 이메일 비번)

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "vapeloverboy@gmail.com";//보내는 사람 이메일주소(받는 사람 이메일에 표시됨)
		String fromName = "admin";//프로젝트이름 또는 보내는 사람 이름
		String subject = "";
		String msg = "";

		if(div.equals("findpwd")) {
			subject = "해피하우스 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += dto.getId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += dto.getPwd() + "</p></div>";
		}

		// 받는 사람 E-Mail 주소
		String mail = dto.getEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); //네이버 이용시 587

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
			return false;
		}
		
		return true;
	}

	public String findPwd(String id,String email) throws Exception {
//		response.setContentType("text/html;charset=utf-8");
		UserDto dto = session.getMapper(UserMapper.class).getUser(id);
//		PrintWriter out = response.getWriter();
		// 가입된 아이디가 없으면
		if(dto == null) {
			return "가입되지 않은 아이디입니다.";
		}
		// 가입된 이메일이 아니면
		else if(!email.equals(dto.getEmail())) {
			return "등록되지 않은 이메일입니다.";
			}else {
				
			// 임시 비밀번호 생성
			String randomPwd = "";
			
			char pwCollection[] = new char[] {
                    '1','2','3','4','5','6','7','8','9','0',
                    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                    '!','@','#','$','%','^','&','*','(',')'};//배열에 선언


			
			 for (int i = 0; i < 10; i++) {
			        int selectRandomPw = (int)(Math.random()*(pwCollection.length));//Math.rondom()은 0.0이상 1.0미만의 난수를 생성해 준다.
			        randomPwd += pwCollection[selectRandomPw];
			      }

			dto.setPwd(randomPwd);
			// 비밀번호 변경
			if(session.getMapper(UserMapper.class).updatePwd(dto)) {
				// 비밀번호 변경 메일 발송
				if(sendEmail(dto, "findpwd"))
					return "success";
				return "이메일 발송에 실패하였습니다.";
				
			}else {
				return "메일 발송 중 오류가 발생하였습니다.";
			}
		}
	}

//	findpwd(id, email) → 추후 결정.
	
//	@Transactional
//	public int update_pw(UserDto dto) throws Exception{
//		return session.getMapper(UserMapper.class).updatepwd(dto);
//	}
//	
	
}
