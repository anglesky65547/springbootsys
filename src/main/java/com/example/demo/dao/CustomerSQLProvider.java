package com.example.demo.dao;

import com.example.demo.domain.Bed;
import com.example.demo.domain.CheckOut;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Worker;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.jdbc.SQL;

public class CustomerSQLProvider {
    public String updateCustomer(Customer customer){
        return  new SQL(){
            {
                UPDATE("checkin");
//                if(null != customer.getCustomerid()){
//                    SET("customerid = #{customerid}");
//                }
                if(null != customer.getName()){
                    SET("name = #{name}");
                }
                if(null != customer.getAge()){
                    SET("age = #{age}");
                }
                if(null != customer.getSex()){
                    SET("sex = #{sex}");
                }
                if(null != customer.getIdnumber()){
                    SET("idnumber = #{idnumber}");
                }
                if(null != customer.getRoomid()){
                    SET("roomid = #{roomid}");
                }
                if(null != customer.getFloatid()){
                    SET("floatid = #{floatid}");
                }
                if(null != customer.getFilesid()){
                    SET("filesid = #{filesid}");
                }
                if(null != customer.getOldmantype()){
                    SET("oldmantype = #{oldmantype}");
                }
                if(null != customer.getCheckindata()){
                    SET("checkindata = #{checkindata}");
                }
                if(null != customer.getServicematurity()){
                    SET("servicematurity = #{servicematurity}");
                }
                if(null != customer.getPhonenumber()){
                    SET("phonenumber = #{phonenumber}");
                }
                if(null != customer.getHeight()){
                SET("height = #{height}");
                }
                if(null != customer.getMaritalstatus()){
                SET("maritalstatus = #{maritalstatus}");
                }
                if(null != customer.getWeight()){
                SET("weight = #{weight}");
                }
                if(null != customer.getBloodtype()){
                SET("bloodtype = #{bloodtype}");
                }
                if(null != customer.getImage()){
                SET("image = #{image}");
                }
                if(null != customer.getWorker()){
                SET("worker = #{worker}");
                }
                WHERE("customerid = #{customerid}");
            }
        }.toString();
    }
    public String updateWorker(Worker worker){
        return  new SQL(){
            {
                UPDATE("worker");
                if(null != worker.getWorkerid()){
                    SET("workerid = #{workerid}");
                }
                if(null != worker.getWorker()){
                    SET("worker = #{worker}");
                }
                if(null != worker.getSex()){
                    SET("sex = #{sex}");
                }
                if(null != worker.getAge()){
                    SET("age = #{age}");
                }
                if(null != worker.getType()){
                    SET("type = #{type}");
                }
                if(null != worker.getEntrydate()){
                    SET("entrydate = #{entrydate}");
                }
                if(null != worker.getPost()){
                    SET("post = #{post}");
                }
                if(null != worker.getTitle()){
                    SET("title = #{title}");
                }
                if(null != worker.getStatus()){
                    SET("status = #{status}");
                }
                if(null != worker.getIntroduction()){
                    SET("introduction = #{introduction}");
                }
                if(null != worker.getNote()){
                    SET("note = #{note}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }
    public String updateCheckout(CheckOut checkOut){
        return  new SQL(){
            {
                UPDATE("checkout");
                if(null != checkOut.getCustomername()){
                    SET("customername = #{customername}");
                }
                if(null != checkOut.getType()){
                    SET("type = #{type}");
                }
                if(null != checkOut.getReason()){
                    SET("reason = #{reason}");
                }
                if(null != checkOut.getCheckoutdata()){
                    SET("checkoutdata = #{checkoutdata}");
                }
                if(null != checkOut.getApplicationdata()){
                    SET("applicationdata = #{applicationdata}");
                }
                if(null != checkOut.getAuditMind()){
                    SET("auditMind = #{auditMind}");
                }
                if(null != checkOut.getAuditdata()){
                    SET("auditdata = #{auditdata}");
                }
                if(null != checkOut.getWorker()){
                    SET("worker = #{worker}");
                }
                if(null != checkOut.getAuditstatus()){
                    SET("auditstatus = #{auditstatus}");
                }
                if(null != checkOut.getNote()){
                    SET("note = #{note}");
                }
                WHERE("id = #{id}");
            }
        }.toString();
    }

    public String updateBed(Bed bed){
        return new SQL(){
            {
                UPDATE("bed");
                if (null != bed.getCustomername()) {
                    SET("customername = #{customername }");
                }
                if (null != bed.getStartdate()){
                    SET("startdate = #{startdate}");
                }
                if (null != bed.getEnddate()){
                    SET("enddate = #{enddate}");
                }
                if (null != bed.getInfo()){
                    SET("info = #{info}");
                }
                WHERE("bedid = #{bedid}");
            }
        }.toString();
    }
}
