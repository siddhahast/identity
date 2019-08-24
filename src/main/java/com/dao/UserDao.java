package com.dao;

import com.database.ConnectionPool;
import com.datatype.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User readUser(Long id) throws SQLException
    {
        Connection connection = null;
        try {
            connection = ConnectionPool.getDefaultInstance().getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement statement = connection.prepareStatement("select * from identity.user");
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {

        }
        return null;
    }

}
