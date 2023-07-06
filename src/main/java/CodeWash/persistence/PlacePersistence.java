// NOME: Gabriel de Oliveira Vieira                       MATRÍCULA: 202265029A
// NOME: Ítalo de Almeida Ribeiro                         MATRÍCULA: 202176009
// NOME: João Victor Pereira dos Anjos                    MATRÍCULA: 202176010
// NOME: Lucas Henrique de Arruda Ferreira                MATRÍCULA: 202165193AC

package CodeWash.persistence;

import CodeWash.model.Place;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class PlacePersistence implements Persistence<Place> {

    public static final String PATH = DIRECTORY + File.separator + "place.json"; // Caminho para o arquivo JSON

    @Override
    public void save(List<Place> itens) { // Função para salvar os dados em um arquivo JSON
        Gson gson = new Gson(); // Instancia um objeto Gson
        String json = gson.toJson(itens); // Converte a lista de objetos para uma string JSON

        File diretorio = new File(DIRECTORY); // Cria um objeto File para o diretório
        if (!diretorio.exists()) diretorio.mkdirs(); // Cria o diretório caso ele não exista

        Arquivo.salva(PATH, json); // Salva o arquivo
    }

    @Override
    public List<Place> findAll() {
        Gson gson = new Gson(); // Instancia um objeto Gson
        String json = Arquivo.Read(PATH); // Lê o arquivo JSON

        List<Place> places = new ArrayList<>(); // Instancia uma lista de lugares
        if (!json.trim().equals("")) { // Verifica se o arquivo não está vazio
            Type tipoLista = new TypeToken<List<Place>>() {
            }.getType(); // Instancia um objeto TypeToken
            places = gson.fromJson(json, tipoLista); // Converte a string JSON para uma lista de objetos
            if (places == null) places = new ArrayList<>(); // Verifica se a lista não está vazia
        }
        return places; // Retorna a lista de lugares

    }
}
