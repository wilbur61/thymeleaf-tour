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
        return "userForm"; // Return the name of the Thymeleaf template
    }

    @PostMapping("/userForm")
    public String submitForm(@Valid User user, BindingResult bindingResult) {
        // Handle form submission logic here
        if (bindingResult.hasErrors()) {
            System.out.println("ERRORS!!!!");
            System.out.println(bindingResult.getAllErrors().toString());
            return "userForm"; // Return the form if there are errors
        }
        // Process user data
        System.out.println("Form submitted successfully");
        System.out.println("User ID: " + user.getUserId());
        System.out.println("User Name: " + user.getUserName());
        return "redirect:/success"; // Redirect to a success page
    }
}
