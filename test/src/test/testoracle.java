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
		
		 Connection con = null;// ����һ�����ݿ�����
		 Statement statement = null;// ����Ԥ����������һ�㶼�������������Statement
		    ResultSet result = null;// ����һ�����������
		    try
		    {
		        Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
		        System.out.println("��ʼ�����������ݿ⣡");
		        String url = "jdbc:oracle:" + "thin:@127.0.0.1:1521:ORCL";
		        String user = "system";// �û���,ϵͳĬ�ϵ��˻���
		        String password = "a123456B";// �㰲װʱѡ���õ�����
		        con = DriverManager.getConnection(url, user, password);// ��ȡ����
		        System.out.println("���ӳɹ���");
		        statement = con.createStatement();
		        result = statement.executeQuery("select * from A_ADMIN_INFO");
		        while (result.next())
		            // ���������Ϊ��ʱ
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
		            // ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
		            // ע��رյ�˳�����ʹ�õ����ȹر�
		            if (result != null)
		                result.close();
		            if (con != null)
		                con.close();
		            System.out.println("���ݿ������ѹرգ�");
		        }
		        catch (Exception e)
		        {
		            e.printStackTrace();
		        }
		    }

	}

}
