/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.newUser;
import Model.User;
import java.sql.Types;
import java.util.Collections;
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

    private static JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertRecord(newUser usr) {
        long id = 1;
        long maxId = getMaxId();
        while (id <= maxId && findId(id) != 0) {
            id++;
        }
        String p_query = "insert into Customers values(" + id + ",?,?,?,?,?,?,?)";
        jdbcTemplate.update(p_query, new Object[]{
            usr.getFirst(), usr.getLast(), usr.getStreet(), usr.getCity(), usr.getState(), usr.getZip(), usr.getPhone()});

        // keep username/password + enabled in separate table
        p_query = "insert into CustomerAccounts values(?,?,?,0)";
        jdbcTemplate.update(p_query, new Object[]{id, usr.getUsername(), usr.getPassword()});

        p_query = "insert into Login values(?,?,2)";
        jdbcTemplate.update(p_query, new Object[]{id, usr.getPassword()});
    }

    @Override
    public int findRecord(String usrId) {
        return jdbcTemplate.queryForObject("select count(*) from CustomerAccounts where username='" + usrId + "'", Integer.class);
    }

    @Override
    public long getTotalNoOfCustomers() {
        return jdbcTemplate.queryForObject("select count(*) from Customers", Integer.class);
    }

    @Override
    public List getAllCustomers() {
        return jdbcTemplate.query("select Customers.customerid, firstname, lastname, "
                    + "street, city, state, zip, phone, username, password, enabled "
                    + "from Customers join CustomerAccounts on Customers.customerid=CustomerAccounts.customerid"
                    + " order by Customers.lastname",
                    new NewUsrRowMapper());
    }

    @Override
    public User getCustomerByName(String first, String last) {
        Object o[] = {first, last};
        int argsTypes[] = {Types.VARCHAR, Types.VARCHAR};
        RowMapper mapper = new NewUsrRowMapper();
        List l = jdbcTemplate.query("select * from Customers where Customers.firstname=? and Customers.lastname=?", o, argsTypes, mapper);
        Iterator it = l.iterator();
        User usr = (User) it.next();
        return usr;
    }

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

    @Override
    public void banOrEnableCustomer(int id) {
        if (findId(id) != 0) {
            Integer enabled = jdbcTemplate.queryForObject("select enabled from CustomerAccounts where customerid=" + id, Integer.class);
            if (enabled == 0) {
                enabled = 1;
            } else {
                enabled = 0;
            }
            jdbcTemplate.update("update CustomerAccounts set enabled=" + enabled + " where customerid=" + id);
        }
    }

    @Override
    public void deleteCustomer(int id) {
        if (findId(id) != 0) {
            String password = jdbcTemplate.queryForObject("select password from CustomerAccounts where customerid=" + id, String.class);
            jdbcTemplate.update("delete from Customers where customerid=" + id);
            jdbcTemplate.update("delete from CustomerAccounts where customerid=" + id);
            jdbcTemplate.update("delete from Login where password='" + password + "'");
        }
    }

    private int findId(long id) {
        return jdbcTemplate.queryForObject("select count(*) from Customers where customerid=" + id, Integer.class);
    }
}
