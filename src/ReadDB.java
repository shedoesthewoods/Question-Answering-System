package chatbot;

import java.sql.*;

class ReadDB {
	//JDBC driver adi and veritabani URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://LAPTOP-RKHJINC7:1433;DatabaseName=QuestionAnswering";

	//Veritabani baglantisi
	static final String USER = "sa";
	static final String PASS = "limonata";

	Connection conn = null;
	Statement stmt = null;

	ReadDB(){ }

	void read() {
		try{
			//JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			//Baglanti acma
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			//Sorgu calistirma
			stmt = conn.createStatement();

			String sql = "Select Id, Name,Lastname,Hand,Birthday,Country From atp_players;";
			ResultSet rs = stmt.executeQuery(sql);
			//ResultSet'ten verileri cekme
			while(rs.next()){
				//Sutun adlarini alma
				int id  = rs.getInt("Id");
				String name = rs.getString("Name");
				String lastname = rs.getString("Lastname");
				String birthday = String.valueOf(rs.getInt("Birthday")); //date tipine setbDate metoduyla cast ediliyor
				String hand = rs.getString("Hand");
				String country = rs.getString("Country");

				System.out.println("ID: " + id + ", Name: " + name + ", Lastname: "+ lastname + ", Hand: "+ hand+
						", Birthday: " + birthday + ", Country: " + country);
			}
			rs.close();
		}catch(SQLException se){
			//JDBC icin hata ayiklama
			se.printStackTrace();
		}catch(Exception e){
			//Class.forName icin hata ayiklama
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
}
