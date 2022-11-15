/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_card.id_card;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author M.Barik Addarukutni
 */
@Controller
public class controller {
    @RequestMapping("/inputData")
    
    public String inputData (@RequestParam ("nama") String name,
                                 @RequestParam ("tanggal") @DateTimeFormat(pattern = "yyyy-MM-dd")Date date,
                                 @RequestParam ("image") MultipartFile file, Model KTP)
                                 throws IOException {
       
        SimpleDateFormat Tanggal = new SimpleDateFormat("EEEE, YYY-MM-dd");
        
        String newTanggal = Tanggal.format(date);
        
        String blob = Base64.encodeBase64String(file.getBytes());
                
        String gambar = "data:image/jpeg;base64,".concat(blob);
        
        KTP.addAttribute("nama", name);
        KTP.addAttribute("tanggal", newTanggal);
        KTP.addAttribute("image", gambar);
        
        return "hasil";
    }
    
}
