package by.nagula.controller;

import by.nagula.exception.EmptyDateInLogin;
import by.nagula.exception.EmptyUserException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionController {
//
//    @ExceptionHandler(EmptyDateInLogin.class)
//    public String emptyLogin(Model model, EmptyDateInLogin ex){
//        model.addAttribute("message1", ex.getMessage());
//        return "auth";
//    }
//
//    @ExceptionHandler(EmptyUserException.class)
//    public String wrongUser(Model model, EmptyUserException ex){
//        model.addAttribute("message2", ex.getMessage());
//        return "registr";
//    }
//
//    @ExceptionHandler(EmptyDateInLogin.class)
//    public String emptyLogin2(Model model, EmptyDateInLogin ex){
//        model.addAttribute("message", ex.getMessage());
//        return "registr";
//    }
//
//    @ExceptionHandler(SQLException.class)
//    public String sql1(Model model, SQLException ex){
//        model.addAttribute("message", ex.getMessage());
//        return "auth";
//    }
//
//    @ExceptionHandler(SQLException.class)
//    public String sql2(Model model, SQLException ex){
//        model.addAttribute("message", ex.getMessage());
//        return "registr";
//    }
//
//    @ExceptionHandler(SQLException.class)
//    public String sql3(Model model, SQLException ex){
//        model.addAttribute("message", ex.getMessage());
//        return "home";
//    }
//
//    @ExceptionHandler(SQLException.class)
//    public String sql4(Model model, SQLException ex){
//        model.addAttribute("message", ex.getMessage());
//        return "post";
//    }
//
//    @ExceptionHandler(SQLException.class)
//    public String sql5(Model model, SQLException ex){
//        model.addAttribute("message", ex.getMessage());
//        return "add";
//    }
}
