package com.tecnocracia.plutons.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tecnocracia.plutons.store.model.Produto;
import com.tecnocracia.plutons.store.repository.Produtos;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	private static final String CADASTRO_VIEW = "CadastroProduto";

	@Autowired
	private Produtos produtos;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Produto());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Produto produto, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}

		try {
			produtos.save(produto);
			attributes.addFlashAttribute("mensagem", "Título salvo com sucesso!");
			return "redirect:/produtos/novo";
		} catch (IllegalArgumentException e) {
			
			return CADASTRO_VIEW;
		}
	}

	@RequestMapping
	public ModelAndView pesquisar() {
		List<Produto> todosProdutos = produtos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaProdutos");
		mv.addObject("produtos", todosProdutos);
		return mv;
	}
}