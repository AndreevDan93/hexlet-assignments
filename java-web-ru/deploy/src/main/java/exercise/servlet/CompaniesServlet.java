package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();
        String searchValue = request.getParameter("search") == null
                ? ""
                :request.getParameter("search");

        List<String> companies = getCompanies().stream()
                .filter(company -> company.contains(searchValue)).toList();
        if (companies.isEmpty()) {
            out.println("Companies not found");
            return;
        }
        companies.forEach(out::println);
        // END
    }
}
