package com.dao;

import com.database.ConnectionPool;
import com.datatype.User;
import org.springframework.stereotype.Component;

import java.sql.*;

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

    public Long create(User user)
    {
        Connection connection = null;

        Long userId = null;

        String sql = "INSERT into identity.user(first_name, last_name, email, phone_number) VALUE (?, ?, ?, ?)";

        try {
            connection = ConnectionPool.getDefaultInstance().getConnection();

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhoneNumber());

            statement.executeUpdate();

            try(ResultSet rs = statement.getGeneratedKeys())
            {
                if(rs.next())
                {
                    userId = rs.getLong(1);
                }
                else
                {
                    throw new SQLException("Creating a new row failed");
                }
            }
            user.setId(userId);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userId;
    }
}
