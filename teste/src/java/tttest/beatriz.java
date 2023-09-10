package tttest;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "JsonListServlet", urlPatterns = {"/beatriz.json"})
public class JsonListServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String[] materiasCursadas = {
                "Ética e Responsabilidade Profissional",
                "Banco de Dados",
                "Engenharia de Software 3",
                "Programação Orientada a Objetos",
                "Linguagem de Programação 4 - Internet",
                "Sistemas Operacionais 2",
                "Metodologia da Pesquisa Científico Tecnológica"
            };

            JSONObject beatriz = new JSONObject();
            beatriz.put("BeatrizFeitosa", "RA: 1290482212006");

            JSONArray materiasArray = new JSONArray();
            for (String mat : materiasCursadas) {
                materiasArray.put(mat);
            }

            beatriz.put("Materias", materiasArray);

            out.print(beatriz.toString());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "JSON List Servlet";
    }
}
