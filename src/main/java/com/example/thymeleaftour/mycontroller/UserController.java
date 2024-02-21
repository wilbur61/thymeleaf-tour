package com.example.thymeleaftour.mycontroller;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/success")
    public String successPage() {
        return "success"; // Assuming a Thymeleaf template
    }

    @GetMapping("/userForm")
    public String showForm(Model model) {
        User user = new User(); // Create an empty User object
        model.addAttribute("user", user);
        System.out.println("In showForm  This is get mapping userForm");
        //return "userForm"; // Return the name of the Thymeleaf template
        return "userFormValidation"; // Return the name of the Thymeleaf template
    }

    @PostMapping("/userForm")
    public String submitForm(@Valid User user, BindingResult bindingResult, Model model) {
        // Handle form submission logic here
        System.out.println("GET userId FIELD VAL="+bindingResult.getFieldValue("userId"));
        System.out.println("GET userName FIELD VAL="+bindingResult.getFieldValue("userName"));
        if (bindingResult.hasErrors()) {
            System.out.println("SUBMIT ERRORS!!!!");
            System.out.println(bindingResult.getAllErrors().toString());
            return "userFormValidation"; // Return the form if there are errors
        }

        // Process user data
        System.out.println("Form submitted successfully");
        System.out.println("User ID: " + user.getUserId());
        System.out.println("User Name: " + user.getUserName());
        return "redirect:/success"; // Redirect to a success page
    }
}
