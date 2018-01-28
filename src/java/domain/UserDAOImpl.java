/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Types;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author syntel
 */
public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertRecord(newUser usr) {
        /*String query="insert into Emp values('"+e.getEmpId()+"','"+e.getEmpName()+"',"+e.getSalary()+")";
        jdbcTemplate.update(query);*/

        //try {
        //findRecord(usr.getUsername());
        //   return 1;
        // } catch (NoSuchElementException e) {
        //Inserting using prepared Statement
        long id = getMaxId() + 1;
        String p_query = "insert into Customers values(" + id + ",?,?,?,?,?,?,?)";
        jdbcTemplate.update(p_query, new Object[]{
            usr.getFirst(), usr.getLast(), usr.getStreet(), usr.getCity(), usr.getState(), usr.getZip(), usr.getPhone()});

        // keep username/password + enabled in separate table
        p_query = "insert into CustomerAccounts values(?,?,?,0)";
        jdbcTemplate.update(p_query, new Object[]{id, usr.getUsername(), usr.getPassword()});
        // return 0;
        //}
    }

    @Override
    public int findRecord(String usrId) {
        /*Object o[] = {usrId};
        int argsTypes[] = {Types.VARCHAR};
        RowMapper mapper = new UsrRowMapper();
        List l = jdbcTemplate.query("select * from Customers join CustomerAccounts "
                + "on Customers.customerid=CustomerAccounts.customerid where username=?",
                o, argsTypes, mapper);
        Iterator it = l.iterator();
        User usr = (User) it.next();*/
        return jdbcTemplate.queryForObject("select count(*) from CustomerAccounts where username='" + usrId + "'", Integer.class);
    }

    @Override
    public long getTotalNoOfCustomers() {
        //JdbcTemplate jt = getJdbcTemplate();
        return jdbcTemplate.queryForObject("select count(lastname) from Customers", Integer.class);
    }

    @Override
    public List getAllCustomers() {
        return jdbcTemplate.query("select * from Customers join CustomerAccounts on Customers.customerid=CustomerAccounts.customerid", new NewUsrRowMapper());
    }

    @Override
    public User getCustomerByName(String first, String last) {
        //JdbcTemplate jt = getJdbcTemplate();
        Object o[] = {first, last};
        int argsTypes[] = {Types.VARCHAR, Types.VARCHAR};
        RowMapper mapper = new NewUsrRowMapper();
        List l = jdbcTemplate.query("select * from Customers where Customers.firstname=? and Customers.lastname=?", o, argsTypes, mapper);
        Iterator it = l.iterator();
        User usr = (User) it.next();
        return usr;
    }

    /*private int getCustomerId(String first, String last) {
        /*Object o[] = {name};
        int argsTypes[] = {Types.VARCHAR};
        RowMapper mapper = new UsrRowMapper();
        List l = jdbcTemplate.query("select customerid from Customers where Customers.firstname=?", o, argsTypes, mapper);
        Iterator<Integer> it = l.iterator();
        int id = it.next();
        return id;*
        Integer id = jdbcTemplate.queryForObject("select customerid from Customers where "
                + "Customers.firstname=" + first + " and Customers.lastname=" + last, Integer.class);
        return ((id == null) ? 0 : id);
    }*/
    private long getMaxId() {
        Integer id = jdbcTemplate.queryForObject("select max(customerid) from Customers", Integer.class);
        return ((id == null) ? 0 : id);
    }

    @Override
    public void findValidUser(String usrId, String pwd) {
        Object o[] = {usrId, pwd};
        int argsTypes[] = {Types.VARCHAR, Types.VARCHAR};
        RowMapper mapper = new UsrRowMapper();
        List l = jdbcTemplate.query("select * from CustomerAccounts where username=? and password=?",
                o, argsTypes, mapper);
        Iterator it = l.iterator();
        User usr = (User) it.next();
    }
}
