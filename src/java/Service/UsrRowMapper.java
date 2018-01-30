/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import java.sql.*;

/**
 *
 * @author syntel
 */
public class UsrRowMapper implements RowMapper{
    public Object mapRow(ResultSet rs, int index) throws SQLException 
	{
        User usr = new User();
        usr.setId(rs.getInt(1));
	usr.setUsername(rs.getString(2));
        usr.setPassword(rs.getString(3));
        usr.setEnabled(rs.getInt(4));
	return usr;
        }   
}
