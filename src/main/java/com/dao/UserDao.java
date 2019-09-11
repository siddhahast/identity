package com.dao;

import com.database.ConnectionPool;
import com.datatype.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDao {

    public User readUser(Long id)
    {
        Connection connection = null;
        User user = new User();
        try {
            connection = ConnectionPool.getDefaultInstance().getConnection();


            PreparedStatement statement = connection.prepareStatement("select * from identity.user where id = ?");
            statement.setLong(1, id);

            ResultSet rs = null;
            rs = statement.executeQuery();
            while (rs.next()) {
                id = rs.getLong(1);
                String firstName = rs.getString(2);

                String lastName = rs.getString(3);

                String email = rs.getString(4);

                String phone = rs.getString(5);

                user.setId(id);
                user.setLastName(lastName);
                user.setFirstName(firstName);
                user.setEmail(email);
                user.setPhoneNumber(phone);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }
}
