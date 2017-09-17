package com.cike.controller;

import com.cike.common.MyConst;
import com.cike.entity.Device;
import com.cike.entity.User;
import com.cike.service.DeviceService;
import com.cike.util.Files_Utils_DG;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceController.class);

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
    public String save(@RequestParam("file") MultipartFile file, Device device,HttpServletRequest request) {
        //调用保存文件的帮助类进行保存文件，并返回文件的相对路径
        if (!file.isEmpty()){
            String filePath = Files_Utils_DG.FilesUpload_transferTo_spring(request, file, "/upload");
            LOGGER.info("filePath：{}",filePath);
            device.setFilePath(filePath);
        }
        User user = (User) request.getSession().getAttribute(MyConst.CURRENT_USER);
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

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Long id, ModelMap map) {
        if (id != null && id > 0) {
            Device device = deviceService.findOne(id);
            map.put("device", device);
        }
        return "device/detail";
    }
}
