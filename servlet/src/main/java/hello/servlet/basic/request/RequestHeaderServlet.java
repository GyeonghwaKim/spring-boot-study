package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpRequest;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);

        response.getWriter().write("ok");
    }

    private void printEtc(HttpServletRequest request) {
        request.getRemoteHost();
        request.getRemoteAddr();
        request.getRemotePort();
        request.getLocalName();
        request.getLocalAddr();
        request.getLocalPort();
    }

    private void printHeaderUtils(HttpServletRequest request) {
        request.getServerName();
        request.getServerPort();

        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = "+locale));

        request.getCookies();
        request.getContentType();
        request.getContentLength();
        request.getCharacterEncoding();
    }

    private void printHeaders(HttpServletRequest request) {
        request.getHeaderNames().asIterator()
                .forEachRemaining(
                        headerName -> System.out.println(headerName+": "+request.getHeader(headerName))
                );
    }

    private void printStartLine(HttpServletRequest request) {

        request.getMethod();
        request.getProtocol();
        request.getScheme();
        request.getRequestURL();
        request.getRequestURI();
        request.getQueryString();
        request.isSecure();




    }
}
