package com.project.ebus.controller;

import java.util.List;
import java.util.Objects;

import com.project.ebus.model.Developers;
import com.project.ebus.model.Jurusan;
import com.project.ebus.model.Perusahaan;
import com.project.ebus.model.user;
import com.project.ebus.repository.developerRepository;
import com.project.ebus.repository.jurusanRepository;
import com.project.ebus.repository.perusahaanRepository;
import com.project.ebus.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BusController {

    @Autowired
    developerRepository devRepo;

    @Autowired
    perusahaanRepository perusahaanRepo;

    @Autowired
    UserService userService;

    @Autowired
    jurusanRepository jurusanRepo;

    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView nav = new ModelAndView("login");
        nav.addObject("user", new user());
        return nav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") user user) {
        user oauthuser = userService.login(user.getEmail(), user.getPassword());
        System.out.print(oauthuser);
        if (Objects.nonNull(oauthuser)) {
            return "redirect:/index";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/saveuser")
    @ResponseBody
    public String saveUser(@ModelAttribute("data") user saveDataUser) {
        userService.save(saveDataUser);
        return "redirect:/login";
    }

    @GetMapping("/index") // ade
    public String getPageIndex(Model model) {
        List<Developers> dev = devRepo.findAll();
        model.addAttribute("dataDev", dev);
        return "index";
    }

    // @GetMapping("/")
    // public String getPageLogin() {
    // return "login";
    // }

    @GetMapping("/about") // brata // ganti isi controller sekarang berupa ngambil data jurusan
    public String getPageAbout(Model model) {
        List<Jurusan> jurusandata = jurusanRepo.findAll();
        model.addAttribute("dataJurusan", jurusandata);
        return "about";
    }

    @GetMapping("/perusahaan") // ade
    public String getPageperusahaan(Model model) {
        List<Perusahaan> perusahaan = perusahaanRepo.findAll();
        model.addAttribute("dataperusahaan", perusahaan);
        return "perusahaan";
    }

    @GetMapping("/contact")
    public String cobaGetPagenya4() {
        return "contact";
    }

    @GetMapping("/booking")
    public String cobaGetPagenya5() {
        return "booking";
    }

    @GetMapping("/account")
    public String cobaGetPagenya6() {
        return "akun";
    }

    // nanti yg ngerjain controller, kalo ada bentrok diatas replace aja. jangan
    // lupa commit message
}
