package com.cike.controller;

import com.cike.common.MyConst;
import com.cike.entity.Device;
import com.cike.entity.User;
import com.cike.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author CIKE
 * @desc ${DESCRIPTION}
 * @create 2017-09-14 10:26
 **/
@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/list")
    public String list(ModelMap map, HttpSession session) {
        User user = (User) session.getAttribute(MyConst.CURRENT_USER);
        List<Device> list = deviceService.findByUserId(user.getId());
        map.put("list", list);
        return "device/list";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Long id, ModelMap map) {
        if (id != null && id > 0) {
            Device device = deviceService.findOne(id);
            map.put("device", device);
        }
        return "device/edit";
    }

    @RequestMapping("save")
    public String save(Device device,HttpSession session) {
        User user = (User) session.getAttribute(MyConst.CURRENT_USER);
        device.setUserId(user.getId());
        deviceService.save(device);
        return "redirect:/device/list";
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        deviceService.delete(id);
        return "SUCCESS";
    }

}
