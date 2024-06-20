/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.usuario;
import model.dao.usuarioDao;

/**
 *
 * @author Senai
 */
@WebServlet(urlPatterns = {"/cadastrar"})
@MultipartConfig
public class cadastrocontrole extends HttpServlet {
        usuario usuario = new usuario();
    usuarioDao usuarioDao = new usuarioDao();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String nextPage = "/pages/cadastro.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String action = request.getServletPath();
        if (action.equals("/cadastrar")) {
            user(request, response);
        } else {
            processRequest(request, response);
        }
    }
        protected void user(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        usuario.setNome(request.getParameter("nome"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setTelefone(request.getParameter("telefone"));
        if (usuario.getNome().trim().equals("") || usuario.getSenha().trim().equals("") || usuario.getEmail().trim().equals("") || usuario.getCpf().trim().equals("") || usuario.getTelefone().trim().equals("")) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Por favor, preencha todos os campos.');");
            out.println("window.location.href = './cadastrocontrole';");
            out.println("</script>");
        } else {
            usuarioDao.cadastro(usuario);
            response.sendRedirect("./logincontroler");
        }

    }



}
