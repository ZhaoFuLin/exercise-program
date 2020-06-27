package com.company.gjp.controller;

import com.company.gjp.domain.ZhangWu;
import com.company.gjp.service.ZhangWuService;

import java.util.List;

public class ZhangWuController {
    private ZhangWuService service = new ZhangWuService();

    public List<ZhangWu> selectAll() {
        return service.selectAll();
    }

    public List<ZhangWu> select(String startDate, String endDate) {
        return service.select(startDate, endDate);
    }

    public void addZhangWu(ZhangWu zw) {
        service.addZhangWu(zw);
    }

    public void editZhangWu(ZhangWu zw) {
        service.editZhangWu(zw);
    }

    public void deleteZhangWu(int zwid) {
        service.deleteZhangWu(zwid);
    }
}
