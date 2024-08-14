package com.ofss.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Login;


@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {
//	List<Login> getAllLogins();
//    List<Login> getAllLoginsAdmins(String lol);
//    List<Login> getAllLoginsTries();
//    List<Login> getAllLoginsLock(int val);
//    Login getLoginByCustomerId(int customerId);
//    boolean addLogin(Login Loger);
//    boolean checkLogin(int customerId , String userPass);
//    boolean updateTries(int customerId , boolean ok , int tr);
//    int tellTries(int customerId);
//    boolean lockIt(int custId , boolean test);
//    boolean changeStatus(int custId , String result);
//    boolean adminLock(int custId);
}
