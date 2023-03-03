package SoulCode.Services.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.CrudRepository;
import SoulCode.Services.Models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	                                     //CrudRepository  
	Usuario findByLogin(String login);

}
