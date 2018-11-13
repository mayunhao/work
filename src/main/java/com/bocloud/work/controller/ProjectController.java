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

import com.bocloud.work.entity.Project;
import com.bocloud.work.service.IProjectService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private IProjectService iProjectService;

	@ResponseBody
	public Project test() {
		Project u = iProjectService.selectById(1);
		return u;
	}

	/**
	 * 获取所有项目列表
	 * 
	 * @param request
	 */
	@RequestMapping("/getAllProject")

	public ModelAndView getAllProject() {
		ModelAndView view = new ModelAndView();
		List<Project> list;
		try {
			list = iProjectService.findAllList();
			view.addObject("clients", list);
			view.setViewName("clientindex.jsp");
		} catch (Exception e) {
			view.addObject("error", e.getMessage());
			view.setViewName("error.jsp");
		}
		return view;
	}

	/**
	 * 跳转到添加项目界面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/AddProject")
	public String toAddProject() {
		return "/addProject";
	}

	/**
	 * 添加项目并重定向
	 * 
	 * @param project
	 * @param request
	 * @return
	 * @return
	 */

	@RequestMapping("/addProject")
	public String addProject(Project project, Model model) {
		iProjectService.save(project);
		return "allProject.html";
	}

	/**
	 * 编辑项目
	 * 
	 * @param project
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateProject")
	public String updateProject(Project project, HttpServletRequest request, Model model) {
		if (iProjectService.update(project)) {
			project = iProjectService.findById(project.getId());
			model.addAttribute("project", project);
			return "redirect:/project/getAllProject";
		} else {
			return "/error";
		}
	}

	/**
	 * 根据id查询单个项目
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/getProject")
	public String getProject(int id, HttpServletRequest request, Model model) {
		request.setAttribute("project", iProjectService.findById(id));
		model.addAttribute("project", iProjectService.findById(id));
		return "/editProject";
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delProject")
	public void delProject(int id, HttpServletRequest request, HttpServletResponse response) {
		String result = "{\"result\":\"error\"}";
		if (iProjectService.delete(id)) {
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