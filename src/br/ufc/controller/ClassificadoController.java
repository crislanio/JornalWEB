package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Classificado;
// import br.ufc.model.Usuario;



@Transactional
@Controller
public class ClassificadoController {

	@Autowired
	private ClassificadoDAO classificadoDAO;
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping("formularioClassificado")
	public String formularioClassificao(){
		return "classificado/cadastrar_classificado";
	}
	@RequestMapping("cadastrarClassificado")
	public String addClassificado( HttpSession session, Classificado classificado){
		classificadoDAO.add(classificado);
		return "redirect:formularioClassificado";
		
	}
	
	@RequestMapping("classificados")
	public String listaClassificados(Model model){
		List<Classificado> classificados = classificadoDAO.listar();
		model.addAttribute("classificados", classificados);
		return "classificado/classificados";
	}
	
	
	@RequestMapping("ofertar")
	public String ofertar(long id_classificado){
		return "classificado/ofertaDeCompra";
	}
	
}
