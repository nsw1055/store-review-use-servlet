package org.gogildong.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileViewController
 */
@WebServlet("/fileView")
public class FileViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fileName = request.getParameter("name");
		
		File file = new File("C:\\upload\\" + fileName);
		
		String mimeType = Files.probeContentType(file.toPath());
		
		response.setContentType(mimeType);
		
		OutputStream os = response.getOutputStream();
		InputStream fin = new FileInputStream(file);
		byte[] buffer = new byte[1024*8];
		
		while(true) {
			int count = fin.read(buffer);
			
			if(count == -1) {
				break;
			}
			
			os.write(buffer,0,count);
			
		}//end while
		fin.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
