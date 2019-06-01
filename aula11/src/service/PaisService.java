package service;


import model.Pais;
import dao.PaisDAO;

public class PaisService {
		PaisDAO dao = new PaisDAO();
		
		public int criar(Pais pais) {
			return dao.criar(pais);
		}
		
		public void atualizar(Pais pais){
			dao.atualizar(pais);
		}
		
		public void excluir(int id){
			dao.excluir(id);
		}
		
		public Pais carregar(int id){
			return dao.carregar(id);
		}
		public Pais comMaisHabitantes(){
			return dao.comMaisHabitantes(null);
		}

	}


