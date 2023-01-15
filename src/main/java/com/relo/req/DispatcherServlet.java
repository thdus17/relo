package com.relo.req;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.relo.handler.Handler;

/**
 * Servlet implementation class DispatcherServlet
 */
// 실제 요청을 받는 객체
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 명령어와 실행할 handler 객체를 쌍으로 저장할 map 생성
	private Map<String, Handler> map = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 서블릿 초기화 메서드
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		// Properties. Map과 비슷하게 키와 값 저장하는 클래스
		// (Properties는 HashTable을 상속받아 구현한 컬렉션의 한 종류, 파일의 입출력 지원해줌)
		Properties prop = new Properties();
		// 보통 자바에서는 properties 파일에 설정정보를 저장합니다. 그 중 특히 java.util.Properties 클래스는 프로그램
		// 설정정보를 개발코드에 불러오거나
		// 새로운 정보를 추가, 수정, 저장 할 수 있게 해줍니다.

		// properties 파일 경로
		String path = "/WEB-INF/command.properties";
		String path2 = getServletContext().getRealPath(path);
		try {
			// 파일 내용을 읽어서 properties에 복구
			prop.load(new FileReader(path2));

			// properties의 키값 묶음에 반복자 붙여서
			Iterator iter = prop.keySet().iterator();

			// 읽을 키가 있을 동안 반복
			while (iter.hasNext()) {
				String url = (String) iter.next(); // 키 하나씩 읽어서
				// 키에 묶인 값을 읽음(클래스명)
				String className = prop.getProperty(url);
				// System.out.println(url+" "+className);
				try {
					// 클래스 정보를 읽어서 반환
					Class<?> handlerClass = Class.forName(className);
					// < ? extends Object > 의 줄임 표현
					// 어떤 자료형의 객체도 매개변수로 받겠다는 의미
					// Unbounded WildCard라고 알려져 있음

					// Class 객체의 newInstance()는 객체 생성
					// Handler 다른 객체가 보낸 메시지 수신, 처리하는 객체
					// Handler handler = (Handler) handlerClass.newInstance();

					Constructor<?> xx = handlerClass.getConstructor(null);
					Handler handler = (Handler) xx.newInstance();

					// 명령어(String)와 핸들러 객체(인스턴스)를 쌍으로 등록
					map.put(url, handler);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String url = request.getParameter("url");

		// 요청 url 정보
		String url = request.getServletPath();
		// System.out.println("url:"+url);

		//URL url1 = new URL(url);
		//URLConnection connection = url1.openConnection();

		//String line;
		//BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		//while ((line = in.readLine()) != null) {
		//	System.out.println(line);
		//}

		// 명령어로 등록된 handler 객체를 꺼냄
		Handler handler = map.get(url);
		// 뷰 페이지 경로
		String view = handler.process(request, response);
		// System.out.println(view);
		if (view == null) {
			// int num = Integer.parseInt(view);
			return;
		}
		if (view.startsWith("redirect:")) {
			String path = view.split(":")[1];
			response.sendRedirect(request.getContextPath() + path);
		} else if (view.startsWith("responsebody/")) {
			response.getWriter().append(view.split("/")[1]);
		} else {
			RequestDispatcher dis = request.getRequestDispatcher(view);
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
