package br.ufc.controller;

import java.sql.Timestamp;
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
	public String formularioClassificao() {
		return "classificado/cadastrar_classificado";
	}

	@RequestMapping("cadastrarClassificado")
	public String addClassificado(HttpSession session, Classificado classificado) {
		classificadoDAO.add(classificado);
		System.out.println("aqui controler classificado ");

		return "classificado/classificado_adicionado";

	}

	@RequestMapping("listarClassificados")
	public String listaClassificados(Model model) {
		List<Classificado> classificados = classificadoDAO.listar();
		model.addAttribute("classificados", classificados);
		System.out.println("listar cla : ");
		return "classificado/listar_classificados";
	}

	@RequestMapping("inserirOfertaForm")
	public String inserirOfertaForm(Classificado classificado, Model model) {
		Classificado cls = this.classificadoDAO.buscar(classificado);
		model.addAttribute("classificado", cls);

		return "classificado/inserir_oferta";
	}

	@RequestMapping("inserirOferta")
	public String inserirOferta(float oferta, long id, long idUser, Model model) {
		Classificado cls = this.classificadoDAO.classificadoId(id);

		if (oferta > cls.getPreco() && (oferta > cls.getMelhor_oferta())) {
			cls.setData_oferta(new Timestamp(System.currentTimeMillis()));

			cls.setAutor(usuarioDAO.getUserId(idUser));
			cls.setMelhor_oferta(oferta);
			return "redirect:listarClassificados";
		}
		// return "redirect:inserirOfertaForm"; // nao funciona pois precisa do
		// id
		return "redirect:listarClassificados";

	}

	@RequestMapping("deletarClassificado")
	public String deletarClassificado(Classificado u) {

		classificadoDAO.deletar(u);

		return "redirect:listarClassificados";
	}

}
