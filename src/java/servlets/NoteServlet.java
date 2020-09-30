
package servlets;

import domain.Note;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 730676
 */
public class NoteServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title;
        String contents;
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader
        (new File(path)));
        
        title = br.readLine();
        contents = br.readLine();
            
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String contents = request.getParameter("content");
        
        Note note = new Note(title, contents);
        request.setAttribute("note", note);
        
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter
        (path, false)));
        pw.write(note.getTitle());
        pw.write(note.getContents());
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
