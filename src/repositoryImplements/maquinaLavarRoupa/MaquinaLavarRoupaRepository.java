package repositoryImplements.maquinaLavarRoupa;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import entities.MaquinaLavarRoupa;
import repositoryContracts.maquinaLavarRoupa.IMaquinaLavarRoupaContracts;

public class MaquinaLavarRoupaRepository implements IMaquinaLavarRoupaContracts {
    private List<MaquinaLavarRoupa> maquinasLavarRoupa = new ArrayList<MaquinaLavarRoupa>();

    public String create(MaquinaLavarRoupa maquinaLavarRoupa) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        maquinasLavarRoupa = read();

        maquinasLavarRoupa.add(maquinaLavarRoupa);

        try {
            FileWriter writer = new FileWriter("./src/database/maquinalavarroupa.json");
            gson.toJson(maquinasLavarRoupa, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Maquina de lavar roupa criada com sucesso!";
    }

    public List<MaquinaLavarRoupa> read() {
        Gson gson = new Gson();

        try {
            Reader reader = new FileReader("./src/database/maquinalavarroupa.json");
            Type type = new TypeToken<List<MaquinaLavarRoupa>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    public String update(MaquinaLavarRoupa maquinaLavarRoupa, String idMaquinaLavarRoupa) {
        maquinasLavarRoupa = read();

        for (MaquinaLavarRoupa maquinas : maquinasLavarRoupa) {
            if (maquinas.getIdMaquinaLavaRoupa().equals(idMaquinaLavarRoupa)) {
                maquinas.setMarca(maquinaLavarRoupa.getMarca());
                maquinas.setCapacidade(maquinaLavarRoupa.getCapacidade());
                maquinas.setTipo(maquinaLavarRoupa.getTipo());
                maquinas.setProgramasDeLavagem(maquinaLavarRoupa.getProgramasDeLavagem());
                maquinas.setVelocidadeDeCentrifugacao(maquinaLavarRoupa.getVelocidadeDeCentrifugacao());
                maquinas.setConsumoDeEnergia(maquinaLavarRoupa.getConsumoDeEnergia());

                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter writer = new FileWriter("./src/database/maquinalavarroupa.json");
            gson.toJson(maquinasLavarRoupa, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Maquina de lavar roupa atualizada com sucesso!";
    }

    public String delete(String idMaquinaLavarRoupa) {
        maquinasLavarRoupa = read();

        for (MaquinaLavarRoupa maquinas : maquinasLavarRoupa) {
            if (maquinas.getIdMaquinaLavaRoupa().equals(idMaquinaLavarRoupa)) {
                maquinasLavarRoupa.remove(maquinas);
                break;
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter writer = new FileWriter("./src/database/maquinalavarroupa.json");
            gson.toJson(maquinasLavarRoupa, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Maquina de lavar roupa deletada com sucesso!";
    }
}
