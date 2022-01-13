package put.poznan.AcoPlace.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import put.poznan.AcoPlace.admin.exception.ResourceNotFoundException;
import put.poznan.AcoPlace.admin.model.AdminUser;
import put.poznan.AcoPlace.admin.repository.AdminUserRepository;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminUserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser user = userRepo.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        if(!user.getActive()) {
            throw new ResourceNotFoundException("username with email: "+user.getEmail()+" is not active, please contact our support to active your account");
        }
        return new CustomUserDetails(user);
    }

}