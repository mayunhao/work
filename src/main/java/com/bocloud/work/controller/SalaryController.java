package com.bocloud.work.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bocloud.work.entity.Salary;
import com.bocloud.work.service.ISalaryService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/salary")
public class SalaryController {
 
	@Autowired
	private ISalaryService iSalaryService;

	@ResponseBody
	public Salary test() {
		Salary u = iSalaryService.selectById(1);
		return u;
	}

	/**
	 * 获取所有薪资列表
	 * 
	 * @param request
	 */
	@RequestMapping("/getAllSalary")

	public ModelAndView getAllSalary() {
		ModelAndView view = new ModelAndView();
		List<Salary> list;
		try {
			list = iSalaryService.findAllList();
			view.addObject("clients", list);
			view.setViewName("clientindex.jsp");
		} catch (Exception e) {
			view.addObject("error", e.getMessage());
			view.setViewName("error.jsp");
		}
		return view;
	}

	/**
	 * 跳转到添加薪资界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/AddSalary")
	public String toAddSalary() {
		return "/addSalary";
	}

	/**
	 * 添加用户并重定向
	 * 
	 * @param salary
	 * @param request
	 * @return
	 * @return
	 */

	@RequestMapping("/addSalary")
	public String addSalary(Salary salary, Model model) {
		iSalaryService.save(salary);
		return "allSalary.html";
	}

	/**
	 * 编辑薪资
	 * 
	 * @param salary
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateSalary")
	public String updateSalary(Salary salary, HttpServletRequest request, Model model) {
		if (iSalaryService.update(salary)) {
			salary = iSalaryService.findById(salary.getId());
			model.addAttribute("salary", salary);
			return "redirect:/salary/getAllSalary";
		} else {
			return "/error";
		}
	}

	/**
	 * 根据id查询单个用户薪资
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getSalary")
	public String getSalary(int id, HttpServletRequest request, Model model) {
		request.setAttribute("salary", iSalaryService.findById(id));
		model.addAttribute("salary", iSalaryService.findById(id));
		return "/editSalary";
	}

	/**
	 * 删除用户薪资
	 * 
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delSalary")
	public void delSalary(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (iSalaryService.delete(id)) {
			result = "{\"result\":\"success\"}";
		}
		response.setContentType("application/json");
		try {
			PrintWriter out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
