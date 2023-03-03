package SoulCode.Services.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SoulCode.Services.Models.Funcionario;
import SoulCode.Services.Repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	// findAll (método da Spring Data) - busca todos os registros
    public List<Funcionario> mostrarTodosFuncionarios(){
		return funcionarioRepository.findAll();
	}
    
    // findById - busca um funcionário específico pelo seu id
 	public Funcionario mostrarUmFuncionario(Integer idFuncionario) {
 		Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
 		return funcionario.orElseThrow();
 	}
 	
   // findByEmail - busca um funcionário específico pelo seu email
  	public Funcionario mostrarUmFuncionarioPeloEmail(String email) {
  		Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(email);
  		return funcionario.orElseThrow();
  	}
  	
  	 // findByNomeAndEmail - busca um funcionário específico pelo seu nome e email
  	public Funcionario mostrarUmFuncionarioPeloNomeEEmail(String nome, String email) {
  		Optional<Funcionario> funcionario = funcionarioRepository.findByNomeAndEmail(nome,email);
  		return funcionario.orElseThrow();
  	}
 	
 	//save - insere um novo registro na tabela do nosso db
 	public Funcionario inserirFuncionario(Funcionario funcionario) {
 		//por precaução vamos limpar o campo de id do funcionário
 		funcionario.setIdFuncionario(null);
 		return funcionarioRepository.save(funcionario);
 			
 		//o método save pega os dados do novo funcinário, salva no db e já gera um id para esse
 		//novo funcionário
 	}
 	
    // editar um funcionário já cadastrado
 	public Funcionario editarFuncionario (Funcionario funcionario) {
 		mostrarUmFuncionario(funcionario.getIdFuncionario());
 		return funcionarioRepository.save(funcionario);
 	}
 	
 // deleteById  - excluir um funcionário pelo seu id
 	public void excluirFuncionario (Integer idFuncionario) {
 		mostrarUmFuncionario(idFuncionario);
 		funcionarioRepository.deleteById(idFuncionario);
 	}
 	
 	public Funcionario salvarFoto(Integer idFuncionario, String caminhoFoto) {
		Funcionario funcionario = mostrarUmFuncionario(idFuncionario);
		funcionario.setFoto(caminhoFoto);
		return funcionarioRepository.save(funcionario);
	}

}
