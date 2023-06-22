package trabalhooop.persistence;

import trabalhooop.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserPersistence implements Persistence<Usuario> {
    private static final String PATH = DIRECTORY + File.separator + "user.json"; // Caminho para o arquivo JSON


    @Override
    public void save(List<Usuario> itens) { // Função para salvar os dados em um arquivo JSON
        Gson gson = new Gson(); // Instancia um objeto Gson
        String json = gson.toJson(itens); // Converte a lista de objetos para uma string JSON

        File diretorio = new File(DIRECTORY); // Cria um objeto File para o diretório
        if (!diretorio.exists()) diretorio.mkdirs(); // Cria o diretório caso ele não exista

        Arquivo.salva(PATH, json); // Salva o arquivo
    }

    @Override
    public List<Usuario> findAll() {
        //TODO: implementar findAll
        Gson gson = new Gson(); // Instancia um objeto Gson
        String json = Arquivo.Read(PATH); // Lê o arquivo JSON

        List<Usuario> usuarios = new ArrayList<>(); // Instancia uma lista de lugares
        if (!json.trim().equals("")) { // Verifica se o arquivo não está vazio
            Type tipoLista = new TypeToken<List<Usuario>>() {
            }.getType(); // Instancia um objeto TypeToken
            usuarios = gson.fromJson(json, tipoLista); // Converte a string JSON para uma lista de objetos
            if (usuarios == null) usuarios = new ArrayList<>(); // Verifica se a lista não está vazia
        }

        return usuarios; // Retorna a lista de lugares
    }


}
