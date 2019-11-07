package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class testoracle {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Connection con = null;// 创建一个数据库连接
		 Statement statement = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		    ResultSet result = null;// 创建一个结果集对象
		    try
		    {
		        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
		        System.out.println("开始尝试连接数据库！");
		        String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:ORCL";
		        String user = "system";// 用户名,系统默认的账户名
		        String password = "a123456B";// 你安装时选设置的密码
		        con = DriverManager.getConnection(url, user, password);// 获取连接
		        System.out.println("连接成功！");
		        statement = con.createStatement();
		        result = statement.executeQuery("select * from A_ADMIN_INFO");
		        while (result.next())
		            // 当结果集不为空时
		            System.out.println(result.getInt("A_PASSWORD"));
		    }
		    catch (Exception e)
		    {
		        e.printStackTrace();
		    }
		    finally
		    {
		        try
		        {
		            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
		            // 注意关闭的顺序，最后使用的最先关闭
		            if (result != null)
		                result.close();
		            if (con != null)
		                con.close();
		            System.out.println("数据库连接已关闭！");
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
		    }

	}

}
