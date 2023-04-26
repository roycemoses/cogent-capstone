/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doConnect.cogentcapstone.controller;

import doConnect.cogentcapstone.entity.Question;
import doConnect.cogentcapstone.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author willbarnes
 */
@Controller
@ResponseBody
@CrossOrigin("*")
//@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/q")
public class QuestionController {
    @Autowired
    QuestionService qtr;
    
    @GetMapping(value={"/all"})
    public List<Question> getAll() {
        List<Question> q = qtr.getAll();
        System.out.println("qs: " + q.size());
        return q;
    }
}
