
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
    private Note note;
    private boolean firstRun = true;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title;
        String contents;
        
        if(firstRun){
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            BufferedReader br = new BufferedReader(new FileReader
            (new File(path)));

            title = br.readLine();
            contents = br.readLine();

            note = new Note(title, contents);
        }
        request.setAttribute("note", note);
        
        String link = request.getParameter("edit");
        
        try{
           if(link.equals("edit")){
                request.setAttribute("t", note.getTitle());
                request.setAttribute("c", note.getContents());
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
                firstRun = false;
            }
        }catch(Exception e){
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
                firstRun = false;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        
        note = new Note(title, contents);
        request.setAttribute("note", note);
        
        
        /*String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter
        (path, false)));
        pw.println(note.title);
        pw.println(note.contents);*/
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }

}
