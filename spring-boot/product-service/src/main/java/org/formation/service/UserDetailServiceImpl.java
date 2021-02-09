package org.formation.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.formation.records.UserDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    public final static String COMMA_DELIMITER = ";";

    private final Map<String, UserDto> allUsers = new HashMap<>();

    @PostConstruct
    public void loadCsv() throws Exception {
        Resource userResource = new ClassPathResource("users.csv", this.getClass().getClassLoader());

        try (BufferedReader br = new BufferedReader(new InputStreamReader(userResource.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                UserDto uDto = new UserDto(values[0], values[1]);
                allUsers.put(values[0], uDto);
            }
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (allUsers.containsKey(username)) {
            throw new UsernameNotFoundException("Not found");
        }

        Set<GrantedAuthority> grantedAuthories = new HashSet<>();
        grantedAuthories.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(username, "{noop}" + allUsers.get(username).password(), grantedAuthories);
    }

}
