package com.atomi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atomi.entity.Employee;
import com.atomi.repository.Employeerepo;

@Controller
public class Control {
	@Autowired
	Employeerepo emp;

	@GetMapping("/")
	public String main() {
		return "Main.html";
	}

	@GetMapping("/form")
	public String form() {
		return "Add.html";
	}

	@GetMapping("/view")
	public String view(ModelMap m) {
		List<Employee> l = emp.findAll();
		if (l.isEmpty()) {
			m.put("m", "No data found");
			return "/Main.html";
		}
		m.put("ans", l);
		return "View.html";
	}

	@PostMapping("/add")
	public String add(Employee e, RedirectAttributes r) {
		emp.save(e);
		r.addFlashAttribute("Saved", "Emlployee Details Added");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String del(@PathVariable Integer id, RedirectAttributes r) {
		emp.deleteById(id);
		r.addFlashAttribute("msg", "Data deleted");
		return "redirect:/view";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, ModelMap m) {
		Employee e = emp.findById(id).orElse(null);
		m.put("hi", e);
		return "Edit";
	}

	@PostMapping("/update")
	public String update(Employee e, RedirectAttributes r) {
		emp.save(e);
		r.addFlashAttribute("m", "Updated Successfully");
		return "redirect:/view";

	}

}
