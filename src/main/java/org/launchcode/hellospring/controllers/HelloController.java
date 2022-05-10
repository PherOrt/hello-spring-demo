package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody //If all methods are the same I can declare it above controller to apply to all methods.
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    //@ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //lives at /hello/hello because hello was declared above the controller
    //Handles request of the form /hello?name=LaunchCode
    //@GetMapping("hello")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}) //value = "hello" is no longer needed because it was declared above.
    //@ResponseBody
    public String helloWithQueryParam(@RequestParam String name)
    { return "Hello, " + name + "!"; }


    //Handles request of the form /hello/LaunchCode
    @GetMapping("{name}") //Because it was declared above hello/ could be removed from "hello/{name}"
    //@ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}

