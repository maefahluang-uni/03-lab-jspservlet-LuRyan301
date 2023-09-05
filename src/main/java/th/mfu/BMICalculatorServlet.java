package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));
        //TODO: calculate bmi
        int BMI = (int) Math.round(calculateBMI(weight, height));
        //TODO: determine the built from BMI
        String built = determineBuilt(BMI);
        //TODO: add bmi and buit to the request's attribute
        request.setAttribute("BMI", BMI);
        request.setAttribute("built", built);
        //TODO: forward to jsp
        request.getRequestDispatcher("/bmi_result.jsp").forward(request,response);
    }

    private double calculateBMI (double weight, double height){
        return weight / (height * height);
    }
    
    private String determineBuilt(int BMI){
        if (BMI < 18.5){
            return "underweight";
        } else if (18.5 <= BMI && BMI < 25){
            return "normal";
        } else if (25 <= BMI && BMI  < 30){
            return "overweight";
        } else if (30 <= BMI && BMI  < 35){
            return "obese";
        } else if (BMI >= 35){
            return "extremely obese";
        }
        return null;
    }
}
