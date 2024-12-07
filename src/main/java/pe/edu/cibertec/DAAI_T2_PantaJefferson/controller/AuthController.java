package pe.edu.cibertec.DAAI_T2_PantaJefferson.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Usuario;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.security.UsuarioSecurity;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.service.UsuarioService;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-success")
    public String loginSuccess(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UsuarioSecurity usuario = (UsuarioSecurity) userDetails;
        session.setAttribute("username", usuario.getUsername());
        return "redirect:/auth/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Usuario usuario) {
        usuarioService.create(usuario);
        return "redirect:/auth/login";
    }

    @GetMapping("/cambiarPassword")
    public String cambiarPassword() {
        return "cambiarPassword";
    }

    @PostMapping("/cambiarPassword")
    public String cambiarPassword(HttpServletRequest request, @RequestParam("password1") String password1, @RequestParam("password2") String password2) {
        if(!password1.equals(password2)) {
            return "redirect:/auth/cambiarPassword?error";
        } else {
            HttpSession session = request.getSession();
            usuarioService.actualizarPassword(password1, session.getAttribute("username").toString());
            return "redirect:/auth/home";
        }
    }
}
