package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form",new MemberFormControllerV2());
        controllerMap.put("/front-controller/v1/members/save", new
                MemberSaveControllerV2());
        controllerMap.put("/front-controller/v1/members", new
                MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV2 controllerV2 = controllerMap.get(requestURI);
        if(controllerV2 == null){
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return;
        }
        controllerV2.process(request,response);
    }
}
