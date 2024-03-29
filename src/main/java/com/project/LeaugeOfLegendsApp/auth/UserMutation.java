package com.project.LeaugeOfLegendsApp.auth;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver {

	private final UserService userService;
	private final AuthService authService;
	
	public User createUser(User user) {
		return userService.createUser(user);
	}
	
	public String registerUser(SignupRequest signupRequest){
		return  authService.registerUser(signupRequest).getBody().toString();
	}
	
	@PreAuthorize("isAnonymous()")
	public JwtResponse authenticateUser(LoginRequest loginRequest) throws Exception{
		return (JwtResponse) authService.authenticateUser(loginRequest).getBody();
	
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_SUPERADMIN"})
	public User addRoleToUser(String username,Role role) {
		return userService.addRoleToUser(username,role);
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_SUPERADMIN"})
	public User deleteUserRole(String username,Role role) {
		return userService.deleteUserRole(username,role);
	}

	
	
}
