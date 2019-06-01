package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pais {
	
	int id;
	String nome;
	long populacao;
	double area;
	
	public Pais() {
		
	}
	
	public Pais(int id, String nome, long populacao, double area) {
		super();
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
		
		public Connection obtemConexao() throws SQLException {
			return DriverManager
					.getConnection("jdbc:mysql://localhost/vendas?user=Alunos&password=alunos&useTimezone=true&serverTimezone=UTC");
		}

		public void criar() {
			String sqlInsert = "INSERT INTO Paises(nome, populacao, area) VALUES (?, ?, ?)";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setString(1, getNome());
				stm.setLong(2, getPopulacao());
				stm.setDouble(3, getArea());
				stm.execute();
				String sqlQuery  = "SELECT LAST_INSERT_ID()";
				try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
					if(rs.next()){
						setId(rs.getInt(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public void atualizar() {
			String sqlUpdate = "UPDATE Paises SET nome=?, populacao=?, area=? WHERE id=?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, getNome());
				stm.setLong(2, getPopulacao());
				stm.setDouble(3, getArea());
				stm.setInt(4, getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void excluir() {
			String sqlDelete = "DELETE FROM Paises WHERE id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void carregar() {
			String sqlSelect = "SELECT nome, populacao, area FROM Paises WHERE cliente.id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						setNome(rs.getString("nome"));
						setPopulacao(rs.getLong("populacao"));
						setArea(rs.getDouble("area"));
					} else {
						setId(-1);
						setNome(null);
						setPopulacao(0);
						setArea(0);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public Pais comMaisHabitantes() {
		Pais comMaisHabitantes = new Pais();
		String sqlSelect = "SELECT id, nome, populacao, area FROM paises WHERE populacao=(select max(populacao) from paises)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					comMaisHabitantes.setId(rs.getInt("id"));
					comMaisHabitantes.setNome(rs.getString("nome"));
					comMaisHabitantes.setPopulacao(rs.getLong("populacao"));
					comMaisHabitantes.setArea(rs.getDouble("area"));
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(0);
					setArea(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return comMaisHabitantes;
		
	}

}
