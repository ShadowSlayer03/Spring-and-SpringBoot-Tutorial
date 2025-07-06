package com.sslayer.SpringBootMVC;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController{

    @ModelAttribute("course")
    public String courseName(){
        return "Python";
    }


    @RequestMapping("/")
    public String home(){
        System.out.println("Home Method Called!");
        return "index";
    }

    @RequestMapping("/calculate")
    public String calculate(){
        System.out.println("Calculate Method Called!");
        return "form";
    }

    @RequestMapping("/add")
//    public String add(HttpServletRequest req, HttpSession session){
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        int num3 = Integer.parseInt(req.getParameter("num3"));

//    public String add(@RequestParam("num1") int num, int num2, int num3, HttpSession session){
//        int result = num+num2+num3;

//    public String add(@RequestParam("num1") int num, int num2, int num3, Model model){

    public ModelAndView add(@RequestParam("num1") int num, int num2, int num3, ModelAndView mv){
        int result = num+num2+num3;
        System.out.println("The result is "+result);

        mv.addObject("result",result);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("/alien")
    public String getAlienDetails(){
        System.out.println("Get Alien Details Called!");
        return "alien";
    }

    // Here the problem is that if there are many object attributes/variables we will have to mention all of them here one by one.
    // To solve this we can use ModelAttribute
    @RequestMapping("/addAlien")
//    public ModelAndView addAlien(int aid, String aname, ModelAndView mv){
//        Alien alien = new Alien();
//
//        alien.setAid(aid);
//        alien.setAname(aname);
//
//        mv.addObject("alien",alien);
//        mv.setViewName("result");
//
//        return mv;
//    }

    // We can also skip the ModelAttribute annotation if the name of variable which we are passing to the jsp/html is the same.
    public String addAlien(@ModelAttribute Alien alien){
        return "result";
    }
}