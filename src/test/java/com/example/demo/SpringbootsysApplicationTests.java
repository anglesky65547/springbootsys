package com.example.demo;

import com.example.demo.dao.*;
import com.example.demo.domain.Bed;
import com.example.demo.domain.CheckOut;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Worker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SpringbootsysApplicationTests {

    @Test
    void contextLoads() {
    }
    @Resource
    private DataSource dataSource;


    @Test
    public void testGetDataSource(){
        System.out.println(dataSource.getClass());
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            System.out.println(connection.isClosed());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Resource
    private WorkerDao workerDao;
    //查询所有信息
    @Test
    public void testSelectAll(){
        List<Worker> workers = workerDao.selectAll();
        System.out.println(workers);
    }
    @Test
    public void  testSelectByName(){
        String name = "2";
        List<Worker> worker = workerDao.selectByName(name);
        System.out.println(worker);
    }

    @Test
    public void testInsert(){
        Worker worker = new Worker();
        worker.setWorkerid("df454");
        worker.setWorker("123123");
        worker.setSex("男");
//        worker.setAge("2019-02-03");
        worker.setType("123");
        worker.setEntrydate("2020-01-01");
        worker.setPost("123");
        worker.setTitle("wwer");
        worker.setStatus("12");
        worker.setIntroduction("44551");
        worker.setNote("98");
        int i = workerDao.addWorker(worker);
        System.out.println(i);
    }

    @Test
    public void testUpdate(){
        Worker worker = new Worker();
        worker.setId(5);
        worker.setWorkerid("修改");
        worker.setWorker("0");
        worker.setSex("女");
//        worker.setAge("2019-01-01");
        worker.setType("0");
        worker.setEntrydate("2020-02-00");
        worker.setPost("0");
        worker.setTitle("0");
        worker.setStatus("0");
        worker.setIntroduction("0");
        worker.setNote("0");
        int i = workerDao.updateByWork(worker);
        System.out.println(i);
    }


    @Resource
    private CustomerDao customerDao;
    //查询所有信息
    @Test
    public void testSelectAll2(){
        List<Customer> customerList = customerDao.selectAll();
        System.out.println(customerList);
    }
    @Test
    public void testaddCustomer(){
        Customer customer =new Customer();
        customer.setCustomerid(10235);
        customer.setIdnumber("5454544");
        customer.setName("lisi");
        customer.setFilesid("98624");
        int i = customerDao.addCustomer(customer);
        System.out.println(i);
    }

    @Resource
    private CheckOutDao checkOutDao;
    @Test
    public  void testShowAll(){
        List<CheckOut> checkOutList = checkOutDao.selectAll();
        System.out.println(checkOutList);
    }

    @Resource
    private BedDao beDao;
    @Test
    public void testshowall(){
        List<Bed> beList = beDao.selectAll();
        System.out.println(beList);
    }

    @Resource
    private RegisterDao registerDao;
    @Test
    public void testregister(){
        String name = "admin";
        String psw = "admin";
        int i = registerDao.login(name,psw);
        System.out.println(i);
    }

}
