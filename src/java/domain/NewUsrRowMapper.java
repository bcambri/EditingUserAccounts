package domain;



import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import java.sql.*;

 class NewUsrRowMapper implements RowMapper {
      public Object mapRow(ResultSet rs, int index) throws SQLException 
	{
        newUser usr = new newUser();
        usr.setId(rs.getInt(1));
	usr.setFirst(rs.getString(2));
        usr.setLast(rs.getString(3));
        usr.setStreet(rs.getString(4));
        usr.setCity(rs.getString(5));
        usr.setState(rs.getString(6));
        usr.setZip(rs.getInt(7));
        usr.setPhone(rs.getString(8));
	usr.setUsername(rs.getString(9));
	usr.setPassword(rs.getString(10));	
	return usr;
        }      
}