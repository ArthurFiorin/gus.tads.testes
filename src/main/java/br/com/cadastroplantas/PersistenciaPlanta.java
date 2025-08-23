package br.com.cadastroplantas;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaPlanta {

    // Pasta pra salvar os aquivos JSON
    private static final String PASTA = System.getProperty("user.dir") + "/dadosPlantas";

    public static void salvarPlanta(Planta planta) {
        Gson gson = new Gson();

        File pasta = new File(PASTA);
        if (!pasta.exists()) {
            pasta.mkdir(); // cri a pasta se não existir
        }

        String nomeArquivo = PASTA + "/" + planta.getId() + "_" + planta.getNomePopular() + ".json";

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            gson.toJson(planta, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Listar todas as plantas
    public static List<Planta> listarPlantas() {
        List<Planta> plantas = new ArrayList<>();
        File pasta = new File(PASTA);

        if (pasta.exists() && pasta.isDirectory()) {
            for (File file : pasta.listFiles()) {
                if (file.getName().endsWith(".json")) {
                    try (FileReader reader = new FileReader(file)) {
                        Planta p = new Gson().fromJson(reader, Planta.class);
                        if (p != null) {
                            plantas.add(p);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return plantas;
    }
}
