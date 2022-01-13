package put.poznan.AcoPlace.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import put.poznan.AcoPlace.admin.model.AdminUser;
import put.poznan.AcoPlace.admin.repository.AdminUserRepository;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminUserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser user = userRepo.findByEmail(username);
        // TODO tu dać, że jeśli flaga jest jakaś, to rzuca błędem
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

}