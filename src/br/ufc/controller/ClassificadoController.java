package br.ufc.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.FabricaDeConexoes;
import br.ufc.dao.RoleDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Usuario;


@Controller
public class ClassificadoController {

	@RequestMapping("ofertar_classificado")
	public String ofertar(long id){
		return "oferta_compra";
	}
		
	
	@RequestMapping("classificado")
	public String listaClassificados(Model model){
		FabricaDeConexoes fc = new FabricaDeConexoes();
		Connection conn = fc.getConexao();
		ClassificadoDAO cDAO = new ClassificadoDAO(conn);
		

		List<Classificado> c = cDAO.getListar();
		model.addAttribute("classificados", c);
		return "classificados";
	}
	
	@RequestMapping("formularioClassificado")
	public String formularioClassificao(){
		return "formulario_classificado";
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
