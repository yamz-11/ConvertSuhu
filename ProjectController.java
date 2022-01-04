/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cemilan.Suhu_20200140103;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Wiratama
 */
@Controller
public class ProjectController {
    
    @RequestMapping("/suhu")
    public String getHasil(HttpServletRequest data, Model suhu){
        
        String getSuhu = data.getParameter("namasuhu");
        int getCelcius = Integer.parseInt(data.getParameter("celcius"));
        
        int suhuReamur = suhuReamur(getCelcius);
        int suhuFahrenheit = suhuFahrenheit(getCelcius);
        int suhuKelvin = suhuKelvin(getCelcius);
        
        suhu.addAttribute("celcius", getCelcius);
        suhu.addAttribute("suhuReamur", suhuReamur);
        suhu.addAttribute("suhuFahrenheit", suhuFahrenheit);
        suhu.addAttribute("suhuKelvin", suhuKelvin);
        
        
        return "tabelview";
        
    }
    private int suhuReamur(int suhuCelcius){
        int reamur = suhuCelcius * 4/5;
        return reamur;
    }
    
    private int suhuFahrenheit(int suhuCelcius){
        int fahrenheit = suhuCelcius * 9/5;
        return fahrenheit;
    }
    
    private int suhuKelvin(int suhuCelcius){
        int fahrenheit = (int) (suhuCelcius + 273.15);
        return fahrenheit;
    }
   
}
