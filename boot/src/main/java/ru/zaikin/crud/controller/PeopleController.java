package ru.zaikin.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zaikin.crud.model.Person;
import ru.zaikin.crud.service.PeopleService;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("allpeople", peopleService.getAll());
        return "peoplecontroller/people";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "peoplecontroller/new";
    }
    @Transactional
    @PostMapping
    public String create(@ModelAttribute("person") Person person) {
        peopleService.save(person);
        return "redirect:/people";
    }
    @Transactional
    @GetMapping("/person")
    public String getPersonById(@RequestParam("id") int id, Model model) {
        model.addAttribute("newperson", peopleService.getById(id));
        return "peoplecontroller/edit";
    }

    @Transactional
    @PostMapping("/edit")
    public String update(@ModelAttribute("newperson") Person person) {
        peopleService.update(person);
        return "redirect:/people";
    }

    @Transactional
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }

}