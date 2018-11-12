package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.services.ShowProfileService;
import com.utils.PasrseJsonUtility;

/**
 * Servlet implementation class UpdateProfileInfos
 */
@WebServlet("/UpdateProfileInfos")
public class UpdateProfileInfos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileInfos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuffer jb = PasrseJsonUtility.getRequestJson(request);
		System.out.println("req:"+jb.toString());
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(jb.toString(), JsonObject.class);	
		String token = ShowProfileService.updateProfileInfos(jsonObject);
		JsonObject json_response = new JsonObject();
		json_response.addProperty("token", token);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(json_response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
