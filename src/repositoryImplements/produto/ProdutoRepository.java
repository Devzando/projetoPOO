package repositoryImplements.produto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import entities.Produto;
import repositoryContracts.produto.IProdutoContracts;

public class ProdutoRepository<T> implements IProdutoContracts {
    private List<Produto> produtos = new ArrayList<Produto>();

    public String create(Produto produto) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        produtos = read();

        if(produtos == null){
            produtos = new ArrayList<Produto>();
        }

        produtos.add(produto);

        try {
            FileWriter writer = new FileWriter("./src/database/produto.json");
            gson.toJson(produtos, writer);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Produto criado com sucesso!";
    }

    public List<Produto> read() {
        Gson gson = new Gson();

        try {
            Reader reader = new FileReader("./src/database/produto.json");
            Type type = new TypeToken<List<T>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
