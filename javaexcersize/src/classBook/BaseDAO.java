package classBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
	config config=new config();
	public BaseDAO() {
		try {
			Class.forName(config.getValue("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ���� --------------------------
	private Connection conn;
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;

	// �������--------------------------
	public Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(
						config.getValue("url"),
						config.getValue("user"), config.getValue("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getConnection��������");
		}
		return conn;
	}

	public boolean openAutoCommit() throws SQLException {
		conn=getConn();
		if(conn.getAutoCommit()) {
			conn.setAutoCommit(false);
		}
		return true;
	}
	
	public boolean closeAutoCommit() throws SQLException {
		
		conn.commit();
		conn.setAutoCommit(true);
		return true;
	}
	
	public boolean roback() throws SQLException {
		conn.rollback();
		return true;
	}
	// ִ������ɾ����SQL���--------------------
	public int executeUpdate(String sql) throws SQLException {
		int count=0;
		
		
		if (conn == null) {
			System.out.println("�����ݿ�����ʧ��!");
			
			return -1;
		}
		stm = conn.createStatement();
		count =stm.executeUpdate(sql);
		return count;
	}

	// ����ִ������ɾ����SQL���--------------------
	public int executeUpdate(String sql, Object[] obj) throws SQLException {
		if (getConn() == null) {
			System.out.println("�����ݿ�����ʧ��!");
			return -1;
		}
		pstm = conn.prepareStatement(sql);
		if (obj != null) {
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
		}
		return pstm.executeUpdate();
	}

	// ִ�в�ѯSQL���----------------------------
	public ResultSet executeQuery(String sql) throws SQLException {
		if (getConn() == null) {
			System.out.println("�����ݿ�����ʧ��!");
			return null;
		}
		stm = conn.createStatement();
		rs = stm.executeQuery(sql);
		return rs;
	}

	// ����ִ�в�ѯSQL���----------------------------
	public ResultSet executeQuery(String sql, Object[] obj) throws SQLException {
		if (getConn() == null) {
			System.out.println("�����ݿ�����ʧ��!");
			return null;
		}
		pstm = conn.prepareStatement(sql);
		if (obj != null) {
			for (int i = 0; i < obj.length; i++) {
				pstm.setObject(i + 1, obj[i]);
			}
		}
		rs = pstm.executeQuery();
		return rs;
	}

	// �ر�ResultSet
	public void closeResultSet() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// �ر�Connection
	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// �ر�Statement��PreparedStatement
	public void closeStatement() {
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
