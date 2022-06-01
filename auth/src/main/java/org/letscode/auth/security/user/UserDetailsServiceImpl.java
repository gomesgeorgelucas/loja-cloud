package org.letscode.auth.security.user;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.letscode.servicopessoa.domain.model.PessoaModel;
import org.letscode.servicopessoa.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Collection;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;


@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {
    private final PessoaRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("Searching in the DB the user by username '{}'", username);

        PessoaModel applicationUser = applicationUserRepository.findPessoaModelByPessoaLogin(username);

        log.info("ApplicationUser found '{}'", applicationUser);

        if (applicationUser == null)
            throw new UsernameNotFoundException(String.format("Application user '%s' not found", username));

        return new CustomUserDetails(applicationUser);
    }

    private static final class CustomUserDetails extends PessoaModel implements UserDetails {
        CustomUserDetails(@NotNull PessoaModel applicationUser) {
            super(applicationUser);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return commaSeparatedStringToAuthorityList("ROLE_" + this.getRole());
        }

        @Override
        public String getPassword() {
            return getPessoaPassword();
        }

        @Override
        public String getUsername() {
            return getPessoaLogin();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
