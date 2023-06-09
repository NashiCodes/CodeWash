package com.dcc025.trabalhooop.persistence;

import com.dcc025.trabalhooop.model.Usuario;
import java.lang.*;

import com.google.gson.Gson;
import java.io.*;
import java.util.*;

public class UserPersistence implements Persistence<Usuario>{
    private static final String PATH = DIRECTORY + File.separator + "user.txt";
    @Override
    public void save(List<Usuario> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }
}
