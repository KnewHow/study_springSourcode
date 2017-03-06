package study.spring.service.impl;

import study.spring.dao.StudentDao;
import study.spring.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao dao = null;

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public void login() {
        dao.add();
        dao.update();
    }

}
