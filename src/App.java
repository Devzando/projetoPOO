import java.util.List;

import Controller.MaquinaLavarRoupaController;
import entities.MaquinaLavarRoupa;

public class App {
    public static void main(String[] args) throws Exception {
        MaquinaLavarRoupa maquinaLavarRoupa = new MaquinaLavarRoupa(
            "marca gabriel", 
            "capacidade", 
            "tipo", 
            "programasDeLavagem", 
            "velocidadeDeCentrifugacao", 
            "consumoDeEnergia"
        );
        MaquinaLavarRoupaController maquinaLavarRoupaController = new MaquinaLavarRoupaController();

        //criando uma maquina de lavar roupa
        // String result = maquinaLavarRoupaController.handleCreateMaquinaLavarRoupa(maquinaLavarRoupa);
        // System.out.println(result);

        //lendo todas as maquinas de lavar roupa
        // List<MaquinaLavarRoupa> result = maquinaLavarRoupaController.handleReadMaquinaLavarRoupa();
        // for (MaquinaLavarRoupa maquinas : result) {
        //     System.out.println(maquinas.getMarca());
        // }

        //atualizando uma maquina de lavar roupa
        // List<MaquinaLavarRoupa> result1 = maquinaLavarRoupaController.handleReadMaquinaLavarRoupa();
        // result1.get(0).setMarca("marca gabriel 2");
        // String result2 = maquinaLavarRoupaController.handleUpdateMaquinaLavarRoupa(result1.get(0), "315c234b-076d-45e2-82b0-a67e43df3aa3");

        // System.out.println(result2);

        String result = maquinaLavarRoupaController.handleDeleteMaquinaLavarRoupa("315c234b-076d-45e2-82b0-a67e43df3aa3");
        System.out.println(result);

    }
}
