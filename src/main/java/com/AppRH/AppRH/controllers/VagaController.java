package com.AppRH.AppRH.controllers;

import com.AppRH.AppRH.models.Candidato;
import com.AppRH.AppRH.models.Vaga;
import com.AppRH.AppRH.repository.CandidatoRepository;
import com.AppRH.AppRH.repository.VagaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VagaController {

    @Autowired
    private VagaRepository vr;
    @Autowired
    private CandidatoRepository cr;

    //CADASTRA VAGA
    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
    public String form(){
        return "vaga/formVaga";
    }

    // TRATAMENTO DE ERRO DE PREENCHIMENTO EM CASDASTRAS VAGA
    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
    public String form(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes){

        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "verifique os campos");
            return "redirect:/cadastrarVaga";
        }

        vr.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada!");

        return "redirect:/cadastrarVaga";
    }

    //LISTA VAGAS
    @RequestMapping(value = "/vagas")
    public ModelAndView listaVagas(){
        ModelAndView mv = new ModelAndView("vaga/listaVaga");
        Iterable<Vaga>vagas = vr.findAll();
        mv.addObject("vagas", vagas);
        return mv;
    }

    // BUSCA NO BANCO
    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesVaga(@PathVariable("codigo") long codigo){
        Vaga vaga = vr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("vaga/detalhesVaga");
        mv.addObject("vaga", vaga);

        Iterable<Candidato>candidatos = cr.findByVaga(vaga);
        mv.addObject("candidatos", candidatos);

        return mv;

    }

    // metodo pra deletar a vaga

    @RequestMapping("/deletarVaga")
    public String deletarVaga(long codigo)
    {
        Vaga vaga = vr.findByCodigo(codigo);
        vr.delete(vaga);
        return "redirect:/vagas";
    }
    // ADICIONAR CANDIDATO

    @RequestMapping(value = "/{codigo}" , method = RequestMethod.POST)
    public String detalhesVagaPost(@PathVariable("codigo") long codigo, @Valid Candidato candidato,
                                   BindingResult result, RedirectAttributes attributes)
    {
        if (result.hasErrors())
        {
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "redirect:/{codigo}";
        }
        // rg duplicado, teste de consistencia

        if (cr.findByRg(candidato.getRg()) != null)
        {
            attributes.addFlashAttribute("mensagem_erro", "RG duplicado");
            return "redirect:/{codigo}";
        }

        Vaga vaga = vr.findByCodigo(codigo);
        candidato.setVaga(vaga);
        cr.save(candidato);
        attributes.addFlashAttribute("mensagem", "Candidato adicionado com sucesso");
        return "redirect:/{codigo}";
    }

    //DELETA CANDIDATO PELO RG

    @RequestMapping("/deletarCandidato")
    public String deletarCandidato(String rg)
    {
        Candidato candidato = cr.findByRg(rg);
        Vaga vaga = candidato.getVaga();
        String codigo = "" + vaga.getCodigo();

        cr.delete(candidato);

        return "redirect:/" + codigo;
    }

    // metodos que atualizam a vaga
    // Formulario de edição de vaga

    @RequestMapping(value ="editar-vaga", method = RequestMethod.GET)
    public ModelAndView editarVaga(long codigo)
    {
        Vaga vaga = vr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("vaga/update-vaga");
        mv.addObject("vaga",vaga);

        return mv;
    }

    // UPDATE VAGA

    @RequestMapping(value = "editar-vaga", method = RequestMethod.POST)
    public String updateVaga(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes)

    {
        vr.save(vaga);
        attributes.addFlashAttribute("success" , "vaga alterada com sucesso" );
        long codigoLong = vaga.getCodigo();
        String codigo = "" +codigoLong;
        return "redirect:/" + codigo;
    }





}
