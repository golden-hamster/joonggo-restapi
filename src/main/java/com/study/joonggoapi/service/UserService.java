package com.study.joonggoapi.service;

import com.study.joonggoapi.dto.UserJoinDto;
import com.study.joonggoapi.entity.LoginType;
import com.study.joonggoapi.entity.Role;
import com.study.joonggoapi.entity.User;
import com.study.joonggoapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long join(UserJoinDto userJoinDto) {
        User user = User.builder().email(userJoinDto.getEmail())
                .password(passwordEncoder.encode(userJoinDto.getPassword()))
                .nickName(userJoinDto.getNickName())
                .role(Role.ROLE_USER)
                .loginType(LoginType.NORMAL)
                .build();

        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));
    }

}
