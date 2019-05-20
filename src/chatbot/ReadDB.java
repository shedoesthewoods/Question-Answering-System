package chatbot;

import java.sql.*;

class ReadDB {
	//JDBC driver adi and veritabani URL
	private static final String JDBC_DRIVER = "com.mysql.sqlserver.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://LAPTOP-RKHJINC7:1433;DatabaseName=QuestionAnswering";

	//Veritabani baglantisi
	private static final String USER = "sa";
	private static final String PASS = "limonata";

	private Connection conn = null;
	private Statement stmt = null;

	void read(String sql) {
		try{
			//JDBC driver
			Class.forName(JDBC_DRIVER);

			//Baglanti acma
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			//Sorgu calistirma
			stmt = conn.createStatement();

			//String sql = "Select Id, Name,Lastname,Hand,Birthday,Country From atp_players;";
			ResultSet rs = stmt.executeQuery(sql);

			//ResultSet'ten verileri cekme
			while(rs.next()){
				//Sutun adlarini alma
				int id  = rs.getInt("Id");
				String name = rs.getString("Name");
				String lastname = rs.getString("Lastname");
				String birthday = rs.getString("Birthday");
				String hand = rs.getString("Hand");
				String country = rs.getString("Country");
				String cinsiyet = rs.getString("Cinsiyet");

				System.out.println("ID: " + id + ", Name: " + name + ", Lastname: "+ lastname +
						", Hand: "+ hand+ ", Birthday: " + birthday + ", Country: " +
							country + ", Cinsiyet: "+cinsiyet);
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
				if(stmt!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}

			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
}
