/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.List;
import Model.ClienteDAO;
import Model.Cliente;
import Model.AnimalDAO;
import Model.DAO;
import Model.Animal;
import Model.EspecieDAO;
import Model.Especie;
import Model.ExameDAO;
import Model.Exame;
import Model.TratamentoDAO;
import Model.Tratamento;
import Model.ConsultaDAO;
import Model.Consulta;
import Model.VeterinarioDAO;
import Model.Veterinario;
import java.util.Date;

/**
 *
 * @author g248301
 */
public class Main {
    
    public static void main(String[] args) {


        ClienteDAO c = ClienteDAO.getInstance();
        
        
        //c.create("Rosangela", "Grippo", "1899", "ABC@GMAIL.COM", "325344");
        //c.retrieveLast();
        // Chame métodos da instância Singleton
        List<Cliente> clientes = c.retrieveAll();
        
        for(Cliente a : clientes){
            System.out.println(a);
        }
        
        
        AnimalDAO animal = AnimalDAO.getInstance();
        
        //animal.create("Vitor", 2, "Masculino", 0, 0, 12, true);

        // Chame métodos da instância Singleton
        List<Animal> todosAnimais = animal.retrieveAll();
        for (Animal au : todosAnimais) {
            System.out.println(au);
        }

       
        
        /*deletando o último cliente:
        
        List<Cliente> clientesDeletados = c.retrieveLast();

        Cliente deleteCliente = clientesDeletados.get(0);  
       
        c.delete(deleteCliente);
        */
        EspecieDAO especie = EspecieDAO.getInstance();
        
        //especie.create("Vitor");

        // Chame métodos da instância Singleton
        List<Especie> especies = especie.retrieveAll();
        
        for(Especie es : especies){
            System.out.println(es);
        }
        
        TratamentoDAO tratamento = TratamentoDAO.getInstance();
        
        Date minhaData1 = new Date(2023 - 1900, 8, 20);
        Date minhaData2 = new Date(2023 - 1900, 9, 20);
        
        //tratamento.create(minhaData1, minhaData2);
        
        // Chame métodos da instância Singleton
        List<Tratamento> tratamentos = tratamento.retrieveAll();
        
        for(Tratamento tr : tratamentos){
            System.out.println(tr);
        }
        
        ConsultaDAO consulta = ConsultaDAO.getInstance();
        
        //consulta.create(minhaData1, "1", "2", 4, 4, 4, 4);
        
        // Chame métodos da instância Singleton
        List<Consulta> consultas = consulta.retrieveAll();
        
        for(Consulta co : consultas){
            System.out.println(co);
            consulta.delete(co);
        }
        
        VeterinarioDAO vet = VeterinarioDAO.getInstance();
        
        //consulta.create(minhaData1, "1", "2", 4, 4, 4, 4);
        
        //vet.create("Abudab", "gino.carlo02@gmail.com", "19982805098");
        // Chame métodos da instância Singleton
        List<Veterinario> vets = vet.retrieveAll();
        
        for(Veterinario v : vets){
            System.out.println(v);
        }
        
        ExameDAO exame = ExameDAO.getInstance();
        
        //exame.create("teste", 1);
        
        // Chame métodos da instância Singleton
        List<Exame> exames = exame.retrieveAll();
        
        for(Exame e : exames){
            System.out.println(e);
        }
    }
}
