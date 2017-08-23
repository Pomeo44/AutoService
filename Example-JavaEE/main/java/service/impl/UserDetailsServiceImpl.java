package service.impl;

import javax.ejb.Stateless;

@Stateless
public class UserDetailsServiceImpl { //implements UserDetailsService {

//	@Autowired
//	private UserService userService;
//
//	@Transactional(readOnly = true)
//	public UserDetails loadUserByUsername(String ssoId)
//			throws UsernameNotFoundException {
//		User user = userService.findBySso(ssoId);
//		System.out.println("User : "+user);
//		if(user == null){
//			System.out.println("User not found");
//			throw new UsernameNotFoundException("Username not found");
//		}
//			return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
//				 user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
//	}
//
//
//	private List<GrantedAuthority> getGrantedAuthorities(User user){
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//		for(UserProfile userProfile : user.getUserProfiles()){
//			System.out.println("UserProfile : "+userProfile);
//			authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
//		}
//		System.out.print("authorities :"+authorities);
//		return authorities;
//	}
	
}
