package com.java.socialEx;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;



/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	
	//private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/* GoogleLogin */
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;

	// 로그인 첫 화면 요청 메소드
	// 아니 어디서 뭐 받을지 정하는거냐ㅠ ㅜ;;
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		/* 구글code 발행 */
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);

		System.out.println("구글:" + url);

		model.addAttribute("url", url);

		/* 생성한 인증 URL을 View로 전달 */
		return "login";
	}

	// 구글 Callback호출 메소드
	@RequestMapping(value = "/oauth2callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String googlecallback(Model model, @RequestParam String code) throws IOException {
		System.out.println("googleCallback");
	/*
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations(); 
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, googleOAuth2Parameters.getRedirectUri(), null); 
		String accessToken = accessGrant.getAccessToken(); 
		Long expireTime = accessGrant.getExpireTime(); 
		if (expireTime != null && expireTime < System.currentTimeMillis()) 
			{ accessToken = accessGrant.getRefreshToken(); 
		logger.info("accessToken is expired. refresh token = {}" , accessToken); } 
		
		Connection<Google>connection = googleConnectionFactory.createConnection(accessGrant); 
		Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi(); 
		PlusOperations plusOperations = google.plusOperations(); 
		Person person = plusOperations.getGoogleProfile();

		System.out.println(person.getAccountEmail());

*/
		
		return "success";
	}
	/*
	@RequestMapping("/oauth2callback")
	public String doSessionAssignActionPage(HttpServletRequest request){
		
		System.out.println("googleSignInCallback");
		String code = request.getParameter("code");
		
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code , googleOAuth2Parameters.getRedirectUri(),
				null);
		
		String accessToken = accessGrant.getAccessToken();
		Long expireTime = accessGrant.getExpireTime();
		if (expireTime != null && expireTime < System.currentTimeMillis()) {
			accessToken = accessGrant.getRefreshToken();
			System.out.printf("accessToken is expired. refresh token = {}", accessToken);
		}
		Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
		Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();
		
		PlusOperations plusOperations = google.plusOperations();
		Person person = plusOperations.getGoogleProfile();
		
		MemberVO member = new MemberVO();
		member.setNickName(person.getDisplayName());
		member.setAuth("USR");

		HttpSession session = request.getSession();
		session.setAttribute("_MEMBER_", member );
		
		System.out.println(person.getDisplayName());
		
		return "success";
		System.out.println(person.getAccountEmail());
		System.out.println(person.getAboutMe());
		System.out.println(person.getDisplayName());
		System.out.println(person.getEtag());
		System.out.println(person.getFamilyName());
		System.out.println(person.getGender());
		
		
	}
*/
	
	@RequestMapping(value = "/oauth", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
	public String kakao(@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse httpServlet) {


		System.out.println("code: "+ code);


		return "success";
	}


}


