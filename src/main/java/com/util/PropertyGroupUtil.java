package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class PropertyGroupUtil {

    private String defaultGroupName;
    private Properties group;

    public PropertyGroupUtil(String fileName)
    {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
            group = new Properties();
            group.load(inputStream);
            defaultGroupName = group.getProperty("groupName");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDefaultGroupName()
    {
        return defaultGroupName;
    }

    public Properties getGroup(String poolName)
    {
        return group;
    }

    public List<String> getGroups()
    {

        return null;
    }


}
