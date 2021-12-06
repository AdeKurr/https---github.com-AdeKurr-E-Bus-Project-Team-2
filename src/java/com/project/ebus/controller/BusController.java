package com.project.ebus.controller;

import java.util.List;

import com.project.ebus.model.Booking;
import com.project.ebus.model.Developers;
import com.project.ebus.model.Jurusan;
import com.project.ebus.model.Keberangkatan;
import com.project.ebus.model.Perusahaan;
import com.project.ebus.model.user;
import com.project.ebus.repository.bookingRepository;
import com.project.ebus.repository.developerRepository;
import com.project.ebus.repository.jurusanRepository;
import com.project.ebus.repository.keberangkatanRepository;
import com.project.ebus.repository.perusahaanRepository;
import com.project.ebus.repository.userRepository;
// import com.project.ebus.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusController {

    @Autowired
    developerRepository devRepo;

    @Autowired
    perusahaanRepository perusahaanRepo;

    // @Autowired
    // UserService userService;

    @Autowired
    jurusanRepository jurusanRepo;

    @Autowired
    userRepository userRepo;

    @Autowired
    bookingRepository bookingRepo;

    @Autowired
    keberangkatanRepository keberangkatanRepo;

    // @GetMapping("/")
    // public ModelAndView login() {
    // ModelAndView nav = new ModelAndView("login");
    // nav.addObject("user", new user());
    // return nav;
    // }

    @GetMapping("/")
    public String getFormPenumpang(Model model) {
        model.addAttribute("data", new user());
        return "login";
    }

    @PostMapping("/loginresult")
    public String getLoginInfo(@ModelAttribute("data") user user, Model model) {
        String emailBeneran = user.getEmail();
        String pwBeneran = user.getPassword();
        List<user> dataLogin = userRepo.findByEmailAndPassword(emailBeneran, pwBeneran);
        if (dataLogin.size() == 0) {
            return "errorlogin";
        } else {
            return "redirect:/index";
        }
    }

    // @PostMapping("/login")
    // public String login(@ModelAttribute("user") user user) {
    // user oauthuser = userService.login(user.getEmail(), user.getPassword());
    // System.out.print(oauthuser);
    // if (Objects.nonNull(oauthuser)) {
    // return "redirect:/index";
    // } else {
    // return "errorlogin";
    // }
    // }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("formData", new user());
        return "signup";
    }

    @PostMapping("/registrasi")
    public String registrasi(@ModelAttribute("formData") user formData, Model model) {
        userRepo.save(formData);
        model.addAttribute("formData", formData);
        return "redirect:/";
    }

    // @PostMapping("/saveuser")
    // @ResponseBody
    // public String saveUser(@ModelAttribute("data") user saveDataUser) {
    // userService.save(saveDataUser);
    // return "redirect:/login";
    // }

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

    @GetMapping("/booking")
    public String getBooking(Model model) {
        model.addAttribute("formData", new Booking());
        return "booking";
    }

    @PostMapping("/createbooking")
	public String bookingResult(@ModelAttribute("formData") Booking formData, Model model) {
		String nik = formData.getNik().getNik();
		long idKeberangkatan = formData.getIdKeberangkatan().getId();
		List<user> penumpangSementara = userRepo.findByNik(nik);
		formData.setNik(penumpangSementara.get(0));
		Keberangkatan keberangkatanSementara = keberangkatanRepo.getById(idKeberangkatan);
		formData.setIdKeberangkatan(keberangkatanSementara);
		bookingRepo.save(formData);
        List<Booking> hasilSimpan = bookingRepo.findByNik(formData.getNik());
		model.addAttribute("data", hasilSimpan.get(hasilSimpan.size() - 1));
		return "redirect:/account";
	}

    @GetMapping("/account")
    public String getAccount() {
        return "akun";
    }

    @GetMapping("/detailbooking")
    public String detailBooking(@ModelAttribute("data") Model model) {
        
        return "detailbooking";
    }

    @GetMapping("/cancel")
	public String cancelBooking(Model model) {
		model.addAttribute("formData", new Booking());
		return "formcancel";
	}

	@PostMapping("/cancelbooking")
	public String cancelBooking(@ModelAttribute("formData") Booking dataBooking) {
		bookingRepo.deleteById(dataBooking.getId());
		return "cancelmessage";
	}
    // nanti yg ngerjain controller, kalo ada bentrok diatas replace aja. jangan
    // lupa commit message
}
