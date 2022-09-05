package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class update {
	public static void main(String[] args) {
		final String URL
		= "jdbc:mysql://localhost:3306/database01?user=user01&password=password01&allowPublicKeyRetrieval=true&useSSL=false";
		final String USER = "root";
		final String PASS = "N700snzomi";
		final String SQL = "update user set name = ?, email = ? where id = ?";
		
		try(Connection connection = 
				DriverManager.getConnection(URL, USER, PASS)) {
			connection.setAutoCommit(false);
			
			try(PreparedStatement ps = connection.prepareStatement(SQL)){
				ps.setString(1,  "Kanako Momota");
				ps.setString(2, "kanako@com");
				ps.setString(3, "2");
				ps.executeUpdate();
				connection.commit();
			} catch (Exception e) {
				connection.rollback();
				System.out.println("rollback");
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("処理が完了しました");
		}
	}

}
