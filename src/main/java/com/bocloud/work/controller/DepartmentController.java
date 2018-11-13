package com.bocloud.work.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bocloud.work.entity.Department;
import com.bocloud.work.entity.User;
import com.bocloud.work.service.IDepartmentService;
import com.bocloud.work.service.IUserService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private IDepartmentService iDepartmentService;

	@ResponseBody
	public Department test() {
		Department u = iDepartmentService.selectById(1);
		return u;
	}

	/**
	 * 获取所有部门列表
	 * 
	 * @param request
	 */
	@RequestMapping("/getAllDepartment")

	public ModelAndView getAllDepartment() {
		ModelAndView view = new ModelAndView();
		List<Department> list;
		try {
			list = iDepartmentService.findAllList();
			view.addObject("clients", list);
			view.setViewName("clientindex.jsp");
		} catch (Exception e) {
			view.addObject("error", e.getMessage());
			view.setViewName("error.jsp");
		}
		return view;
	}

	/**
	 * 跳转到添加部门界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/AddDepartment")
	public String toAddDepartment() {
		return "/addDepartment";
	}

	/**
	 * 添加部门并重定向
	 * 
	 * @param department
	 * @param request
	 * @return
	 * @return
	 */

	@RequestMapping("/addDepartment")
	public String addDepartment(Department department, Model model) {
		iDepartmentService.save(department);
		return "allDepartment.html";
	}

	/**
	 * 编辑部门
	 * 
	 * @param department
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateDepartment")
	public String updateDepartment(Department department, HttpServletRequest request, Model model) {
		if (iDepartmentService.update(department)) {
			department = iDepartmentService.findById(department.getId());
			model.addAttribute("department", department);
			return "redirect:/department/getAllDepartment";
		} else {
			return "/error";
		}
	}

	/**
	 * 根据id查询单个部门
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getDepartment")
	public String getDepartment(int id, HttpServletRequest request, Model model) {
		request.setAttribute("department", iDepartmentService.findById(id));
		model.addAttribute("department", iDepartmentService.findById(id));
		return "/editDepartment";
	}

	/**
	 * 删除部门
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delDepartment")
	public void delDepartment(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (iDepartmentService.delete(id)) {
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
