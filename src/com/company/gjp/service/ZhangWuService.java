package com.company.gjp.service;

import com.company.gjp.dao.ZhangWuDao;
import com.company.gjp.domain.ZhangWu;

import java.util.List;

public class ZhangWuService {
    private ZhangWuDao dao = new ZhangWuDao();

    public List<ZhangWu> selectAll() {
        return dao.selectAll();
    }

    public List<ZhangWu> select(String startDate, String endDate) {
        return dao.select(startDate, endDate);
    }

    public void addZhangWu(ZhangWu zw) {
        dao.addZhangWu(zw);
    }

    public void editZhangWu(ZhangWu zw) {
        dao.editZhangWu(zw);
    }

    public void deleteZhangWu(int zwid) {
        dao.deleteZhangWu(zwid);
    }
}
