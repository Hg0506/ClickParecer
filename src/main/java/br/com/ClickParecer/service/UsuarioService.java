package br.com.ClickParecer.service;

import org.springframework.stereotype.Service;

import br.com.ClickParecer.model.Usuario;
import br.com.ClickParecer.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario obterUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void excluirUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    usuario.setSenha(usuarioAtualizado.getSenha());
                    return usuarioRepository.save(usuario);
                })
                .orElse(null);
    }

    public Usuario obterUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public boolean validarLogin(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
