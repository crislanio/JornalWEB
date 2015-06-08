package br.ufc.controller.teste;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.teste.ClassificadoDAO;
import br.ufc.dao.teste.FabricaDeConexoes;
import br.ufc.model.Classificado;




@Controller
public class ClassificadoController {

	@RequestMapping("ofertar_classificado")
	public String ofertar(long id){
		return "classificado/oferta_compra";
	}
		
	
	@RequestMapping("classificado")
	public String listaClassificados(Model model){
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		ClassificadoDAO cDAO = new ClassificadoDAO(conn);
		

		List<Classificado> c = cDAO.getListar();
		model.addAttribute("classificados", c);
		return "classificado/classificados";
	}
	
	@RequestMapping("formularioClassificado")
	public String formularioClassificao(){
		return "classificado/formulario_classificado";
	}
	
	
	@RequestMapping("cadastrar_classificado")
	public String cadastrarClassificado(Classificado classificado, HttpSession session){
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		ClassificadoDAO cDAO = new ClassificadoDAO(conn);
		
		cDAO.inserir(classificado);
		
		return "redirect:formulario_classificado";
		
	}
	
	
	
	
}
