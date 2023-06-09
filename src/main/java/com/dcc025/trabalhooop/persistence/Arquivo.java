package com.dcc025.trabalhooop.persistence;

import java.io.*;

public class Arquivo {

    public static String Read(String filePath) { //Função para ler o arquivo
        StringBuilder content = new StringBuilder(); //StringBuilder é uma classe que permite a criação de strings mutáveis

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { //BufferedReader é uma classe que permite a leitura de arquivos
            String line; //String que armazena a linha atual do arquivo
            while ((line = reader.readLine()) != null) { //Enquanto a linha atual não for nula, a linha atual é adicionada ao StringBuilder
                content.append(line).append("\n"); //O \n é para quebrar a linha
            }
        } catch (IOException e) { //Caso ocorra algum erro, ele é printado
            //e.printStackTrace();
        }

        return content.toString(); //Retorna o conteúdo do StringBuilder como uma String
    }

    public static void salva(String filePath, String content) { //Função para salvar o arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) { //BufferedWriter é uma classe que permite a escrita de arquivos
            writer.write(content); //Escreve o conteúdo no arquivo
        } catch (IOException e) { //Caso ocorra algum erro, ele é printado
            e.printStackTrace();
        }
    }
}
