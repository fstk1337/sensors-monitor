package com.fstk1337.boot.sensor.service.user;

import com.fstk1337.boot.sensor.model.user.Role;
import com.fstk1337.boot.sensor.model.user.User;
import com.fstk1337.boot.sensor.repository.user.RoleRepository;
import com.fstk1337.boot.sensor.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Role getRole(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public Role update(Role role) {
        if (roleRepository.existsById(role.getId())) {
            return roleRepository.save(role);
        }
        return null;
    }

    @Override
    public User applyRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);
        user.setRole(role);
        return update(user);
    }

    @Override
    public int deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return 1;
        }
        return -1;
    }

    @Override
    public int deleteRole(Long roleId) {
        if (roleRepository.existsById(roleId)) {
            roleRepository.deleteById(roleId);
            return 1;
        }
        return -1;
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteAllRoles() {
        roleRepository.deleteAll();
    }
}
