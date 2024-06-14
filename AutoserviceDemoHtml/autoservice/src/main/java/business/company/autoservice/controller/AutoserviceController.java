package business.company.autoservice.controller;

import business.company.autoservice.model.Autoservice;
import business.company.autoservice.service.ServiceAutoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class AutoserviceController {

    private final ServiceAutoImpl serviceAuto;

    @GetMapping("/")
    public String findAllAutoservice(Model model) {
        model.addAttribute("service",serviceAuto.findAllAutoservice());
        return "index";
    }

    @GetMapping("autoservice/new")
    public String addAutoservice(Model model){
        Autoservice autoservice = new Autoservice();
        model.addAttribute("autoservice",autoservice);
        return "autoservice_new";
    }

    @PostMapping("/autoservicies")
    public String saveAutoservice(@ModelAttribute Autoservice autoservice) {
        serviceAuto.saveAutoservice(autoservice);
        return "redirect:/";
    }

    @GetMapping("autoservice/edit/{id}")
    public String editAutoservice(@PathVariable(value = "id") int id, Model model){
        Autoservice autoservice = serviceAuto.findById(id);
        model.addAttribute("autoservice",autoservice);
        return "edit";
    }
    @PostMapping("/autoservice/edit/{id}")
    public String setAutoservice(@PathVariable(value = "id") int id, Model model,
                          @RequestParam String nameAuto,
                          @RequestParam String nameSupport,
                          @RequestParam int priceSupport){
        Autoservice autoservice = serviceAuto.findById(id);
        autoservice.setNameAuto(nameAuto);
        autoservice.setNameSupport(nameSupport);
        autoservice.setPriceSupport(priceSupport);
        serviceAuto.updateAutoservice(autoservice);
        return "redirect:/";
    }

    @GetMapping("/autoservice/delete/{id}")
    public String autoserviceDelete(@PathVariable int id) {
        serviceAuto.deleteAutoservice(id);
        return "redirect:/";
    }

    @PutMapping("update_autoservice")
    public Autoservice updateAutoservice(@RequestBody Autoservice autoservice) {
        return serviceAuto.updateAutoservice(autoservice);
    }

    @DeleteMapping("delete_autoservice/{id}")
    public void deleteAutoservice(@PathVariable int id) {
        serviceAuto.deleteAutoservice(id);
    }


}

