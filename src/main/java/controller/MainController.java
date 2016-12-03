package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import service.impl.MasterServiceImpl;
import model.Master;

import java.util.List;

/**
 * Created by aantipin on 15/11/2016.
 */
@RestController
@RequestMapping(value = "/service")
public class MainController {

    @Autowired
    private MasterServiceImpl masterService;

    @Secured("ROLE_ADMIN")
    @GetMapping(value= "/")
    @ResponseBody
    public MyDataObject getAllMyData() {
        List<Master> masters = masterService.getAllMaster();
        return new MyDataObject(masters.size() + "", "Столько книг");
    }

    @GetMapping(value= "/{id}")
    @ResponseBody
    public MyDataObject getMyData(@PathVariable("id") String id) {
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return new MyDataObject(id, "Не верный id");
        }
        Master master = masterService.findMasterById(Integer.parseInt(id));
        if (master == null) return new MyDataObject(id, "Книга не существует!");
        return new MyDataObject(id, master.toString());
    }

    @PutMapping
    @ResponseBody
    public MyDataObject putMyData(@RequestBody MyDataObject md) {
        return md;
    }

    @PostMapping
    @ResponseBody
    public MyDataObject postMyData() {
        return new MyDataObject("321321", "это ответ метода POST!");
    }

    @DeleteMapping(value= "/{id}")
    @ResponseBody
    public MyDataObject deleteMyData(@PathVariable("id") String id) {
        return new MyDataObject("delete", "Это ответ метода DELETE!");
    }
}
