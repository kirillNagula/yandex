package by.nagula.controller;

import by.nagula.dto.UserDto;
import by.nagula.entity.User;
import by.nagula.exception.WrongPasswordException;
import by.nagula.service.UserService;
import by.nagula.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/account")
public class RegistrationAuthorizationController {

    private final UserServiceImpl userService;

    public RegistrationAuthorizationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/auth")
    public ModelAndView authorization(ModelAndView modelAndView){
        modelAndView.addObject("authorization", new UserDto());

        modelAndView.setViewName("auth");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView addAuthorization(@Valid @ModelAttribute("authorization") UserDto userDto, ModelAndView modelAndView, BindingResult bindingResult, HttpSession httpSession){
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("auth");
        } else {
            System.out.println(userDto);
            User user1 = userService.showUser(userDto.getLogin());

            if (userDto.getPassword().equals(user1.getPassword())){

                httpSession.setAttribute("user", user1);
                modelAndView.setViewName("redirect:/home");
            } else{
                throw new WrongPasswordException("Wrong password");
            }
        }
        return modelAndView;
    }

    @GetMapping(path = "/registr")
    public ModelAndView registration(ModelAndView modelAndView){
        modelAndView.addObject("registration", new User());
        modelAndView.setViewName("registr");
        return modelAndView;
    }

    @PostMapping(path = "/registr")
    public ModelAndView addRegistration(@Valid @ModelAttribute("registration") User user, BindingResult bindingResult, ModelAndView modelAndView){
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("registr");
        } else {
            System.out.println(user);
            userService.createUser(user);
            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }

    @GetMapping(path = "/logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session){
        session.invalidate();
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }
}
