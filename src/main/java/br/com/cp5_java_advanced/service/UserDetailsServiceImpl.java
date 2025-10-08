package br.com.cp5_java_advanced.service;

import br.com.cp5_java_advanced.model.Usuario;
import br.com.cp5_java_advanced.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        String role = usuario.getPerfil().name();

        return new org.springframework.security.core.userdetails.User(
                usuario.getEmail(),
                usuario.getSenha(),
                Collections.singleton(new SimpleGrantedAuthority(role))
        );
    }
}